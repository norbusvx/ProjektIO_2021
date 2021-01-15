package com.example.lab04.services;

import com.example.lab04.Uzytkownik;
import com.example.lab04.repositories.RepozytoriaWspolne.UzytkownikRepozytorium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImplementation implements UserDetailsService {

    @Autowired
    UzytkownikRepozytorium uzytkownikRepozytorium;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return uzytkownikRepozytorium.findUzytkownikByLogin(s);
    }

    public void dodajUzytkownika(Uzytkownik uzytkownik){
        Uzytkownik doZapisania = new Uzytkownik(uzytkownik.getLogin(),
                passwordEncoder.encode(uzytkownik.getHaslo()),
                uzytkownik.getNrUrzedu());

        uzytkownikRepozytorium.save(doZapisania);
    }

    public Uzytkownik zwrocUzytkownika(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        return uzytkownikRepozytorium.findUzytkownikByLogin(currentPrincipalName);
    }



}
