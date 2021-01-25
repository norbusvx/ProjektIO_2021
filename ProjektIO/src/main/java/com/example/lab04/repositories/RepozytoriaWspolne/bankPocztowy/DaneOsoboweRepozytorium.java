package com.example.lab04.repositories.RepozytoriaWspolne.bankPocztowy;

import com.example.lab04.models.Natalia.Bezpieczenstwo;
import com.example.lab04.models.Natalia.DaneOsobowe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DaneOsoboweRepozytorium extends JpaRepository<DaneOsobowe, Integer> {
    DaneOsobowe findByBezpieczenstwo(Bezpieczenstwo bezpieczenstwo);
}
