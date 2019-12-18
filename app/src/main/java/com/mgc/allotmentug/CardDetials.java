package com.mgc.allotmentug;

public class CardDetials {

    private String registerno;
    private String name;
    private String verify;

    public CardDetials() {
    }

    public CardDetials(String registerno, String name,String verify) {
        this.registerno = registerno;
        this.name = name;
        this.verify=verify;
    }

    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
    }

    public String getRegisterno() {
        return registerno;
    }

    public void setRegisterno(String registerno) {
        this.registerno = registerno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
