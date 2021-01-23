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
            if (bezpieczenstwoRepozytorium.findAll().isEmpty()) {
                Bezpieczenstwo bezpieczenstwo = new Bezpieczenstwo(1, 1234567, "haslo", 1234);
                DaneOsobowe daneOsobowe = new DaneOsobowe(1, "Natalia", "Koc",
                        1045678912,
                        "CAS123", "ul. Brzeska 123/45, 08-110 Siedlce",
                        123456789, "adres-email@email.com",
                        "ul. Brzeska 123/45, 08-110 Siedlce", "telefonicznie",
                        bezpieczenstwo);
                Historia historia = new Historia(1, 100.00f, LocalDate.now(), "wypłata",
                        "wypłata gotówki", 900.00f, daneOsobowe);
                Limity limity = new Limity(1, 500.00f, 500.00f, 500.00f);
                Rachunek rachunek = new Rachunek(1, 900.00f, "PLN", daneOsobowe, limity);

                bezpieczenstwoRepozytorium.save(bezpieczenstwo);
                daneOsoboweRepozytorium.save(daneOsobowe);
                historiaRepozytorium.save(historia);
                limityRepozytorium.save(limity);
                rachunekRepozytorium.save(rachunek);
            }
        };
    }
}
