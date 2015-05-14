package com.defch.instademo.threads;

import android.content.Context;
import android.os.Message;
import android.util.Log;

import com.defch.instademo.hdlr.CompleteHandler;
import com.defch.instademo.hdlr.InitHandler;
import com.defch.instademo.model.Address;
import com.defch.instademo.model.BackgroundCheck;
import com.defch.instademo.model.Categories;
import com.defch.instademo.model.Feature;
import com.defch.instademo.model.Images;
import com.defch.instademo.model.InstaModel;
import com.defch.instademo.model.Make;
import com.defch.instademo.model.ModelYear;
import com.defch.instademo.model.Owner;
import com.defch.instademo.model.Question;
import com.defch.instademo.model.Smogs;
import com.defch.instademo.model.Style;
import com.defch.instademo.model.VModel;
import com.defch.instademo.model.inspection.Inspection;
import com.defch.instademo.model.inspection.Item;
import com.defch.instademo.model.inspection.Section;
import com.defch.instademo.model.inspection.Technician;
import com.defch.instademo.model.insurance.InsuranceQuote;
import com.defch.instademo.model.technicalSpecs.Categorie;
import com.defch.instademo.model.technicalSpecs.Engine;
import com.defch.instademo.model.technicalSpecs.MPG;
import com.defch.instademo.model.technicalSpecs.TechnicalSpecs;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by DiegoFranco on 5/12/15.
 */
public class RequestThread implements Runnable {

    private InitHandler initHandler;
    private CompleteHandler completeHandler;
    private Context context;

    public RequestThread(Context context, InitHandler initHandler, CompleteHandler completeHandler) {
        this.context = context;
        this.initHandler = initHandler;
        this.completeHandler = completeHandler;
    }

