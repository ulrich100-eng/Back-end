package com.projet.projet.service;

import com.projet.projet.model.Facture;
import com.projet.projet.model.Paiement;
import com.projet.projet.model.User;

import java.util.List;

public interface FactureService {

    List<Facture> getAllFactures();

    Facture saveFacture (Facture facture);

    Facture  update (Facture facture);

     Facture getFactureByDepartement(String departement);


    List<Facture>  getByClient(Long id);

    Facture getFacture(Long idFacture);

    String deleteFacture (Long idFacture);
}
