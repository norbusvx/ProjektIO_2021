package com.example.lab04.repositories.RepozytoriaWspolne;

import com.example.lab04.Przesylka;
import com.example.lab04.Uzytkownik;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrzesylkaRepozytorium extends JpaRepository<Przesylka, Integer> {
    Page<Przesylka> findObrazByWydanaAndNrUrzeduAndCzyWZbiorczym(Boolean wydana, Integer nrUrzedu,Boolean czyWZbiorczym,  Pageable pageable);
    Page<Przesylka> findObrazByWydanaAndTransportowanaAndNrUrzeduNotLikeAndCzyWZbiorczym(Boolean wydana, Boolean wTransporcie, Integer nrUrzedu,Boolean czyWZbiorczym, Pageable pageable);
    Page<Przesylka> findObrazByWydanaAndTransportowanaNotLikeAndNrUrzeduAndCzyWZbiorczym(Boolean wydana, Boolean wTransporcie, Integer nrUrzedu,Boolean czyWZbiorczym, Pageable pageable);
    Page<Przesylka> findObrazByWydanaAndTransportowanaNotLikeAndNrUrzeduAndOpakowanieZbiorcze(Boolean wydana, Boolean wTransporcie, Integer nrUrzedu,Boolean opakowanieZbiorcze, Pageable pageable);
    Page<Przesylka> findObrazByWydanaAndTransportowanaNotLikeAndNrUrzeduAndCzyWZbiorczymAndIdNotLike(Boolean wydana, Boolean wTransporcie, Integer nrUrzedu,Boolean czyWZbiorczym, Integer id, Pageable pageable);
}
