package com.defch.instademo.model;

import com.defch.instademo.model.inspection.Inspection;
import com.defch.instademo.model.insurance.InsuranceQuote;
import com.defch.instademo.model.technicalSpecs.TechnicalSpecs;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by DiegoFranco on 5/12/15.
 */
public class InstaModel extends RealmObject {

    private String id;
    private String vin;
    private String mileage;
    private String phone;
    private String carfaxUrl;
    private String shortUrl;
    private String description;
    private String transmissionType;
    private String sellerDescription;
    private String createdAt;
    private String updatedAt;
    private RealmList<Categories> categories;
    private RealmList<Images> images;
    private RealmList<Smogs> smogs;
    private RealmList<Feature> features;
    private Make make;
    private VModel model;
    private ModelYear modelYear;
    private Style style;
    private RealmList<Question> questions;
    private String desc;
    private boolean priceNotification;
    private String price;
    private String status;
    private RealmList<Recall> recalls;
    private RealmList<BackgroundCheck> backgroundChecks;
    private Inspection inspection;
    private String pricingEstimate;
    private Owner owner;
    private Address address;
    private TechnicalSpecs technicalSpecs;
    private RealmList<InsuranceQuote> insuranceQuotes;

    public InstaModel() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCarfaxUrl() {
        return carfaxUrl;
    }

    public void setCarfaxUrl(String carfaxUrl) {
        this.carfaxUrl = carfaxUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    public String getSellerDescription() {
        return sellerDescription;
    }

    public void setSellerDescription(String sellerDescription) {
        this.sellerDescription = sellerDescription;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public RealmList<Categories> getCategories() {
        return categories;
    }

    public void setCategories(RealmList<Categories> categories) {
        this.categories = categories;
    }

    public RealmList<Images> getImages() {
        return images;
    }

    public void setImages(RealmList<Images> images) {
        this.images = images;
    }

    public RealmList<Smogs> getSmogs() {
        return smogs;
    }

    public void setSmogs(RealmList<Smogs> smogs) {
        this.smogs = smogs;
    }

    public RealmList<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(RealmList<Feature> features) {
        this.features = features;
    }

    public Make getMake() {
        return make;
    }

    public void setMake(Make make) {
        this.make = make;
    }

    public VModel getModel() {
        return model;
    }

    public void setModel(VModel model) {
        this.model = model;
    }

    public ModelYear getModelYear() {
        return modelYear;
    }

    public void setModelYear(ModelYear modelYear) {
        this.modelYear = modelYear;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public RealmList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(RealmList<Question> questions) {
        this.questions = questions;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isPriceNotification() {
        return priceNotification;
    }

    public void setPriceNotification(boolean priceNotification) {
        this.priceNotification = priceNotification;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public RealmList<Recall> getRecalls() {
        return recalls;
    }

    public void setRecalls(RealmList<Recall> recalls) {
        this.recalls = recalls;
    }

    public RealmList<BackgroundCheck> getBackgroundChecks() {
        return backgroundChecks;
    }

    public void setBackgroundChecks(RealmList<BackgroundCheck> backgroundChecks) {
        this.backgroundChecks = backgroundChecks;
    }

    public Inspection getInspection() {
        return inspection;
    }

    public void setInspection(Inspection inspection) {
        this.inspection = inspection;
    }

    public String getPricingEstimate() {
        return pricingEstimate;
    }

    public void setPricingEstimate(String pricingEstimate) {
        this.pricingEstimate = pricingEstimate;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public TechnicalSpecs getTechnicalSpecs() {
        return technicalSpecs;
    }

    public void setTechnicalSpecs(TechnicalSpecs technicalSpecs) {
        this.technicalSpecs = technicalSpecs;
    }

    public RealmList<InsuranceQuote> getInsuranceQuotes() {
        return insuranceQuotes;
    }

    public void setInsuranceQuotes(RealmList<InsuranceQuote> insuranceQuotes) {
        this.insuranceQuotes = insuranceQuotes;
    }
}
