package com.example.lab04;

import javax.persistence.*;

@Entity
public class Przesylka {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Adres adresNadawcy;

    @ManyToOne
    private Adres adresOdbiorcy;

    private boolean wydana;

    private boolean wTransporcie;

    private Integer nrUrzedu;


    public Przesylka(Adres adresNadawcy, Adres adresOdbiorcy, Integer nrUrzedu) {

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
        return wTransporcie;
    }

    public void setwTransporcie(boolean wTransporcie) {
        this.wTransporcie = wTransporcie;
    }

    public Integer getNrUrzedu() {
        return nrUrzedu;
    }

    public void setNrUrzedu(Integer nrUrzedu) {
        this.nrUrzedu = nrUrzedu;
    }
}
