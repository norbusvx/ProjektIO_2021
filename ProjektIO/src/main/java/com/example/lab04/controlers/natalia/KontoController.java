package com.example.lab04.controlers.natalia;

import com.example.lab04.models.Natalia.DaneOsobowe;
import com.example.lab04.repositories.RepozytoriaWspolne.bankPocztowy.DaneOsoboweRepozytorium;
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

    @GetMapping("/dodaj")
    public String dodaj(Model model) {
        model.addAttribute("daneOsobowe", new DaneOsobowe());
        return"Natalia/konto/formularz";
    }

    @PostMapping("/zapisz")
    public String zapisz(@ModelAttribute("daneOsobowe") @Valid DaneOsobowe daneOsobowe, Errors result) {
        if(result.hasErrors()) {
            return "Natalia/konto/formularz";
        }
        daneOsoboweRepozytorium.save(daneOsobowe);
        return "Natalia/konto/zatwierdzenieDanych";
    }

    @GetMapping("/kontaktForm")
    public String kontaktForm() {
        //kontaktForm
        return "Natalia/konto/kontaktForm";
    }

}
