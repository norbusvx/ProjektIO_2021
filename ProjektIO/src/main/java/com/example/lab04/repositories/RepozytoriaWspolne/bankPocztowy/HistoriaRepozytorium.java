package com.example.lab04.repositories.RepozytoriaWspolne.bankPocztowy;

import com.example.lab04.models.Natalia.DaneOsobowe;
import com.example.lab04.models.Natalia.Historia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoriaRepozytorium extends JpaRepository<Historia, Integer> {
    List<Historia> findAllByDaneOsobowe(DaneOsobowe daneOsobowe);
}
