package com.projet.projet.serviceimpl;

import com.projet.projet.model.*;
import com.projet.projet.repos.*;
import com.projet.projet.service.PaiementService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PaiementServiceImpl implements PaiementService {



    PaiementRepos paiementRepos;
      ClientRepos clientRepos;

    public PaiementServiceImpl(PaiementRepos paiementRepos , ClientRepos clientRepos) {
        this.paiementRepos = paiementRepos;
        this.clientRepos= clientRepos;

    }

    @Override
    public List<Paiement> getAllPaiements() {
        return paiementRepos.findAll();
    }


    @Override
    public Paiement savePaiement(Paiement paiement) {
        try {
            Paiement bean = paiementRepos.findByModepaiement(paiement.getModepaiement());
            if (bean != null && bean.getId() > 0) {
                return new Paiement();
            }
            return paiementRepos.save(paiement);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Paiement();
        }
    }


    @Override
    @Transactional
    public Paiement update(Paiement paiement) {
        try {
            System.out.println(paiement.toString());
            return paiementRepos.save(paiement);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Paiement();
        }
    }

    @Override
    public List<Paiement> getByClient(Long id) {
        return paiementRepos.getByClient(id);

    }


    @Override
    public List<Paiement> getByClientAndService( Long id,String service) {
        try {
              Client client = clientRepos.findById(id).orElse(new Client());
            return paiementRepos.findByClientAndService(client,service);
        } catch (Exception e) {
            System.out.println("Erreur: " + e.getMessage());
            return null;
        }
    }


    @Override
    public Paiement getPaiementByModepaiement(String modepaiement) {
        return paiementRepos.findByModepaiement(modepaiement);
    }

    @Override
    public Paiement getPaiement(Long idPaiement) {
        try {
            Optional<Paiement> optional = paiementRepos.findById(idPaiement);
            if (optional.isPresent()) {
                return optional.get();
            } else {
                return new Paiement();
            }
        } catch (Exception e) {
            System.out.println("Erreur: " + e.getMessage());
            return new Paiement();
        }
    }

    @Override
    public String deletePaiement(Long idPaiement) {
        Paiement bean = paiementRepos.findById(idPaiement).orElse(new Paiement());
        paiementRepos.findById(idPaiement);
        if (bean.getId() > 0) {
            paiementRepos.delete(bean);
            return "Supprimer !";
        }
        return "Erreur";
    }
}
