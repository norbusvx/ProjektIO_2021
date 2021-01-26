package com.example.lab04.models.Natalia;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Setter
@Getter
public class Historia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NumberFormat(pattern = "#.00")
    private Float kwota;
    @NotNull
    private LocalDate dataOperacji;
    @NotNull
    private String typTransakcji;
    @NotNull
    private String opis;
    @NotNull
    @NumberFormat(pattern = "#.00")
    private Float saldoPoOperacji;
    @ManyToOne
    public DaneOsobowe daneOsobowe;

    public Historia(Float kwota, LocalDate dataOperacji, String typTransakcji, String opis, Float saldoPoOperacji, DaneOsobowe daneOsobowe) {
        this.kwota = kwota;
        this.dataOperacji = dataOperacji;
        this.typTransakcji = typTransakcji;
        this.opis = opis;
        this.saldoPoOperacji = saldoPoOperacji;
        this.daneOsobowe = daneOsobowe;
    }
    public Historia(){}
}
