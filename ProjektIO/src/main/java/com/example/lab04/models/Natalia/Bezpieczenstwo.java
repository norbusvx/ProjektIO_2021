package com.example.lab04.models.Natalia;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Setter @Getter
public class Bezpieczenstwo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private Integer nrKlienta;
    @NotNull
    private String haslo;
    @NotNull
    private Integer PIN;

    public Bezpieczenstwo(Integer id, Integer nrKlienta, String haslo, Integer PIN) {
        this.id = id;
        this.nrKlienta = nrKlienta;
        this.haslo = haslo;
        this.PIN = PIN;
    }

    public Bezpieczenstwo() {}
}
