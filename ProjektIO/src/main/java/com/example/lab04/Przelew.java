package com.example.lab04;

import javax.persistence.*;

@Entity
public class Przelew {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String imieOdbiorcy;
    private String nazwiskoOdbiorcy;
    private String imieNadawcy;
    private String nazwiskoNadawcy;

    private String kodPocztowyNadawcy;

    private String miastoNadawcy;

    private String ulicaNadawcy;

    private String nrDomuNadawcy;

    private String nrMieszkaniaNadawcy;

    private String kodPocztowyOdbiorcy;

    private String miastoOdbiorcy;

    private String ulicaOdbiorcy;

    private String nrDomuOdbiorcy;

    private String nrMieszkaniaOdbiorcy;

    private Float kwota;

    public Przelew() {
    }

    public Przelew(String imieOdbiorcy, String nazwiskoOdbiorcy, String imieNadawcy, String nazwiskoNadawcy, String kodPocztowyNadawcy, String miastoNadawcy, String ulicaNadawcy, String nrDomuNadawcy, String nrMieszkaniaNadawcy, String kodPocztowyOdbiorcy, String miastoOdbiorcy, String ulicaOdbiorcy, String nrDomuOdbiorcy, String nrMieszkaniaOdbiorcy, Float kwota) {
        this.imieOdbiorcy = imieOdbiorcy;
        this.nazwiskoOdbiorcy = nazwiskoOdbiorcy;
        this.imieNadawcy = imieNadawcy;
        this.nazwiskoNadawcy = nazwiskoNadawcy;
        this.kodPocztowyNadawcy = kodPocztowyNadawcy;
        this.miastoNadawcy = miastoNadawcy;
        this.ulicaNadawcy = ulicaNadawcy;
        this.nrDomuNadawcy = nrDomuNadawcy;
        this.nrMieszkaniaNadawcy = nrMieszkaniaNadawcy;
        this.kodPocztowyOdbiorcy = kodPocztowyOdbiorcy;
        this.miastoOdbiorcy = miastoOdbiorcy;
        this.ulicaOdbiorcy = ulicaOdbiorcy;
        this.nrDomuOdbiorcy = nrDomuOdbiorcy;
        this.nrMieszkaniaOdbiorcy = nrMieszkaniaOdbiorcy;
        this.kwota = kwota;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getKodPocztowyNadawcy() {
        return kodPocztowyNadawcy;
    }

    public void setKodPocztowyNadawcy(String kodPocztowyNadawcy) {
        this.kodPocztowyNadawcy = kodPocztowyNadawcy;
    }

    public String getMiastoNadawcy() {
        return miastoNadawcy;
    }

    public void setMiastoNadawcy(String miastoNadawcy) {
        this.miastoNadawcy = miastoNadawcy;
    }

    public String getUlicaNadawcy() {
        return ulicaNadawcy;
    }

    public void setUlicaNadawcy(String ulicaNadawcy) {
        this.ulicaNadawcy = ulicaNadawcy;
    }

    public String getNrDomuNadawcy() {
        return nrDomuNadawcy;
    }

    public void setNrDomuNadawcy(String nrDomuNadawcy) {
        this.nrDomuNadawcy = nrDomuNadawcy;
    }

    public String getNrMieszkaniaNadawcy() {
        return nrMieszkaniaNadawcy;
    }

    public void setNrMieszkaniaNadawcy(String nrMieszkaniaNadawcy) {
        this.nrMieszkaniaNadawcy = nrMieszkaniaNadawcy;
    }

    public String getKodPocztowyOdbiorcy() {
        return kodPocztowyOdbiorcy;
    }

    public void setKodPocztowyOdbiorcy(String kodPocztowyOdbiorcy) {
        this.kodPocztowyOdbiorcy = kodPocztowyOdbiorcy;
    }

    public String getMiastoOdbiorcy() {
        return miastoOdbiorcy;
    }

    public void setMiastoOdbiorcy(String miastoOdbiorcy) {
        this.miastoOdbiorcy = miastoOdbiorcy;
    }

    public String getUlicaOdbiorcy() {
        return ulicaOdbiorcy;
    }

    public void setUlicaOdbiorcy(String ulicaOdbiorcy) {
        this.ulicaOdbiorcy = ulicaOdbiorcy;
    }

    public String getNrDomuOdbiorcy() {
        return nrDomuOdbiorcy;
    }

    public void setNrDomuOdbiorcy(String nrDomuOdbiorcy) {
        this.nrDomuOdbiorcy = nrDomuOdbiorcy;
    }

    public String getNrMieszkaniaOdbiorcy() {
        return nrMieszkaniaOdbiorcy;
    }

    public void setNrMieszkaniaOdbiorcy(String nrMieszkaniaOdbiorcy) {
        this.nrMieszkaniaOdbiorcy = nrMieszkaniaOdbiorcy;
    }

    public Float getKwota() {
        return kwota;
    }

    public void setKwota(Float kwota) {
        this.kwota = kwota;
    }
}
