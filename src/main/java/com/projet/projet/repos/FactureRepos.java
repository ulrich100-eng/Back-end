package com.projet.projet.repos;

import com.projet.projet.model.Facture;
import com.projet.projet.model.Paiement;
import com.projet.projet.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FactureRepos extends JpaRepository<Facture,Long> {


    List<Facture>  getByClient(Long id);


    Optional<Facture> findById(Long id);

    Facture findByDepartement(String departement);
}
