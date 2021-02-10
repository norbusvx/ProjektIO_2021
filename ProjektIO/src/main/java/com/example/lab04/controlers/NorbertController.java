package com.example.lab04.controlers;


import com.example.lab04.*;
import com.example.lab04.repositories.RepozytoriaWspolne.PrzesylkaRepozytorium;
import com.example.lab04.repositories.RepozytoriaWspolne.repozytoriaOkienko.KasaRepozytorium;
import com.example.lab04.repositories.RepozytoriaWspolne.repozytoriaOkienko.OpakowanieRepozytorium;
import com.example.lab04.repositories.RepozytoriaWspolne.repozytoriaOkienko.PrzelewRepozytorium;
import com.example.lab04.repositories.RepozytoriaWspolne.repozytoriaOkienko.SwiadczeniaRepozytorium;
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
import java.util.Optional;

@Controller
@RequestMapping("/Norbert")
public class NorbertController {

    @Autowired
    UserDetailServiceImplementation userDetailServiceImplementation;

    @Autowired
    KasaRepozytorium kasaRepozytorium;

    @Autowired
    PrzesylkaRepozytorium przesylkaRepozytorium;

    @Autowired
    OpakowanieRepozytorium opakowanieRepozytorium;

    @Autowired
    SwiadczeniaRepozytorium swiadczeniaRepozytorium;

    @Autowired
    PrzelewRepozytorium przelewRepozytorium;

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


    @GetMapping("/oplac")
    public String wyswietlForm(Model model) {

        model.addAttribute("przelew", new Przelew());

        return "Norbert/wyslijPrzelewForm";
    }

    @PostMapping(value = {"/oplac"})
    public String oplac(@ModelAttribute Przelew przelew, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "Norbert/glowna";
        }


        przelewRepozytorium.save(przelew);

        return "Norbert/glowna";
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

        Page page = kasaRepozytorium.findAll(pageable);


        model.addAttribute("page", page);

