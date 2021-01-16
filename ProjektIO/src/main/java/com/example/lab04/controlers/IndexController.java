package com.example.lab04.controlers;

import com.example.lab04.Uzytkownik;
import com.example.lab04.services.UserDetailServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class IndexController {

    @Autowired
    UserDetailServiceImplementation userDetailServiceImplementation;

//    @RequestMapping("/")
//    public String zwrocGlowna(Model model){
//        model.addAttribute("userDoWypisania", userDetailServiceImplementation.zwrocUzytkownika());
//
//        return "index";
//    }

//    @ModelAttribute("userDoWypisania")
//    public Uzytkownik zwrocUzytkownika(){return userDetailServiceImplementation.zwrocUzytkownika();}
//    public Uzytkownik zwrocUzytkownika() {
//        return new Uzytkownik("sadads", 5);
//    }

    @RequestMapping("/test")
    public String zwrocTest(Model model){
        model.addAttribute("userDoWypisania", userDetailServiceImplementation.zwrocUzytkownika());

        return "testU";
    }


}