    @Override
    public void run() {
        Message msg = new Message();
        if(initHandler != null) {
            initHandler.sendEmptyMessage(200);
        }
        try {
            Realm realm = Realm.getInstance(context);
            RealmResults<InstaModel> instaModelArrayList = realm.where(InstaModel.class).findAll();
            InstaModel iModel = null;

            //Connection code
            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse response;
            String responseString = null;
            response = httpclient.execute(new HttpGet("https://api.instamotor.com/v2/mp/vehicles"));
            StatusLine statusLine = response.getStatusLine();
            if(statusLine.getStatusCode() == HttpStatus.SC_OK){
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            response.getEntity().writeTo(out);
            responseString = out.toString();
            //end Connection code

                    JSONArray jsonA = new JSONArray(responseString);
                    for(int i = 0; i < jsonA.length() - 1730; i++){
                        Log.i("Thread", "vehicles: " + (jsonA.length() - 1730));
                        JSONObject json = jsonA.getJSONObject(i);

                        InstaModel realmModel = realm.where(InstaModel.class).equalTo("id", json.getString("id")).findFirst();
                        if(realmModel != null) {
                            realm.beginTransaction();
                            if(!realmModel.getId().equalsIgnoreCase(json.getString("id"))) {
                                realmModel.setId(json.getString("id"));
                            }
                            if(!realmModel.getVin().equalsIgnoreCase(json.getString("vin"))) {
                                realmModel.setVin(json.getString("vin"));
                            }

                            //change values in realm
                            if(realmModel.getPrice().equalsIgnoreCase(json.getString("price"))) {
                                realmModel.setPrice("123456789");
                            } else {
                                realmModel.setPrice(json.getString("price"));
                            }

                        } else {
                            realm.beginTransaction();
                            iModel = realm.createObject(InstaModel.class);
                            try {
                                if (!json.isNull("id")) {
                                    iModel.setId(json.getString("id"));
                                }
                                if(!json.isNull("vin")) {
                                    iModel.setVin(json.getString("vin"));
                                }
                                if(!json.isNull("mileage")) {
                                    iModel.setMileage(json.getString("mileage"));
                                }
                                if(!json.isNull("phone")) {
                                    iModel.setPhone(json.getString("phone"));
                                }
                                if(!json.isNull("carfax_url")) {
                                    iModel.setCarfaxUrl(json.getString("carfax_url"));
                                }
                                if(!json.isNull("short_url")) {
                                    iModel.setShortUrl(json.getString("short_url"));
                                }
                                if(!json.isNull("description")) {
                                    iModel.setDescription(json.getString("description"));
                                }
                                if(!json.isNull("transmission_type")) {
                                    iModel.setTransmissionType(json.getString("transmission_type"));
                                }
                                if(!json.isNull("seller_description")) {
                                    iModel.setSellerDescription(json.getString("seller_description"));
                                }
                                if(!json.isNull("created_at")) {
                                    iModel.setCreatedAt(json.getString("created_at"));
                                }
                                if(!json.isNull("updated_at")) {
                                    iModel.setUpdatedAt(json.getString("updated_at"));
                                }
                                if(!json.isNull("categories")) {
                                    JSONArray jsonArray = json.getJSONArray("categories");
                                    for(int j = 0; j < jsonArray.length(); j++) {
                                        JSONObject js = jsonArray.getJSONObject(j);
                                        Categories cat = realm.createObject(Categories.class);
                                        if(!js.isNull("id")) {
                                            cat.setId(js.getString("id"));
                                        }
                                        if(!js.isNull("slug")) {
                                            cat.setSlug(js.getString("slug"));
                                        }
                                        if(!js.isNull("icon_url")) {
                                            cat.setIconUrl(js.getString("icon_url"));
                                        }
                                        if(!js.isNull("cover_image_url")) {
                                            cat.setCoverUrl(js.getString("cover_image_url"));
                                        }
                                        iModel.getCategories().add(cat);
                                    }
                                }
                                if(!json.isNull("images")) {
                                    JSONArray jsonArray = json.getJSONArray("images");
                                    for(int j = 0; j < jsonArray.length(); j++) {
                                        JSONObject js = jsonArray.getJSONObject(j);
                                        Images img = realm.createObject(Images.class);
                                        if(!js.isNull("id")) {
                                            img.setId(js.getString("id"));
                                        }
                                        if(!js.isNull("uri")) {
                                            img.setUri(js.getString("uri"));
                                        }
                                        if(!js.isNull("image_type")) {
                                            img.setImageType(js.getString("image_type"));
                                        }
                                        if(!js.isNull("vehicle_id")) {
                                            img.setVehicleId(js.getString("vehicle_id"));
                                        }
                                        iModel.getImages().add(img);
                                    }
                                }
                                if(!json.isNull("smogs")) {
                                    JSONArray jsonArray = json.getJSONArray("smogs");
                                    for(int j = 0; j < jsonArray.length(); j++) {
                                        JSONObject js = jsonArray.getJSONObject(j);
                                        Smogs smog = realm.createObject(Smogs.class);
                                        if(!js.isNull("id")) {
                                            smog.setId(js.getString("id"));
                                        }
                                        if(!js.isNull("photo_uri")) {
                                            smog.setPhotoUri(js.getString("photo_uri"));
                                        }
                                        iModel.getSmogs().add(smog);
                                    }
                                }
                                if(!json.isNull("features")) {
                                    JSONArray jsonArray = json.getJSONArray("features");
                                    for(int j = 0; j < jsonArray.length(); j++) {
                                        JSONObject js = jsonArray.getJSONObject(j);
                                        Feature feature = realm.createObject(Feature.class);
                                        if(!js.isNull("id")) {
                                            feature.setId(js.getString("id"));
                                        }
                                        if(!js.isNull("name")) {
                                            feature.setName(js.getString("name"));
                                        }
                                        if(!js.isNull("icon_url")) {
                                            feature.setIconUrl(js.getString("icon_url"));
                                        }
                                        if(!js.isNull("vehicle_feature_category_name")) {
                                            feature.setVehicleFeature(js.getString("vehicle_feature_category_name"));
                                        }
                                        iModel.getFeatures().add(feature);
                                    }
                                }
                                if(!json.isNull("make")) {
                                    JSONObject js = json.getJSONObject("make");
                                    Make make = realm.createObject(Make.class);
                                    if(!js.isNull("id")) {
                                        make.setId(js.getString("id"));
                                    }
                                    if(!js.isNull("name")) {
                                        make.setName(js.getString("name"));
                                    }
                                    if(!js.isNull("edmund_id")) {
                                        make.setEdmundId(js.getString("edmund_id"));
                                    }
                                    iModel.setMake(make);
                                }
                                if(!json.isNull("model")) {
                                    JSONObject js = json.getJSONObject("model");
                                    VModel vModel = realm.createObject(VModel.class);
                                    if(!js.isNull("id")) {
                                        vModel.setId(js.getString("id"));
                                    }
                                    if(!js.isNull("name")) {
                                        vModel.setName(js.getString("name"));
                                    }
                                    if(!js.isNull("edmund_id")) {
                                        vModel.setEdmundId(js.getString("edmund_id"));
                                    }
                                    if(!js.isNull("make_id")) {
                                        vModel.setMake_id(js.getString("make_id"));
                                    }
                                    iModel.setModel(vModel);
                                }
                                if(!json.isNull("model_year")) {
                                    JSONObject js = json.getJSONObject("model_year");
                                    ModelYear modelYear = realm.createObject(ModelYear.class);
                                    if(!js.isNull("id")) {
                                        modelYear.setId(js.getString("id"));
                                    }
                                    if(!js.isNull("year")) {
                                        modelYear.setYear(js.getString("year"));
                                    }
                                    if(!js.isNull("edmund_id")) {
                                        modelYear.setEdmundId(js.getString("edmund_id"));
                                    }
                                    if(!js.isNull("model_id")) {
                                        modelYear.setModelId(js.getString("model_id"));
                                    }
                                    iModel.setModelYear(modelYear);
                                }
                                if(!json.isNull("style")) {
                                    JSONObject js = json.getJSONObject("style");
                                    Style style = realm.createObject(Style.class);
                                    if(!js.isNull("id")) {
                                        style.setId(js.getString("id"));
                                    }
                                    if(!js.isNull("name")) {
                                        style.setName(js.getString("name"));
                                    }
                                    if(!js.isNull("edmund_id")) {
                                        style.setEdmundId(js.getString("edmund_id"));
                                    }
                                    if(!js.isNull("trim")) {
                                        style.setTrim(js.getString("trim"));
                                    }
                                    if(!js.isNull("model_year_id")) {
                                        style.setModelYearId(js.getString("model_year_id"));
                                    }
                                    iModel.setStyle(style);
                                }
                                if(!json.isNull("questions")) {
                                    JSONArray jsonArray = json.getJSONArray("questions");
                                    for(int j = 0; j < jsonArray.length(); j++) {
                                        JSONObject js = jsonArray.getJSONObject(j);
                                        Question question = realm.createObject(Question.class);
                                        if(!js.isNull("id")) {
                                            question.setId(js.getString("id"));
                                        }
                                        if(!js.isNull("question")) {
                                            question.setQuestion(js.getString("question"));
                                        }
                                        iModel.getQuestions().add(question);
                                    }
                                }
                                if(!json.isNull("desc")) {
                                    iModel.setDesc(json.getString("desc"));
                                }
                                if(!json.isNull("price_watch_push_notification_allowed")) {
                                    iModel.setPriceNotification(json.getBoolean("price_watch_push_notification_allowed"));
                                }
                                if(!json.isNull("price")) {
                                    iModel.setPrice("Price: " + json.getString("price"));
                                }
                                if(!json.isNull("status")) {
                                    iModel.setStatus(json.getString("status"));
                                }
                                if(!json.isNull("vehicle_background_checks")) {
                                    JSONArray jsonArray = json.getJSONArray("vehicle_background_checks");
                                    for(int j = 0; j < jsonArray.length(); j++) {
                                        JSONObject js = jsonArray.getJSONObject(j);
                                        BackgroundCheck check = realm.createObject(BackgroundCheck.class);
                                        if(!js.isNull("id")) {
                                            check.setId(js.getString("id"));
                                        }
                                        if(!js.isNull("title")) {
                                            check.setTitle(js.getString("title"));
                                        }
                                        if(!js.isNull("check_description")) {
                                            check.setcDescription(js.getString("check_description"));
                                        }
                                        if(!js.isNull("passed")) {
                                            check.setPassed(js.getBoolean("passed"));
                                        }
                                        if(!js.isNull("priority")) {
                                            check.setPriority(js.getInt("priority"));
                                        }
                                        iModel.getBackgroundChecks().add(check);
                                    }
                                }
                                if(!json.isNull("inspection")) {
                                    JSONObject jsInspection = json.getJSONObject("inspection");
                                    Inspection inspection = realm.createObject(Inspection.class);
                                    if(!jsInspection.isNull("summary")) {
                                        inspection.setSummary(jsInspection.getString("summary"));
                                    }
                                    if(!jsInspection.isNull("technician")) {
                                        JSONObject jsTechnician = jsInspection.getJSONObject("technician");
                                        Technician technician = realm.createObject(Technician.class);
                                        if(!jsTechnician.isNull("first-name")) {
                                            technician.setFirstName(jsTechnician.getString("first-name"));
                                        }
                                        if(!jsTechnician.isNull("last-name")) {
                                            technician.setLastName(jsTechnician.getString("last-name"));
                                        }
                                        if(!jsTechnician.isNull("certifications")) {
                                            technician.setCertifications(jsTechnician.getString("certifications"));
                                        }
                                        if(!jsTechnician.isNull("photo_url")) {
                                            technician.setPhotoUrl(jsTechnician.getString("photo_url"));
                                        }
                                        inspection.setTechnician(technician);
                                    }
                                    if(!jsInspection.isNull("sections")) {
                                        JSONArray jsonArray = jsInspection.getJSONArray("sections");
                                        for(int j = 0; j < jsonArray.length(); j++) {
                                            JSONObject js = jsonArray.getJSONObject(j);
                                            Section section = realm.createObject(Section.class);

                                            if(!js.isNull("key")) {
                                                section.setKey(js.getString("key"));
                                            }
                                            if(!js.isNull("items")) {
                                                JSONArray jsArray = js.getJSONArray("items");
                                                for(int k = 0; k < jsArray.length(); k++) {
                                                    JSONObject jsI = jsArray.getJSONObject(k);
                                                    Item item = realm.createObject(Item.class);
                                                    if(!jsI.isNull("key")) {
                                                        item.setKey(jsI.getString("key"));
                                                    }
                                                    if(!jsI.isNull("value")) {
                                                        item.setValue(jsI.getString("value"));
                                                    }
                                                    section.getItems().add(item);
                                                }
                                            }

                                            inspection.getSections().add(section);
                                        }
                                    }


                                    iModel.setInspection(inspection);
                                }
                                if(!json.isNull("pricing_estimate")) {
                                    iModel.setPricingEstimate(json.getString("pricing_estimate"));
                                }
                                if(!json.isNull("inspections")) {
                                    //to do something
                                }
                                if(!json.isNull("owner")) {
                                    JSONObject js = json.getJSONObject("owner");
                                    Owner owner = realm.createObject(Owner.class);
                                    if(!js.isNull("id")) {
                                        owner.setId(js.getString("id"));
                                    }
                                    if(!js.isNull("first_name")) {
                                        owner.setFirstName(js.getString("first_name"));
                                    }
                                    if(!js.isNull("last_name")) {
                                        owner.setLastName(js.getString("last_name"));
                                    }
                                    if(!js.isNull("photo_url")) {
                                        owner.setPhotoUrl(js.getString("photo_url"));
                                    }
                                    iModel.setOwner(owner);
                                }
                                if(!json.isNull("address")) {
                                    JSONObject js = json.getJSONObject("address");
                                    Address address = realm.createObject(Address.class);
                                    if(!js.isNull("id")) {
                                        address.setId(js.getString("id"));
                                    }
                                    if(!js.isNull("availability")) {
                                        address.setAvalability(js.getString("availability"));
                                    }
                                    if(!js.isNull("city")) {
                                        address.setCity(js.getString("city"));
                                    }
                                    if(!js.isNull("state")) {
                                        address.setState(js.getString("state"));
                                    }
                                    if(!js.isNull("zipcode")) {
                                        address.setZipcode(js.getString("zipcode"));
                                    }
                                    if(!js.isNull("latitude")) {
                                        address.setLatitude(js.getString("latitude"));
                                    }
                                    if(!js.isNull("longitude")) {
                                        address.setLongitude(js.getString("longitude"));
                                    }
                                    iModel.setAddress(address);
                                }
                                if(!json.isNull("technical_specs")) {
                                    JSONObject jsTS = json.getJSONObject("technical_specs");
                                    TechnicalSpecs technicalSpecs = realm.createObject(TechnicalSpecs.class);
                                    if(!jsTS.isNull("engine")) {
                                        JSONObject jsEngine = json.getJSONObject("engine");
                                        Engine engine = realm.createObject(Engine.class);
                                        if(!jsEngine.isNull("id")) {
                                            engine.setId(jsEngine.getString("id"));
                                        }
                                        if(!jsEngine.isNull("name")) {
                                            engine.setName(jsEngine.getString("name"));
                                        }
                                        if(!jsEngine.isNull("type")) {
                                            engine.setType(jsEngine.getString("type"));
                                        }
                                        technicalSpecs.setEngine(engine);
                                    }
                                    if(!jsTS.isNull("categories")) {
                                        JSONObject jsCat = json.getJSONObject("categories");
                                        Categorie cat = realm.createObject(Categorie.class);
                                        if(!jsCat.isNull("market")) {
                                            cat.setMarket(jsCat.getString("market"));
                                        }
                                        if(!jsCat.isNull("EPAClass")) {
                                            cat.setClassEPA(jsCat.getString("EPAClass"));
                                        }
                                        if(!jsCat.isNull("vehicleType")) {
                                            cat.setVehicleType(jsCat.getString("vehicleType"));
                                        }
                                        technicalSpecs.setCategorie(cat);
                                    }
                                    if(!jsTS.isNull("mpg")) {
                                        JSONObject jsMpg = json.getJSONObject("mpg");
                                        MPG mpg = realm.createObject(MPG.class);
                                        if(!jsMpg.isNull("id")) {
                                            mpg.setId(jsMpg.getString("id"));
                                        }
                                        if(!jsMpg.isNull("city")) {
                                            mpg.setCity(jsMpg.getString("city"));
                                        }
                                        if(!jsMpg.isNull("edmund_id")) {
                                            mpg.setHighway(jsMpg.getString("highway"));
                                        }
                                        technicalSpecs.setMpg(mpg);
                                    }
                                    iModel.setTechnicalSpecs(technicalSpecs);
                                }
                                if(!json.isNull("insurance_quotes")) {
                                    JSONArray jsonArray = json.getJSONArray("insurance_quotes");
                                    for(int j = 0; j < jsonArray.length(); j++) {
                                        JSONObject js = jsonArray.getJSONObject(j);
                                        InsuranceQuote quote = realm.createObject(InsuranceQuote.class);
                                        if(!js.isNull("id")) {
                                            quote.setId(js.getString("id"));
                                        }
                                        if(!js.isNull("user_id")) {
                                            quote.setUserId(js.getString("user_id"));
                                        }
                                        if(!js.isNull("cost")) {
                                            quote.setCost(js.getString("cost"));
                                        }

                                        iModel.getInsuranceQuotes().add(quote);
                                    }
                                }


                            }catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        realm.commitTransaction();
                    }

                    out.close();
                    RealmResults<InstaModel> resultList = realm.where(InstaModel.class).findAll();
                    if(resultList.size() > 0) {
                        msg.what = 200;
                        msg.obj = resultList;
                    }
                } else{
                    response.getEntity().getContent().close();
                    throw new IOException(statusLine.getReasonPhrase());
                }
            } catch (ClientProtocolException e) {
            } catch (IOException e) {
            } catch (JSONException e) {
                e.printStackTrace();
            }

        if(completeHandler != null) {
            completeHandler.sendMessage(msg);
        }
    }
}
