package com.example.lab04.repositories.RepozytoriaWspolne;

import com.example.lab04.Przesylka;
import com.example.lab04.Uzytkownik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrzesylkaRepozytorium extends JpaRepository<Przesylka, Integer> {
}
