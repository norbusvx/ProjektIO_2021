package com.example.lab04.repositories.RepozytoriaWspolne.repozytoriaOkienko;

import com.example.lab04.OpakowanieZbiorcze;
import com.example.lab04.Swiadczenie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SwiadczeniaRepozytorium extends JpaRepository<Swiadczenie, Integer> {
    Page<Swiadczenie> findSwiadczeniesByStatus(Boolean status, Pageable pageable);
}
