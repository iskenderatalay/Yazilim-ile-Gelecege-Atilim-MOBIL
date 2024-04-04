package com.xzcorp.ders10;

public class Notlar {
    private String notId,notIcerik;

    Notlar(String notId,String notIcerik){
        this.notId=notId;
        this.notIcerik=notIcerik;
    }

    public String getNotId() {
        return notId;
    }

    public void setNotId(String notId) {
        this.notId = notId;
    }

    public String getNotIcerigi() {
        return notIcerik;
    }

    public void setNotIcerigi(String notIcerigi) {
        this.notIcerik = notIcerigi;
    }
}
