package com.example.lab04.controlers.natalia;

import com.example.lab04.models.Natalia.Bezpieczenstwo;
import com.example.lab04.models.Natalia.DaneOsobowe;
import com.example.lab04.models.Natalia.Zalogowany;
import com.example.lab04.repositories.RepozytoriaWspolne.bankPocztowy.BezpieczenstwoRepozytorium;
import com.example.lab04.repositories.RepozytoriaWspolne.bankPocztowy.DaneOsoboweRepozytorium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/Natalia/Glowna")
public class StronaGlownaController {

    @Autowired
    DaneOsoboweRepozytorium daneOsoboweRepozytorium;
    @Autowired
    BezpieczenstwoRepozytorium bezpieczenstwoRepozytorium;

    @GetMapping("/bankPocztowy")
    public String bankPocztowy() {
        //przekierowanie na strone glowna banku
        return "Natalia/stronaGlownaBanku";
    }

    @PostMapping("/zaloguj")
    public String zaloguj(@ModelAttribute("zaloguj") @Valid Bezpieczenstwo bezpieczenstwo, Errors result) {
        if(result.hasErrors()) {
            return "Natalia/stronaGlownaBanku";
        }
        Bezpieczenstwo znalezionyKlient = bezpieczenstwoRepozytorium.findByNrKlientaAndHaslo
                (bezpieczenstwo.getNrKlienta(), bezpieczenstwo.getHaslo());
        Zalogowany zalogowany = new Zalogowany(znalezionyKlient.getId(), znalezionyKlient.getNrKlienta(),
                znalezionyKlient.getHaslo(), znalezionyKlient.getPIN());
        return "Natalia/konto/mojeKonto";
    }

}
