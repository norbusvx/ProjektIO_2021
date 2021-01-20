package com.example.lab04.config;


import com.example.lab04.Uzytkownik;

import com.example.lab04.repositories.RepozytoriaWspolne.UzytkownikRepozytorium;
import com.example.lab04.repositories.RepozytoriaWspolne.bankPocztowy.DaneOsoboweRepozytorium;
import com.example.lab04.services.UserDetailServiceImplementation;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Initializer {

    //ignorować jak podkreśla repozytorium i UserDetailServiceImplementation, nic nie robi, jakieś tam problemy inteliJ, że nie wie jak to będzie działać
    @Autowired
    UzytkownikRepozytorium uzytkownikRepozytorium;

    @Autowired
    UserDetailServiceImplementation userDetailServiceImplementation;
    @Autowired
    DaneOsoboweRepozytorium daneOsoboweRepozytorium;

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
            /*if (daneOsoboweRepozytorium.findAll().isEmpty()) {
                daneOsobowe daneOsobowe = new daneOsobowe("Natalia", "Koc",
                        1045678912, 1234567,
                        "CAS123", "ul. Brzeska 123/45, 08-110 Siedlce",
                        123456789, "adres-email@email.com",
                        "ul. Brzeska 123/45, 08-110 Siedlce");
            }*/
        };
    }
}
