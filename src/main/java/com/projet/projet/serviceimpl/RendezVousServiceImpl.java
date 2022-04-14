package com.projet.projet.serviceimpl;

import com.projet.projet.model.Client;
import com.projet.projet.model.RendezVous;
import com.projet.projet.model.User;
import com.projet.projet.repos.ClientRepos;
import com.projet.projet.repos.RendezVousRepos;
import com.projet.projet.repos.UserRepos;
import com.projet.projet.service.RendezVousService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RendezVousServiceImpl implements RendezVousService {

    RendezVousRepos   rendezvousRepos;
    ClientRepos clientRepos;

    public RendezVousServiceImpl(RendezVousRepos rendezvousRepos, UserRepos userRepos) {
        this.rendezvousRepos = rendezvousRepos;
        this.clientRepos = clientRepos;
    }


    @Override
    public List<RendezVous> getAllRendezVousS() {

        return rendezvousRepos.findAll();
    }


    @Override
    @Transactional
    public RendezVous saveRendezVous(RendezVous rendezvous ) {
        try {
            RendezVous bean = (RendezVous) rendezvousRepos.findByLieu(rendezvous.getLieu());
            if (bean != null && bean.getId() > 0) {
                return new RendezVous();
            }
            return rendezvousRepos.save(rendezvous);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new RendezVous();
        }
    }


    @Override
    @Transactional
    public RendezVous update(RendezVous rendezvous) {
        try {
            System.out.println(rendezvous.toString());
            return rendezvousRepos.save(rendezvous);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new RendezVous();
        }
    }

    @Override
    public RendezVous getRendezVous(Long idRendezVous) {
        try {
            Optional<RendezVous> optional = rendezvousRepos.findById(idRendezVous);
            if (optional.isPresent()) {
                return optional.get();
            } else {
                return new RendezVous();
            }
        } catch (Exception e) {
            System.out.println("Erreur: " + e.getMessage());
            return new RendezVous();
        }
    }

    @Override
    public List<RendezVous> getByClientAndJour(Date jour, Long id) {
        try {
            Client client = clientRepos.findById(id).orElse(new Client());
            return rendezvousRepos.findByClientAndJour(jour,client);
        } catch (Exception e) {
            System.out.println("Erreur: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<RendezVous> getByClient(Long id) {
        return rendezvousRepos.getByClient(id);

    }

    @Override
    public List<RendezVous>  getRendezVousByHeure(Date heure) {
        return rendezvousRepos.findByHeure(heure);
    }

    @Override
    public List<RendezVous> getRendezVousByJour(Date jour) {
        return rendezvousRepos.findByJour(jour);
    }

    @Override
    public List<RendezVous> getRendezVousByLieu(String lieu) {
        return rendezvousRepos.findByLieu(lieu);
    }


    @Override
    public String deleteRendezVous(Long id) {
        RendezVous bean = rendezvousRepos.findById(id).orElse(new RendezVous());
        rendezvousRepos.findById(id);
        if (bean.getId() > 0) {
            rendezvousRepos.delete(bean);
            return "Supprimer !";
        }
        return "Erreur";
    }
}
