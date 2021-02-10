package com.example.lab04.repositories.RepozytoriaWspolne;

import com.example.lab04.Przesylka;
import com.example.lab04.Uzytkownik;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrzesylkaRepozytorium extends JpaRepository<Przesylka, Integer> {
    Page<Przesylka> findObrazByWydanaAndNrUrzedu(Boolean wydana, Integer nrUrzedu,  Pageable pageable);
    Page<Przesylka> findObrazByWydanaAndTransportowanaAndNrUrzeduNotLike(Boolean wydana, Boolean wTransporcie, Integer nrUrzedu, Pageable pageable);
}
