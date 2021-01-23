package com.example.lab04.models.Natalia;

public class Zalogowany {
    private Integer idZalogowanego;
    private Integer nrZalogowanegoKlienta;
    private String HasloZalogowanego;
    private Integer PINzalogowanego;

    public Integer getIdZalogowanego() {
        return idZalogowanego;
    }

    public void setIdZalogowanego(Integer idZalogowanego) {
        this.idZalogowanego = idZalogowanego;
    }

    public Integer getNrZalogowanegoKlienta() {
        return nrZalogowanegoKlienta;
    }

    public void setNrZalogowanegoKlienta(Integer nrZalogowanegoKlienta) {
        this.nrZalogowanegoKlienta = nrZalogowanegoKlienta;
    }

    public String getHasloZalogowanego() {
        return HasloZalogowanego;
    }

    public void setHasloZalogowanego(String hasloZalogowanego) {
        HasloZalogowanego = hasloZalogowanego;
    }

    public Integer getPINzalogowanego() {
        return PINzalogowanego;
    }

    public void setPINzalogowanego(Integer PINzalogowanego) {
        this.PINzalogowanego = PINzalogowanego;
    }

    public Zalogowany(Integer idZalogowanego, Integer nrZalogowanegoKlienta, String hasloZalogowanego, Integer PINzalogowanego) {
        this.idZalogowanego = idZalogowanego;
        this.nrZalogowanegoKlienta = nrZalogowanegoKlienta;
        HasloZalogowanego = hasloZalogowanego;
        this.PINzalogowanego = PINzalogowanego;
    }
}
