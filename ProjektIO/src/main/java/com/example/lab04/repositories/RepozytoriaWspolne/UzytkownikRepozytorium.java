package com.example.lab04.repositories.RepozytoriaWspolne;

import com.example.lab04.Uzytkownik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UzytkownikRepozytorium extends JpaRepository<Uzytkownik, Integer> {
    Uzytkownik findUzytkownikByLogin(String login);
}
