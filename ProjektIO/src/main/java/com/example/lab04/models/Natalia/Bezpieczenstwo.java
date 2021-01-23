package com.example.lab04.models.Natalia;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Setter @Getter
public class Bezpieczenstwo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Size(min = 1000000, max = 9999999)
    private Integer nrKlienta;
    @NotNull
    private String Haslo;
    @NotNull
    private Integer PIN;

    public Bezpieczenstwo(Integer id, Integer nrKlienta, String haslo, Integer PIN) {
        this.id = id;
        this.nrKlienta = nrKlienta;
        Haslo = haslo;
        this.PIN = PIN;
    }

    public Bezpieczenstwo() {}
}
