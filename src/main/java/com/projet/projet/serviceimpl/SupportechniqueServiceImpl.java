package com.projet.projet.serviceimpl;

import com.projet.projet.model.RendezVous;
import com.projet.projet.model.Supportechnique;
import com.projet.projet.repos.RendezVousRepos;
import com.projet.projet.repos.SupportechniqueRepos;
import com.projet.projet.repos.UserRepos;
import com.projet.projet.service.SupportechniqueService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SupportechniqueServiceImpl implements SupportechniqueService {

    SupportechniqueRepos supportechniqueRepos;
     UserRepos         userRepos;


    public SupportechniqueServiceImpl(SupportechniqueRepos supportechniqueRepos,UserRepos userRepos) {
        this.supportechniqueRepos = supportechniqueRepos;
        this.userRepos = userRepos;
    }

    @Override
    public List<Supportechnique> getAllSupportechniques() {
        return supportechniqueRepos.findAll();
    }


    @Override
    public Supportechnique saveSupportechnique(Supportechnique supportechnique) {
        try {
            Supportechnique bean = supportechniqueRepos.findByProblematique(supportechnique.getProblematique());
            if (bean != null && bean.getId() > 0) {
                return new Supportechnique();
            }
            return supportechniqueRepos.save(supportechnique);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Supportechnique();
        }
    }

    @Override
    public Supportechnique update(Supportechnique supportechnique) {
        try {
            System.out.println(supportechnique.toString());
            return supportechniqueRepos.save(supportechnique);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new Supportechnique();
        }
    }

    @Override
    public Supportechnique getSupportechnique(Long idSupportechnique) {
        try {
            Optional<Supportechnique> optional = supportechniqueRepos.findById(idSupportechnique);
            if (optional.isPresent()) {
                return optional.get();
            } else {
                return new Supportechnique();
            }
        } catch (Exception e) {
            System.out.println("Erreur: " + e.getMessage());
            return new Supportechnique();
        }
    }

    @Override
    public List<Supportechnique> getByClient(Long id) {
        return supportechniqueRepos.getByClient(id);
    }

    @Override
    public Supportechnique getSupportechniqueByProblematique(String problematique) {
        return supportechniqueRepos.findByProblematique(problematique);
    }


    @Override
    public String deleteSupportechnique(Long idSupportechnique) {
        Supportechnique bean = supportechniqueRepos.findById(idSupportechnique).orElse(new Supportechnique());
        supportechniqueRepos.findById(idSupportechnique);
        if (bean.getId() > 0) {
            supportechniqueRepos.delete(bean);
            return "Supprimer !";
        }
        return "Erreur";
    }
}
