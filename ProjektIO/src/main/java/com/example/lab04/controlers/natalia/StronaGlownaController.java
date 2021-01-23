package com.example.lab04.controlers.natalia;

import com.example.lab04.models.Natalia.Bezpieczenstwo;
import com.example.lab04.models.Natalia.DaneOsobowe;
import com.example.lab04.models.Natalia.Zalogowany;
import com.example.lab04.repositories.RepozytoriaWspolne.bankPocztowy.BezpieczenstwoRepozytorium;
import com.example.lab04.repositories.RepozytoriaWspolne.bankPocztowy.DaneOsoboweRepozytorium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/Natalia/Glowna")
public class StronaGlownaController {

    @Autowired
    DaneOsoboweRepozytorium daneOsoboweRepozytorium;
    @Autowired
    BezpieczenstwoRepozytorium bezpieczenstwoRepozytorium;
    Zalogowany zalogowany = new Zalogowany();

    @GetMapping("/bankPocztowy")
    public String bankPocztowy() {
        //przekierowanie na strone glowna banku
        return "Natalia/stronaGlownaBanku";
    }

    @PostMapping("/zaloguj")
    public String zaloguj(@ModelAttribute("form") @Valid FormularzDTO form, Errors result) {
        if(result.hasErrors()) {
            return "Natalia/stronaGlownaBanku";
        }
        Bezpieczenstwo znalezionyKlient = bezpieczenstwoRepozytorium.findByNrKlienta(form.getNrKlienta());
        zalogowany.setIdZalogowanego(znalezionyKlient.getId());
        zalogowany.setNrZalogowanegoKlienta(znalezionyKlient.getNrKlienta());
        zalogowany.setPINzalogowanego(znalezionyKlient.getPIN());
        return "/Natalia/funkcjeKonta/mojeKonto";
    }

}
