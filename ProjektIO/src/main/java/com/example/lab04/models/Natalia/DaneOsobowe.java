package com.example.lab04.models.Natalia;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Getter @Setter
public class DaneOsobowe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String imie;
    @NotNull
    private String nazwisko;
    @NotNull
    private Integer nrPESEL;
    @NotNull
    private String seriaINumerDokumentuTozsamosci;
    @NotNull
    private String adresZamieszkania;
    @NotNull
    private Integer nrTelefonu;
    @NotNull
    private String adresEmail;
    @NotNull
    private String adresDoKorespondencji;
    @NotNull
    private String wybranySposobKontaktowania;
    @OneToOne
    private Bezpieczenstwo bezpieczenstwo = null;
    @OneToOne
    private Limity limity = null;

    public DaneOsobowe(Integer id, String imie, String nazwisko, Integer nrPESEL, String seriaINumerDokumentuTozsamosci,
                       String adresZamieszkania, Integer nrTelefonu, String adresEmail, String adresDoKorespondencji, String wybranySposobKontaktowania, Bezpieczenstwo bezpieczenstwo) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nrPESEL = nrPESEL;
        this.seriaINumerDokumentuTozsamosci = seriaINumerDokumentuTozsamosci;
        this.adresZamieszkania = adresZamieszkania;
        this.nrTelefonu = nrTelefonu;
        this.adresEmail = adresEmail;
        this.adresDoKorespondencji = adresDoKorespondencji;
        this.wybranySposobKontaktowania = wybranySposobKontaktowania;
        this.bezpieczenstwo = bezpieczenstwo;
    }

    public DaneOsobowe() {}
}
