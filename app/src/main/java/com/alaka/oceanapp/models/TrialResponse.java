package com.alaka.oceanapp.models;

public class TrialResponse {

    private  String tname;
    private  String tphone;

    private  String ttype;
    private  String tdate;


    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTphone() {
        return tphone;
    }

    public void setTphone(String tphone) {
        this.tphone = tphone;
    }

    public String getTtype() {
        return ttype;
    }

    public void setTtype(String ttype) {
        this.ttype = ttype;
    }

    public String getTdate() {
        return tdate;
    }

    public void setTdate(String tdate) {
        this.tdate = tdate;
    }


    public TrialResponse(String tname, String tphone, String ttype, String tdate) {
        this.tname = tname;
        this.tphone = tphone;
        this.ttype = ttype;
        this.tdate = tdate;
    }


}
