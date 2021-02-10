package com.example.lab04.config;


import com.example.lab04.Adres;
import com.example.lab04.Przesylka;
import com.example.lab04.Swiadczenie;
import com.example.lab04.Uzytkownik;

import com.example.lab04.models.Natalia.*;
import com.example.lab04.repositories.RepozytoriaWspolne.AdresRepozytorium;
import com.example.lab04.repositories.RepozytoriaWspolne.PrzesylkaRepozytorium;
import com.example.lab04.repositories.RepozytoriaWspolne.UzytkownikRepozytorium;
import com.example.lab04.repositories.RepozytoriaWspolne.bankPocztowy.*;
import com.example.lab04.repositories.RepozytoriaWspolne.repozytoriaOkienko.KasaRepozytorium;
import com.example.lab04.repositories.RepozytoriaWspolne.repozytoriaOkienko.SwiadczeniaRepozytorium;
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
    //Norbert
    @Autowired
    KasaRepozytorium kasaRepozytorium;
    @Autowired
    PrzesylkaRepozytorium przesylkaRepozytorium;
    @Autowired
    AdresRepozytorium adresRepozytorium;
    @Autowired
    SwiadczeniaRepozytorium swiadczeniaRepozytorium;




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



            if (przesylkaRepozytorium.findAll().isEmpty()){
                Adres adresOdbiorcy = new Adres("05-300", "Mińsk Mazowiecki", "Dębowa", "55c", "");
                adresRepozytorium.save(adresOdbiorcy);
                Adres adresNadawcy = new Adres("05-300", "Targówka", "Okoniowa", "55c", "12");
                adresRepozytorium.save(adresNadawcy);
                Przesylka przesylka=new Przesylka("Jan","Kowalski", "Antonio", "Banderaz",adresNadawcy, adresOdbiorcy, 1);
                przesylkaRepozytorium.save(przesylka);

                adresOdbiorcy = new Adres("05-306", "Anielik", "Dębowata", "5c", "333");
                adresRepozytorium.save(adresOdbiorcy);
                adresNadawcy = new Adres("05-444", "Targ Starz", "Ulicynowa", "60", "");
                adresRepozytorium.save(adresNadawcy);
                przesylka=new Przesylka("Aleks", "Bonapartek","Kmić", "Jarema",adresNadawcy, adresOdbiorcy, 4);
                przesylkaRepozytorium.save(przesylka);

                adresOdbiorcy = new Adres("05-302", "Topolek", "Dębowata", "52c", "32");
                adresRepozytorium.save(adresOdbiorcy);
                adresNadawcy = new Adres("05-480", "Tartarz", "Ulicka", "63", "12");
                adresRepozytorium.save(adresNadawcy);
                przesylka=new Przesylka("Róża", "Biała", "Oleks", "Tak",adresNadawcy, adresOdbiorcy, 4);
                przesylkaRepozytorium.save(przesylka);

                adresOdbiorcy = new Adres("05-444", "Targ Starz", "Ulicynowa", "60", "");
                adresRepozytorium.save(adresOdbiorcy);
                adresNadawcy = new Adres("05-300", "Mińsk Mazowiecki", "Dębowa", "55c", "5");
                adresRepozytorium.save(adresNadawcy);
                przesylka=new Przesylka("Norbert", "Koko","On", "Ten",adresNadawcy, adresOdbiorcy, 4);
                przesylka.setwTransporcie(true);
                przesylkaRepozytorium.save(przesylka);

                adresOdbiorcy = new Adres("00-000", "Urząd nr 1", "", "", "");
                adresRepozytorium.save(adresOdbiorcy);
                adresNadawcy = new Adres("00-000", "Urząd nr 2", "", "", "");
                adresRepozytorium.save(adresNadawcy);
                przesylka=new Przesylka("Urząd 1", "","Urząd 2", "",adresNadawcy, adresOdbiorcy, 1);
                przesylka.setwTransporcie(false);
                przesylkaRepozytorium.save(przesylka);
            }

            if (swiadczeniaRepozytorium.findAll().isEmpty()){
                Adres adresOdbiorcy = new Adres("05-300", "Mińsk Mazowiecki", "Dębowa", "55c", "");
                adresRepozytorium.save(adresOdbiorcy);
                Swiadczenie swiadczenie = new Swiadczenie("Janko","Konca",adresOdbiorcy, false, 5000);
                swiadczeniaRepozytorium.save(swiadczenie);
                swiadczenie = new Swiadczenie("Janka","Kotwica",adresOdbiorcy, false, 3000);
                swiadczeniaRepozytorium.save(swiadczenie);
            }
        };
    }
}
