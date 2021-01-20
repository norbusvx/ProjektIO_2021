package com.example.lab04.repositories.RepozytoriaWspolne.bankPocztowy;

import com.example.lab04.Uzytkownik;
import com.example.lab04.models.DaneOsobowe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DaneOsoboweRepozytorium extends JpaRepository<DaneOsobowe, Integer> {
    DaneOsobowe findByNrKlienta(Integer nrKlienta);
}
