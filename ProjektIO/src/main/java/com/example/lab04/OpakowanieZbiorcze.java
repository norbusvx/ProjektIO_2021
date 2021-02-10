package com.example.lab04;

import javax.persistence.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class OpakowanieZbiorcze {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private Przesylka opakowanie;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Przesylka> przesylki;

//    public OpakowanieZbiorcze(String imieOdbiorcy, String nazwiskoOdbiorcy, String imieNadawcy, String nazwiskoNadawcy, Adres adresOdbiorcy, Adres adresNadawcy, Integer nrUrzedu) {
//
//        this.opakowanie.setImieOdbiorcy(imieOdbiorcy);
//        this.opakowanie.setNazwiskoOdbiorcy(nazwiskoOdbiorcy);
//        this.opakowanie.setImieNadawcy(imieNadawcy);
//        this.opakowanie.setNazwiskoNadawcy(nazwiskoNadawcy);
//
//        this.opakowanie.setAdresOdbiorcy(adresOdbiorcy);
//        this.opakowanie.setAdresNadawcy(adresNadawcy);
//        this.opakowanie.setNrUrzedu(nrUrzedu);
//        this.opakowanie.setTransportowana(false);
//        this.opakowanie.setWydana(false);
//        this.opakowanie.setOpakowanieZbiorcze(false);
//    }

    public OpakowanieZbiorcze() {
        this.przesylki=new HashSet<>();
    }

    public OpakowanieZbiorcze(Przesylka p) {
        this.opakowanie=p;
        this.przesylki=new HashSet<>();
    }

    public OpakowanieZbiorcze(Set<Przesylka> przesylki) {
        this.przesylki = przesylki;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Przesylka> getPrzesylki() {
        return przesylki;
    }

    public void setPrzesylki(Set<Przesylka> przesylki) {
        this.przesylki = przesylki;
    }

    public void dodajPrzesylke(Przesylka p){
        this.przesylki.add(p);
    }

    public Przesylka getOpakowanie() {
        return opakowanie;
    }

    public void setOpakowanie(Przesylka opakowanie) {
        this.opakowanie = opakowanie;
    }

}
