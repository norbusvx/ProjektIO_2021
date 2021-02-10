package com.example.lab04;

import javax.persistence.*;

@Entity
public class Swiadczenie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String imieOdbiorcy;
    private String nazwiskoOdbiorcy;

    @ManyToOne
    private Adres adresOdbiorcy;

    private boolean status;

    private Integer kwota;

    public Swiadczenie() {
    }

    public Swiadczenie(String imieOdbiorcy, String nazwiskoOdbiorcy, Adres adresOdbiorcy, boolean status, Integer kwota) {
        this.imieOdbiorcy = imieOdbiorcy;
        this.nazwiskoOdbiorcy = nazwiskoOdbiorcy;
        this.adresOdbiorcy = adresOdbiorcy;
        this.status = status;
        this.kwota = kwota;
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

    public Adres getAdresOdbiorcy() {
        return adresOdbiorcy;
    }

    public void setAdresOdbiorcy(Adres adresOdbiorcy) {
        this.adresOdbiorcy = adresOdbiorcy;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Integer getKwota() {
        return kwota;
    }

    public void setKwota(Integer kwota) {
        this.kwota = kwota;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
