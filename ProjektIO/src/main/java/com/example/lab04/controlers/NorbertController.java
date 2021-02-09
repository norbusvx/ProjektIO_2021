package com.example.lab04.controlers;


import com.example.lab04.Kasa;
import com.example.lab04.Uzytkownik;
import com.example.lab04.repositories.RepozytoriaWspolne.repozytoriaOkienko.KasaRepozytorium;
import com.example.lab04.services.UserDetailServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/Norbert")
public class NorbertController {

    @Autowired
    UserDetailServiceImplementation userDetailServiceImplementation;

    @Autowired
    KasaRepozytorium kasaRepozytorium;

    @GetMapping("/rejestracja")
    public String rejestrujUzytkownika(Model model) {

        model.addAttribute("uzytkownik", new Uzytkownik());
        return "Norbert/rejestracjaForm";
    }

    @PostMapping(value = {"/rejestracja"})
    public String procesForm(@ModelAttribute Uzytkownik uzytkownik, BindingResult result) {

        if (result.hasErrors()) {
            return "Norbert/rejestracjaForm";
        }

        userDetailServiceImplementation.dodajUzytkownika(uzytkownik);


        return "loginForm";
    }


    @GetMapping("/wyslijPrzelew")
    public String wyswietlForm(Model model) {

        //model.addAttribute("uzytkownik", new Uzytkownik());
        return "Norbert/wyslijPrzelewForm";
    }

    @GetMapping("/glowna")
    public String glowna(Model model) {


        return "Norbert/glowna";
    }



    @GetMapping("/kasa")
    public String obslugaKLasy(Model model) {

        model.addAttribute("podsumowanie", new Kasa());

        return "Norbert/kasa";
    }

    @PostMapping(value = {"/kasa"})
    public String przeliczenieKasy(@ModelAttribute Kasa podsumowanie, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "Norbert/glowna";
        }

        podsumowanie.obliczReszte();
        kasaRepozytorium.save(podsumowanie);

        model.addAttribute("podsumowanie", podsumowanie);
        return "Norbert/kasa";
    }

    @RequestMapping(value = {"/historiaKasy"})
    public String historiaKasy(
            Model model,
            @PageableDefault(sort = "ID") Pageable pageable) {

        Page page=kasaRepozytorium.findAll(pageable);


        model.addAttribute("page", page);

        return "Norbert/historiaKasy";
    }

}
