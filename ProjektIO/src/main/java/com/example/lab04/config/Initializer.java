package com.example.lab04.config;


import com.example.lab04.Uzytkownik;

import com.example.lab04.models.Natalia.*;
import com.example.lab04.repositories.RepozytoriaWspolne.UzytkownikRepozytorium;
import com.example.lab04.repositories.RepozytoriaWspolne.bankPocztowy.*;
import com.example.lab04.services.UserDetailServiceImplementation;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class Initializer {

    //ignorować jak podkreśla repozytorium i UserDetailServiceImplementation, nic nie robi, jakieś tam problemy inteliJ, że nie wie jak to będzie działać
    @Autowired
    UzytkownikRepozytorium uzytkownikRepozytorium;

    @Autowired
    UserDetailServiceImplementation userDetailServiceImplementation;

    @Autowired
    DaneOsoboweRepozytorium daneOsoboweRepozytorium;
    @Autowired
    BezpieczenstwoRepozytorium bezpieczenstwoRepozytorium;
    @Autowired
    HistoriaRepozytorium historiaRepozytorium;
    @Autowired
    LimityRepozytorium limityRepozytorium;
    @Autowired
    RachunekRepozytorium rachunekRepozytorium;


    @Bean
    InitializingBean init() {
        return () -> {
            //uzytkownikRepozytorium.deleteAll();
            if (uzytkownikRepozytorium.findAll().isEmpty()) {
                Uzytkownik uzytkownik = new Uzytkownik("user1", "user1", 1);
                userDetailServiceImplementation.dodajUzytkownika(uzytkownik);
                uzytkownik = new Uzytkownik("user2", "user1", 1);
                userDetailServiceImplementation.dodajUzytkownika(uzytkownik);
                uzytkownik = new Uzytkownik("user3", "user1", 1);
                userDetailServiceImplementation.dodajUzytkownika(uzytkownik);
            }
        };
    }
}
