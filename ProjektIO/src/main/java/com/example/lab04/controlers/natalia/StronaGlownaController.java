package com.example.lab04.controlers.natalia;

import com.example.lab04.models.Natalia.Bezpieczenstwo;
import com.example.lab04.models.Natalia.DaneOsobowe;
import com.example.lab04.models.Natalia.Zalogowany;
import com.example.lab04.repositories.RepozytoriaWspolne.bankPocztowy.BezpieczenstwoRepozytorium;
import com.example.lab04.repositories.RepozytoriaWspolne.bankPocztowy.DaneOsoboweRepozytorium;
import com.example.lab04.repositories.RepozytoriaWspolne.bankPocztowy.HistoriaRepozytorium;
import com.example.lab04.repositories.RepozytoriaWspolne.bankPocztowy.RachunekRepozytorium;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    HistoriaRepozytorium historiaRepozytorium;
    @Autowired
    RachunekRepozytorium rachunekRepozytorium;
    Zalogowany zalogowany = new Zalogowany();

    @GetMapping("/bankPocztowy")
    public String bankPocztowy() {
        //przekierowanie na strone glowna banku
        return "Natalia/stronaGlownaBanku";
    }

    @PostMapping("/zaloguj")
    public String zaloguj(@ModelAttribute("form") @Valid FormularzDTO form, Errors result, Model model) {
        if (result.hasErrors()) {
            return "Natalia/stronaGlownaBanku";
        }
        Bezpieczenstwo znalezionyKlient = bezpieczenstwoRepozytorium.findByNrKlientaOrPIN(
                form.getNrKlienta(), form.getNrKlienta());
        zalogowany.setIdZalogowanego(znalezionyKlient.getId());
        zalogowany.setNrZalogowanegoKlienta(znalezionyKlient.getNrKlienta());
        zalogowany.setPINzalogowanego(znalezionyKlient.getPIN());
        model.addAttribute("bezpieczenstwo", znalezionyKlient);
        DaneOsobowe daneOsobowe = daneOsoboweRepozytorium.findByBezpieczenstwo(znalezionyKlient);
        model.addAttribute("daneOsobowe", daneOsobowe);
        model.addAttribute("historia", historiaRepozytorium.findAllByDaneOsobowe(daneOsobowe));
        model.addAttribute("rachunek", rachunekRepozytorium.findByDaneOsobowe(daneOsobowe));
        return "Natalia/mojeKonto";
    }

    @GetMapping("/noweKonto")
    public String noweKonto(Model model) {
        DaneOsobowe daneOsobowe = new DaneOsobowe();
        model.addAttribute("daneOsobowe", daneOsobowe);
        //przekierowanie na strone glowna banku
        return "Natalia/noweKonto/daneOsobowe";
    }
}
