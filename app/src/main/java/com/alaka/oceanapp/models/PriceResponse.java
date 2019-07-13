package com.alaka.oceanapp.models;

public class PriceResponse {
    private String name;
    private String onem;
    private String threem;
    private String sixm;
    private String oney;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOnem() {
        return onem;
    }

    public void setOnem(String onem) {
        this.onem = onem;
    }

    public String getThreem() {
        return threem;
    }

    public void setThreem(String threem) {
        this.threem = threem;
    }

    public String getSixm() {
        return sixm;
    }

    public void setSixm(String sixm) {
        this.sixm = sixm;
    }

    public String getOney() {
        return oney;
    }

    public void setOney(String oney) {
        this.oney = oney;
    }

    public PriceResponse(String name, String onem, String threem, String sixm, String oney) {
        this.name = name;
        this.onem = onem;
        this.threem = threem;
        this.sixm = sixm;
        this.oney = oney;
    }
}
