package com.example.lab04;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Collection;

@Entity
public class Uzytkownik implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String login;

    private String haslo;

    private Integer nrUrzedu;

    public Uzytkownik(String login, String haslo, Integer nrUrzedu) {
        this.login = login;
        this.haslo = haslo;
        this.nrUrzedu = nrUrzedu;
    }

    public Uzytkownik() {
    }

    public Uzytkownik(String login, Integer nrUrzedu) {
        this.login = login;
        this.nrUrzedu = nrUrzedu;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public Integer getNrUrzedu() {
        return nrUrzedu;
    }

    public void setNrUrzedu(Integer nrUrzedu) {
        this.nrUrzedu = nrUrzedu;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return haslo;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
