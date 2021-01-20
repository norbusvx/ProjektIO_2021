package com.example.lab04.controlers;


import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/Natalia")
public class NataliaController {

    @GetMapping("/szegolyProduktu")
    public String szegolyProduktu(Model model) {
        model.addAttribute("produkt", DatabaseDumps.produkty.get(1));
        return "szegolyProduktu";
    }

}
