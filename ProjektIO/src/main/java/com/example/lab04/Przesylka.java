package com.example.lab04;

import javax.persistence.*;

@Entity
public class Przesylka {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String imieOdbiorcy;
    private String nazwiskoOdbiorcy;
    private String imieNadawcy;
    private String nazwiskoNadawcy;
    @ManyToOne
    private Adres adresNadawcy;

    @ManyToOne
    private Adres adresOdbiorcy;

    private boolean wydana;

    private boolean transportowana;

    private boolean opakowanieZbiorcze;

    private boolean czyWZbiorczym;

    private Integer nrUrzedu;

    public Przesylka() {
    }


    public Przesylka(String imieOdbiorcy, String nazwiskoOdbiorcy, String imieNadawcy, String nazwiskoNadawcy, Adres adresNadawcy, Adres adresOdbiorcy, Integer nrUrzedu) {

        this.imieOdbiorcy = imieOdbiorcy;
        this.nazwiskoOdbiorcy = nazwiskoOdbiorcy;
        this.imieNadawcy = imieNadawcy;
        this.nazwiskoNadawcy = nazwiskoNadawcy;

        this.adresNadawcy = adresNadawcy;
        this.adresOdbiorcy = adresOdbiorcy;
        this.nrUrzedu = nrUrzedu;
        this.transportowana = false;
        this.wydana = false;
        this.opakowanieZbiorcze = false;
        this.czyWZbiorczym=false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public boolean iswTransporcie() {
        return transportowana;
    }

    public void setwTransporcie(boolean wTransporcie) {
        this.transportowana = wTransporcie;
    }

    public Integer getNrUrzedu() {
        return nrUrzedu;
    }

    public void setNrUrzedu(Integer nrUrzedu) {
        this.nrUrzedu = nrUrzedu;
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

    public boolean isTransportowana() {
        return transportowana;
    }

    public void setTransportowana(boolean transportowana) {
        this.transportowana = transportowana;
    }

    public boolean isOpakowanieZbiorcze() {
        return opakowanieZbiorcze;
    }

    public void setOpakowanieZbiorcze(boolean opakowanieZbiorcze) {
        this.opakowanieZbiorcze = opakowanieZbiorcze;
    }

    public boolean isCzyWZbiorczym() {
        return czyWZbiorczym;
    }

    public void setCzyWZbiorczym(boolean czyWZbiorczym) {
        this.czyWZbiorczym = czyWZbiorczym;
    }
}
