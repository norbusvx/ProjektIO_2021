package com.example.lab04.repositories.RepozytoriaWspolne.bankPocztowy;

import com.example.lab04.models.Natalia.DaneOsobowe;
import com.example.lab04.models.Natalia.Rachunek;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RachunekRepozytorium extends JpaRepository<Rachunek, Integer> {
    Rachunek findByDaneOsobowe(DaneOsobowe daneOsobowe);
}
