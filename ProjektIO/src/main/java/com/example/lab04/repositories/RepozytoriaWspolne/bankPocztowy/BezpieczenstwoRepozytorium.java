package com.example.lab04.repositories.RepozytoriaWspolne.bankPocztowy;

import com.example.lab04.models.Natalia.Bezpieczenstwo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BezpieczenstwoRepozytorium extends JpaRepository<Bezpieczenstwo, Integer> {
    Bezpieczenstwo findByNrKlientaOrPIN(Integer nrKlienta, Integer PIN);
    Bezpieczenstwo findByNrKlienta(Integer nrKlienta);
}
