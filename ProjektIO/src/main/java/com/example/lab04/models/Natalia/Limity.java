package com.example.lab04.models.Natalia;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Setter @Getter
public class Limity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @NumberFormat(pattern = "#.00")
    private Float bankomat;
    @NotNull
    @NumberFormat(pattern = "#.00")
    private Float sklep;
    @NotNull
    @NumberFormat(pattern = "#.00")
    private Float internet;

    public Limity(Integer id, Float bankomat, Float sklep, Float internet) {
        this.id = id;
        this.bankomat = bankomat;
        this.sklep = sklep;
        this.internet = internet;
    }
    public Limity(){}
}