        return "Norbert/historiaKasy";
    }

    @RequestMapping(value = {"/wydajPrzesylke"})
    public String wydajPrzesylke(
            Model model,
            @PageableDefault(sort = "id") Pageable pageable) {

        int nrUrzedu = userDetailServiceImplementation.zwrocUzytkownika().getNrUrzedu();
        Page page = przesylkaRepozytorium.findObrazByWydanaAndNrUrzeduAndCzyWZbiorczym(false, nrUrzedu, false, pageable);


        model.addAttribute("page", page);

        return "Norbert/wydajPrzesylke";
    }

    @GetMapping("/wydaj/{id}")
    public String wydaj(@PathVariable(name = "id") int id, Model model) {
        int index = id;
        Przesylka p = przesylkaRepozytorium.findById(index).get();
        p.setWydana(true);
        przesylkaRepozytorium.save(p);

        return "Norbert/glowna";
    }

    //odbieranie przesyłki*******************************************************************************************

    @RequestMapping(value = {"/odbierzPrzesylke"})
    public String odbierzPrzesylke(
            Model model,
            @PageableDefault(sort = "id") Pageable pageable) {

        int nrUrzedu = userDetailServiceImplementation.zwrocUzytkownika().getNrUrzedu();
        Page page = przesylkaRepozytorium.findObrazByWydanaAndTransportowanaAndNrUrzeduNotLikeAndCzyWZbiorczym(false, true, nrUrzedu, false, pageable);


        model.addAttribute("page", page);

        return "Norbert/odbierzPrzesylke";
    }

    @GetMapping("/odbierz/{id}")
    public String odbierz(@PathVariable(name = "id") int id, Model model) {
        int index = id;
        int nrUrzedu = userDetailServiceImplementation.zwrocUzytkownika().getNrUrzedu();
        Przesylka p = przesylkaRepozytorium.findById(index).get();
        p.setwTransporcie(false);
        p.setNrUrzedu(nrUrzedu);
        przesylkaRepozytorium.save(p);

        return "Norbert/glowna";
    }

    //przekaż do transportu*******************************************************************************************

    @RequestMapping(value = {"/dajDoTransportu"})
    public String dajDoT(
            Model model,
            @PageableDefault(sort = "id") Pageable pageable) {

        int nrUrzedu = userDetailServiceImplementation.zwrocUzytkownika().getNrUrzedu();
        Page page = przesylkaRepozytorium.findObrazByWydanaAndTransportowanaNotLikeAndNrUrzeduAndCzyWZbiorczym(false, true, nrUrzedu, false, pageable);


        model.addAttribute("page", page);

        return "Norbert/dajDoTransportu";
    }

    @GetMapping("/daj/{id}")
    public String daj(@PathVariable(name = "id") int id, Model model) {
        int index = id;
        int nrUrzedu = userDetailServiceImplementation.zwrocUzytkownika().getNrUrzedu();
        Przesylka p = przesylkaRepozytorium.findById(index).get();
        p.setwTransporcie(true);
        przesylkaRepozytorium.save(p);

        return "Norbert/glowna";
    }

    //zbiorcze ***************************************************************************************************

    @RequestMapping(value = {"/dodajZbiorcze"})
    public String dodajZbiorcze(
            Model model,
            @PageableDefault(sort = "id") Pageable pageable) {

        int nrUrzedu = userDetailServiceImplementation.zwrocUzytkownika().getNrUrzedu();
        Page page = przesylkaRepozytorium.findObrazByWydanaAndTransportowanaNotLikeAndNrUrzeduAndOpakowanieZbiorcze(false, true, nrUrzedu, false, pageable);


        model.addAttribute("page", page);

        return "Norbert/dodajZbiorcze";
    }


    @GetMapping("/dodajZ/{id}")
    public String dodajZ(@PathVariable(name = "id") int id, Model model) {
        int index = id;
        Przesylka p = przesylkaRepozytorium.findById(index).get();
        p.setOpakowanieZbiorcze(true);
        przesylkaRepozytorium.save(p);
        opakowanieRepozytorium.save(new OpakowanieZbiorcze(p));

        return "Norbert/glowna";
    }

    @RequestMapping(value = {"/dodajDoZbiorczego"})
    public String dodajDoZbiorcze(
            Model model,
            @PageableDefault(sort = "id") Pageable pageable) {

        int nrUrzedu = userDetailServiceImplementation.zwrocUzytkownika().getNrUrzedu();
        Page page = przesylkaRepozytorium.findObrazByWydanaAndTransportowanaNotLikeAndNrUrzeduAndOpakowanieZbiorcze(false, true, nrUrzedu, true, pageable);


        model.addAttribute("page", page);

        return "Norbert/dodajDoZbiorczego";
    }


    @GetMapping("/dodajDoZ/{id}")
    public String dodajDoZ(@PathVariable(name = "id") int id, Model model,
                           @PageableDefault(sort = "id") Pageable pageable) {
        int index = id;
        int nrUrzedu = userDetailServiceImplementation.zwrocUzytkownika().getNrUrzedu();
        Page page = przesylkaRepozytorium.findObrazByWydanaAndTransportowanaNotLikeAndNrUrzeduAndCzyWZbiorczymAndIdNotLike(false, true, nrUrzedu, false, index, pageable);
        model.addAttribute("page", page);

        Przesylka p = przesylkaRepozytorium.findById(index).get();//przesyłka która jest opakowaniem

        OpakowanieZbiorcze o = opakowanieRepozytorium.findObrazByOpakowanie(p);
        model.addAttribute("opakowanie", o);

        return "Norbert/dodajDoZ";
    }

    @GetMapping("/dodajDoZ2/{id}")
    public String dodajDoZ2(@PathVariable(name = "id") int id, @ModelAttribute OpakowanieZbiorcze o){

        int index = id;



        Przesylka p = przesylkaRepozytorium.findById(index).get();
        o.dodajPrzesylke(p);
        opakowanieRepozytorium.save(o);



        return "Norbert/glowna";
    }

    //wypłata świadczeń************************************************************************************************************************

    @RequestMapping(value = {"/wyplac"})
    public String wyplac(
            Model model,
            @PageableDefault(sort = "id") Pageable pageable) {


        Page page = swiadczeniaRepozytorium.findSwiadczeniesByStatus(false, pageable);


        model.addAttribute("page", page);

        return "Norbert/wyplacSwiadczenie";
    }

    @GetMapping("/wyplacSw/{id}")
    public String wyplacSw(@PathVariable(name = "id") int id, Model model) {
        int index = id;

        Swiadczenie p = swiadczeniaRepozytorium.findById(index).get();
        p.setStatus(true);
        swiadczeniaRepozytorium.save(p);

        return "Norbert/glowna";
    }


}
