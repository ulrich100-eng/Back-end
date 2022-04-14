package com.projet.projet.service;

import com.projet.projet.model.RendezVous;
import com.projet.projet.model.User;

import java.util.Date;
import java.util.List;

public interface RendezVousService {

    List<RendezVous> getAllRendezVousS();

    RendezVous saveRendezVous (RendezVous rendezvous);

    RendezVous  update (RendezVous rendezvous);

    RendezVous getRendezVous(Long idRendezVous);


    List<RendezVous> getByClientAndJour(Date jour , Long id);

      List<RendezVous>   getByClient(Long id);

   List<RendezVous > getRendezVousByHeure(Date heure);

    List<RendezVous> getRendezVousByJour(Date jour);

    List<RendezVous> getRendezVousByLieu(String lieu);

    String deleteRendezVous  (Long id);


}
