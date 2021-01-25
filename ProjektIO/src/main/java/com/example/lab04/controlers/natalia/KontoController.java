package com.example.lab04.controlers.natalia;

import com.example.lab04.models.Natalia.Bezpieczenstwo;
import com.example.lab04.models.Natalia.DaneOsobowe;
import com.example.lab04.models.Natalia.Limity;
import com.example.lab04.models.Natalia.Rachunek;
import com.example.lab04.repositories.RepozytoriaWspolne.bankPocztowy.BezpieczenstwoRepozytorium;
import com.example.lab04.repositories.RepozytoriaWspolne.bankPocztowy.DaneOsoboweRepozytorium;
import com.example.lab04.repositories.RepozytoriaWspolne.bankPocztowy.LimityRepozytorium;
import com.example.lab04.repositories.RepozytoriaWspolne.bankPocztowy.RachunekRepozytorium;
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
public class KontoController {
    @Autowired
    DaneOsoboweRepozytorium daneOsoboweRepozytorium;
    @Autowired
    LimityRepozytorium limityRepozytorium;
    @Autowired
    BezpieczenstwoRepozytorium bezpieczenstwoRepozytorium;
    @Autowired
    RachunekRepozytorium rachunekRepozytorium;
    Bezpieczenstwo bezpieczenstwo;
    Limity limity;
    DaneOsobowe daneOsobowe;

    @GetMapping("/dodaj")
    public String dodaj(Model model) {
        model.addAttribute("daneOsobowe", new DaneOsobowe());
        return"Natalia/noweKonto/daneOsobowe";
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
        bezpieczenstwo.setNrKlienta(2548619);
        model.addAttribute("bezpieczenstwo", bezpieczenstwo);
        return "Natalia/noweKonto/bezpieczenstwo";
    }

    @PostMapping("/zapiszBezpieczenstwo")
    public String zapiszBezpieczenstwo(@ModelAttribute("bezpieczenstwo") @Valid Bezpieczenstwo bezpieczenstwo, Errors result) {
        if(result.hasErrors()) {
            return "Natalia/noweKonto/bezpieczenstwo";
        }
        bezpieczenstwo.setNrKlienta(2548619);
        bezpieczenstwoRepozytorium.save(bezpieczenstwo);
        daneOsobowe.setBezpieczenstwo(bezpieczenstwo);
        Rachunek rachunek = new Rachunek(0.0f, "PLN", daneOsobowe);
        daneOsoboweRepozytorium.save(daneOsobowe);
        rachunekRepozytorium.save(rachunek);
        return "Natalia/stronaGlownaBanku";
    }
}
