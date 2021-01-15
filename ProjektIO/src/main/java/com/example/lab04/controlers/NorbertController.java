package com.example.lab04.controlers;


import com.example.lab04.Uzytkownik;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/Norbert")
public class NorbertController {

    @GetMapping("/rejestracja")
    public String rejestrujUzytkownika(Model model) {

        model.addAttribute("uzytkownik", new Uzytkownik());
        return "Norbert/rejestracjaForm";
    }

    @PostMapping(value = {"/rejestracja"})
    public String procesForm(@ModelAttribute Uzytkownik uzytkownik, BindingResult result) {

        if(result.hasErrors()){
            return "Norbert/rejestracjaForm";
        }

        //obrazRepozytorium.save(obraz);


        return "loginForm";
    }





    @GetMapping("/wyslijPrzelew")
    public String wyswietlForm(Model model) {

        //model.addAttribute("uzytkownik", new Uzytkownik());
        return "Norbert/wyslijPrzelewForm";
    }


}
