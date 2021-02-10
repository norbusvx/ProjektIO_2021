package com.example.lab04.repositories.RepozytoriaWspolne.repozytoriaOkienko;

import com.example.lab04.OpakowanieZbiorcze;
import com.example.lab04.Przesylka;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpakowanieRepozytorium extends JpaRepository<OpakowanieZbiorcze, Integer> {

   OpakowanieZbiorcze findObrazByOpakowanie(Przesylka Opakowania);

}