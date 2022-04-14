package com.projet.projet.service;

import com.projet.projet.model.Client;
import com.projet.projet.model.Paiement;
import com.projet.projet.model.RendezVous;
import com.projet.projet.model.User;

import java.util.List;

public interface PaiementService {

    List<Paiement> getAllPaiements();

    Paiement savePaiement (Paiement paiement);

    Paiement  update (Paiement paiement);

    List<Paiement>  getByClient(Long id);

    List<Paiement> getByClientAndService(Long id, String service);

    Paiement getPaiementByModepaiement(String modepaiement);

    Paiement getPaiement(Long idPaiement);

    String deletePaiement (Long id);

}
