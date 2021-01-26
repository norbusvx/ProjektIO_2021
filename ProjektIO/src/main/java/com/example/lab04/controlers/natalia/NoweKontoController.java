package com.example.lab04.controlers.natalia;

import com.example.lab04.models.Natalia.*;
import com.example.lab04.repositories.RepozytoriaWspolne.bankPocztowy.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;

@Controller
@RequestMapping("/Natalia/Konto")
public class NoweKontoController {
    @Autowired
    DaneOsoboweRepozytorium daneOsoboweRepozytorium;
    @Autowired
    LimityRepozytorium limityRepozytorium;
    @Autowired
    BezpieczenstwoRepozytorium bezpieczenstwoRepozytorium;
    @Autowired
    RachunekRepozytorium rachunekRepozytorium;
    @Autowired
    HistoriaRepozytorium historiaRepozytorium;

    DaneOsobowe daneOsobowe;

    @GetMapping("/dodaj")
    public String dodaj(Model model) {
        model.addAttribute("daneOsobowe", new DaneOsobowe());
        return"Natalia/noweKonto/daneOsobowe";
    }

    @GetMapping("/noweKonto")
    public String noweKonto(Model model) {
        DaneOsobowe daneOsobowe = new DaneOsobowe();
        model.addAttribute("daneOsobowe", daneOsobowe);
        //przekierowanie na strone glowna banku
        return "Natalia/noweKonto/daneOsobowe";
    }

    @PostMapping("/zapiszDaneOsobowe")
    public String zapisz(@ModelAttribute("daneOsobowe") @Valid DaneOsobowe daneDoZapisu, Errors result, Model model) {
        if(result.hasErrors()) {
            return "Natalia/noweKonto/daneOsobowe";
        }
        daneOsobowe = daneDoZapisu;
        model.addAttribute("limity", new Limity());
        return "Natalia/noweKonto/limity";
    }

    @PostMapping("/zapiszLimity")
    public String zapiszLimity(@ModelAttribute("limity") @Valid Limity limity, Errors result, Model model) {
        if(result.hasErrors()) {
            return "Natalia/noweKonto/limity";
        }
        limityRepozytorium.save(limity);
        daneOsobowe.setLimity(limity);
        Bezpieczenstwo bezpieczenstwo = new Bezpieczenstwo();
        bezpieczenstwo.setNrKlienta(2548615);
        model.addAttribute("bezpieczenstwo", bezpieczenstwo);
        return "Natalia/noweKonto/bezpieczenstwo";
    }

    @PostMapping("/zapiszBezpieczenstwo")
    public String zapiszBezpieczenstwo(@ModelAttribute("bezpieczenstwo") @Valid Bezpieczenstwo bezpieczenstwo, Errors result) {
        if(result.hasErrors()) {
            return "Natalia/noweKonto/bezpieczenstwo";
        }
        bezpieczenstwo.setNrKlienta(2548615);
        bezpieczenstwoRepozytorium.save(bezpieczenstwo);
        daneOsobowe.setBezpieczenstwo(bezpieczenstwo);
        Rachunek rachunek = new Rachunek(0.0f, "PLN", daneOsobowe);
        daneOsoboweRepozytorium.save(daneOsobowe);
        rachunekRepozytorium.save(rachunek);
        return "Natalia/stronaGlownaBanku";
    }
}
