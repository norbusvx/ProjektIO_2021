package com.example.lab04.controlers.natalia;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Natalia/Glowna")
public class StronaGlownaController {

    @GetMapping("/bankPocztowy")
    public String bankPocztowy() {
        //przekierowanie na strone glowna banku
        return "Natalia/stronaGlownaBanku";
    }

}
