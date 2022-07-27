package com.tds.server;

public class LocaleData {

    private int localeId;
    private String name;
    private int phoneNumberCount;
    private Geometry geometry;

    public LocaleData(int newId, String newName, int count, Geometry whereLocated ) {
        this.localeId = newId;
        this.name = newName;
        this.phoneNumberCount = count;
        this.geometry = whereLocated;
    }

    public LocaleData() {}

    public int getLocaleId() {
        return localeId;
    }

    public void setLocaleId(int localeId) {
        this.localeId = localeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumberCount() {
        return phoneNumberCount;
    }

    public void setPhoneNumberCount(int phoneNumberCount) {
        this.phoneNumberCount = phoneNumberCount;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }
}
