package com.example.lab04.models.Natalia;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Setter
@Getter
public class Rachunek {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @NumberFormat(pattern = "#.00")
    private Float saldoKonta;
    @NotNull
    private String waluta;
    @OneToOne
    private DaneOsobowe daneOsobowe;

    public Rachunek(Integer id, Float saldoKonta, String waluta, DaneOsobowe daneOsobowe) {
        this.id = id;
        this.saldoKonta = saldoKonta;
        this.waluta = waluta;
        this.daneOsobowe = daneOsobowe;
    }
    public Rachunek(){}
}
