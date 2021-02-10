package com.example.lab04;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Adres {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    private String kodPocztowy;

    private String miasto;

    private String ulica;

    private String nrDomu;

    private String nrMieszkania;


    public Adres(){

    }

    public Adres( String kodPocztowy, String miasto, String ulica, String nrDomu, String nrMieszkania) {
        this.kodPocztowy = kodPocztowy;
        this.miasto = miasto;
        this.ulica = ulica;
        this.nrDomu = nrDomu;
        this.nrMieszkania = nrMieszkania;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNrDomu() {
        return nrDomu;
    }

    public void setNrDomu(String nrDomu) {
        this.nrDomu = nrDomu;
    }

    public String getNrMieszkania() {
        return nrMieszkania;
    }

    public void setNrMieszkania(String nrMieszkania) {
        this.nrMieszkania = nrMieszkania;
    }
}
