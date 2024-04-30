package com.staic.oslomet_data1700_oblig3;
//implements Comparable
public class Bestilling{
    private String film;
    private String antall;
    private String fornavn;
    private String etternavn;
    private String tel;
    private String mail;

    public Bestilling(String film, String antall, String fornavn, String etternavn, String tel, String mail){
        this.film = film;
        this.antall = antall;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.tel = tel;
        this.mail = mail;
    }

    public Bestilling(){
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public String getAntall() {
        return antall;
    }

    public void setAntall(String antall) {
        this.antall = antall;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    // @Override
    // public int compareTo(Object o) {return 0;}
}
