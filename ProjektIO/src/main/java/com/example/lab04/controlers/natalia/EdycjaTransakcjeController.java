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
public class EdycjaTransakcjeController {
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

    Bezpieczenstwo bezpieczenstwo;
    Limity limity;
    DaneOsobowe daneOsobowe;
    Zalogowany zalogowany = new Zalogowany();

    @PostMapping("/zaloguj")
    public String zaloguj(@ModelAttribute("form") @Valid FormularzDTO form, Errors result, Model model) {
        if (result.hasErrors()) {
            return "Natalia/stronaGlownaBanku";
        }

        bezpieczenstwo = bezpieczenstwoRepozytorium.findByNrKlientaOrPIN(
                form.getNrKlienta(), form.getNrKlienta());
        zalogowany.setIdZalogowanego(bezpieczenstwo.getId());
        zalogowany.setNrZalogowanegoKlienta(bezpieczenstwo.getNrKlienta());
        zalogowany.setPINzalogowanego(bezpieczenstwo.getPIN());
        model.addAttribute("bezpieczenstwo", bezpieczenstwo);
        daneOsobowe = daneOsoboweRepozytorium.findByBezpieczenstwo(bezpieczenstwo);
        limity = daneOsobowe.getLimity();
        model.addAttribute("daneOsobowe", daneOsobowe);
        model.addAttribute("historia", historiaRepozytorium.findAllByDaneOsobowe(daneOsobowe));
        model.addAttribute("rachunek", rachunekRepozytorium.findByDaneOsobowe(daneOsobowe));
        return "Natalia/mojeKonto";
    }

    @GetMapping("/edycjaKonta")
    public String edycjaKonta() {
        //przekierowanie na strone glowna banku
        return "Natalia/funkcjeKonta/edycja/edycjaKonta";
    }

    @GetMapping("/mojeKonto")
    public String mojeKonto(Model model) {
        model.addAttribute("bezpieczenstwo", bezpieczenstwo);
        model.addAttribute("daneOsobowe", daneOsobowe);
        model.addAttribute("historia", historiaRepozytorium.findAllByDaneOsobowe(daneOsobowe));
        model.addAttribute("rachunek", rachunekRepozytorium.findByDaneOsobowe(daneOsobowe));
        return "Natalia/mojeKonto";
    }

    @GetMapping("/transakcje")
    public String transakcje() {
        //przekierowanie na strone glowna banku
        return "Natalia/funkcjeKonta/transakcja/wyborTransakcji";
    }

    @GetMapping("/edycjaPodstawowychDanych")
    public String edycjaPodstawowychDanych(Model model) {
        model.addAttribute("daneDoZapisu", daneOsobowe);
        return "Natalia/funkcjeKonta/edycja/edytujKonto/daneOsobowe";
    }

    @PostMapping("/zapiszNoweDaneOsobowe")
    public String zapiszNoweDaneOsobowe(@ModelAttribute("daneDoZapisu") @Valid DaneOsobowe daneDoZapisu, Errors result) {
        if(result.hasErrors()) {
            return "Natalia/funkcjeKonta/edycja/edytujKonto/daneOsobowe";
        }
        daneDoZapisu.setBezpieczenstwo(bezpieczenstwo);
        daneDoZapisu.setLimity(limity);
        daneOsoboweRepozytorium.save(daneDoZapisu);
        daneOsobowe = daneOsoboweRepozytorium.findByBezpieczenstwo(bezpieczenstwo);
        return "Natalia/funkcjeKonta/edycja/edycjaKonta";
    }


    @GetMapping("/edycjaPIN")
    public String edycjaBezpieczenstwo(Model model) {
        model.addAttribute("bezpieczenstwoDoZapisu", bezpieczenstwo);
        return "Natalia/funkcjeKonta/edycja/edytujKonto/bezpieczenstwo";
    }

    @PostMapping("/zapiszNowyPIN")
    public String zapiszNoweBezpieczenstwo(@ModelAttribute("bezpieczenstwoDoZapisu") @Valid Bezpieczenstwo bezpieczenstwoDoZapisu, Errors result) {
        if(result.hasErrors()) {
            return "Natalia/funkcjeKonta/edycja/edytujKonto/bezpieczenstwo";
        }
        bezpieczenstwo = bezpieczenstwoRepozytorium.save(bezpieczenstwoDoZapisu);
        return "Natalia/funkcjeKonta/edycja/edycjaKonta";
    }


    @GetMapping("/edycjaHaslo")
    public String edycjaHaslo(Model model) {
        model.addAttribute("noweHaslo", bezpieczenstwo);
        return "Natalia/funkcjeKonta/edycja/edytujKonto/haslo";
    }

    @PostMapping("/zapiszNoweHaslo")
    public String zapiszNoweHaslo(@ModelAttribute("noweHaslo") @Valid Bezpieczenstwo noweHaslo, Errors result) {
        if(result.hasErrors()) {
            return "Natalia/funkcjeKonta/edycja/edytujKonto/haslo";
        }
        bezpieczenstwo = bezpieczenstwoRepozytorium.save(noweHaslo);
        return "Natalia/funkcjeKonta/edycja/edycjaKonta";
    }




    @GetMapping("/edycjaLimity")
    public String edycjaLimity(Model model) {
        model.addAttribute("noweLimity", limity);
        return "Natalia/funkcjeKonta/edycja/edytujKonto/limity";
    }

    @PostMapping("/zapiszNoweLimity")
    public String zapiszNoweLimity(@ModelAttribute("noweLimity") @Valid Limity noweLimity, Errors result) {
        if(result.hasErrors()) {
            return "Natalia/funkcjeKonta/edycja/edytujKonto/limity";
        }
        limity = limityRepozytorium.save(noweLimity);
        return "Natalia/funkcjeKonta/edycja/edycjaKonta";
    }
}
