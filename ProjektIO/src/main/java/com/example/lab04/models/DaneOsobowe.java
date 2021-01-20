package com.example.lab04.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class DaneOsobowe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String imie;
    private String nazwisko;
    private Integer nrPESEL;
    private Integer nrKlienta;
    private String seriaINumerDokumentuTozsamosci;
    private String adresZamieszkania;
    private Integer nrTelefonu;
    private String adresEmail;
    private String adresDoKorespondencji;

    public DaneOsobowe(String imie, String nazwisko, Integer nrPESEL, Integer nrKlienta,
                       String seriaINumerDokumentuTozsamosci, String adresZamieszkania, Integer nrTelefonu,
                       String adresEmail, String adresDoKorespondencji) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nrPESEL = nrPESEL;
        this.nrKlienta = nrKlienta;
        this.seriaINumerDokumentuTozsamosci = seriaINumerDokumentuTozsamosci;
        this.adresZamieszkania = adresZamieszkania;
        this.nrTelefonu = nrTelefonu;
        this.adresEmail = adresEmail;
        this.adresDoKorespondencji = adresDoKorespondencji;
    }

    public DaneOsobowe() {

    }
}
