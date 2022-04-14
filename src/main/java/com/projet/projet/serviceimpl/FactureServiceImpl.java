package com.projet.projet.serviceimpl;

import com.projet.projet.model.Facture;
import com.projet.projet.model.Paiement;
import com.projet.projet.model.User;
import com.projet.projet.repos.FactureRepos;
import com.projet.projet.repos.PaiementRepos;
import com.projet.projet.repos.UserRepos;
import com.projet.projet.service.FactureService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class FactureServiceImpl implements FactureService {

    FactureRepos factureRepos;
    PaiementRepos paiementRepos;

    public FactureServiceImpl(FactureRepos factureRepos, UserRepos userRepos) {
        this.factureRepos = factureRepos;
        this.paiementRepos =paiementRepos;

    }


    @Override
    public List<Facture> getAllFactures() {
        return factureRepos.findAll();
    }

    @Override
    public Facture saveFacture(Facture facture) {
        try {
            Facture bean = factureRepos.findByDepartement(facture.getDepartement());
            if (bean != null && bean.getId() > 0) {
                return new Facture();
            }
            return factureRepos.save(facture);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Facture();
        }
    }

    @Override
    @Transactional
    public Facture update(Facture facture) {
        try {
            System.out.println(facture.toString());
            return factureRepos.save(facture);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Facture();
        }
    }

    @Override
    public Facture getFactureByDepartement(String departement) {
        return factureRepos.findByDepartement(departement);
    }


    @Override
    public List<Facture> getByClient(Long id) {
        return factureRepos.getByClient(id);
    }



    @Override
    public Facture getFacture(Long idFacture) {
        try {
            Optional<Facture> optional = factureRepos.findById(idFacture);
            if (optional.isPresent()) {
                return optional.get();
            } else {
                return new Facture();
            }
        } catch (Exception e) {
            System.out.println("Erreur: " + e.getMessage());
            return new Facture();
        }
    }



    @Override
    public String deleteFacture(Long idFacture) {
        Facture bean = factureRepos.findById(idFacture).orElse(new Facture());
        factureRepos.findById(idFacture);
        if (bean.getId() > 0) {
            factureRepos.delete(bean);
            return "Supprimer !";
        }
        return "Erreur";
    }
}
