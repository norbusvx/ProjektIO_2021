package com.example.lab04;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Kasa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    private Integer doZaplaty;

    private Integer zaplacono;

    private Integer reszta;

    private String data;


    public Kasa() {
        this.reszta =0;

        this.data=dajDate();
    }

    public Kasa(Integer doZaplaty, Integer zaplacono) {
        this.doZaplaty = doZaplaty;
        this.zaplacono = zaplacono;
        this.reszta = zaplacono - doZaplaty;


    }

    public void obliczReszte(){
        this.reszta = this.zaplacono - this.doZaplaty;
    }

    public String dajDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return formatter.format(date);
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getDoZaplaty() {
        return doZaplaty;
    }

    public void setDoZaplaty(Integer doZaplaty) {
        this.doZaplaty = doZaplaty;
    }

    public Integer getZaplacono() {
        return zaplacono;
    }

    public void setZaplacono(Integer zaplacono) {
        this.zaplacono = zaplacono;
    }

    public Integer getReszta() {
        return reszta;
    }

    public void setReszta(Integer reszta) {
        this.reszta = reszta;
    }
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
