package com.example.lab04;

import javax.persistence.*;

@Entity
public class Przesylka {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String imieNadawcy;

    private String nazwiskoNadawcy;

    private String imieOdbiorcy;

    private String nazwiskoOdbiorcy;

    @ManyToOne
    private Adres adresNadawcy;

    @ManyToOne
    private Adres adresOdbiorcy;

    private boolean wydana;

    private boolean wTransporcie;

    private Integer nrUrzedu;


    public Przesylka(String imieNadawcy, String nazwiskoNadawcy, String imieOdbiorcy, String nazwiskoOdbiorcy, Adres adresNadawcy, Adres adresOdbiorcy, Integer nrUrzedu) {
        this.imieNadawcy = imieNadawcy;
        this.nazwiskoNadawcy = nazwiskoNadawcy;
        this.imieOdbiorcy = imieOdbiorcy;
        this.nazwiskoOdbiorcy = nazwiskoOdbiorcy;
        this.adresNadawcy = adresNadawcy;
        this.adresOdbiorcy = adresOdbiorcy;
        this.nrUrzedu = nrUrzedu;
        this.wTransporcie=false;
        this.wydana=false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImieNadawcy() {
        return imieNadawcy;
    }

    public void setImieNadawcy(String imieNadawcy) {
        this.imieNadawcy = imieNadawcy;
    }

    public String getNazwiskoNadawcy() {
        return nazwiskoNadawcy;
    }

    public void setNazwiskoNadawcy(String nazwiskoNadawcy) {
        this.nazwiskoNadawcy = nazwiskoNadawcy;
    }

    public String getImieOdbiorcy() {
        return imieOdbiorcy;
    }

    public void setImieOdbiorcy(String imieOdbiorcy) {
        this.imieOdbiorcy = imieOdbiorcy;
    }

    public String getNazwiskoOdbiorcy() {
        return nazwiskoOdbiorcy;
    }

    public void setNazwiskoOdbiorcy(String nazwiskoOdbiorcy) {
        this.nazwiskoOdbiorcy = nazwiskoOdbiorcy;
    }

    public Adres getAdresNadawcy() {
        return adresNadawcy;
    }

    public void setAdresNadawcy(Adres adresNadawcy) {
        this.adresNadawcy = adresNadawcy;
    }

    public Adres getAdresOdbiorcy() {
        return adresOdbiorcy;
    }

    public void setAdresOdbiorcy(Adres adresOdbiorcy) {
        this.adresOdbiorcy = adresOdbiorcy;
    }

    public boolean isWydana() {
        return wydana;
    }

    public void setWydana(boolean wydana) {
        this.wydana = wydana;
    }

    public Integer getNrUrzedu() {
        return nrUrzedu;
    }

    public void setNrUrzedu(Integer nrUrzedu) {
        this.nrUrzedu = nrUrzedu;
    }

    public boolean iswTransporcie() {
        return wTransporcie;
    }

    public void setwTransporcie(boolean wTransporcie) {
        this.wTransporcie = wTransporcie;
    }
}
