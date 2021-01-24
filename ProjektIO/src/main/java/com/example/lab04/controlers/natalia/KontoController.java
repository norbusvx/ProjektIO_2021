package com.example.lab04.controlers.natalia;

import com.example.lab04.models.Natalia.Bezpieczenstwo;
import com.example.lab04.models.Natalia.DaneOsobowe;
import com.example.lab04.models.Natalia.Limity;
import com.example.lab04.repositories.RepozytoriaWspolne.bankPocztowy.BezpieczenstwoRepozytorium;
import com.example.lab04.repositories.RepozytoriaWspolne.bankPocztowy.DaneOsoboweRepozytorium;
import com.example.lab04.repositories.RepozytoriaWspolne.bankPocztowy.LimityRepozytorium;
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
    Bezpieczenstwo bezpieczenstwo;
    Limity limity;
    DaneOsobowe daneOsobowe;
    private Integer id = 100;

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
        model.addAttribute("bezpieczenstwo", new Bezpieczenstwo());
        return "Natalia/noweKonto/bezpieczenstwo";
    }

    @PostMapping("/zapiszBezpieczenstwo")
    public String zapiszBezpieczenstwo(@ModelAttribute("bezpieczenstwo") @Valid Bezpieczenstwo bezpieczenstwo, Errors result, Model model) {
        if(result.hasErrors()) {
            return "Natalia/noweKonto/bezpieczenstwo";
        }
        bezpieczenstwoRepozytorium.save(bezpieczenstwo);
        daneOsobowe.setBezpieczenstwo(bezpieczenstwo);
        daneOsoboweRepozytorium.save(daneOsobowe);
        return "Natalia/stronaGlownaBanku";
    }
}
