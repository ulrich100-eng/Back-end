package com.projet.projet.controller;

import com.projet.projet.model.RendezVous;
import com.projet.projet.model.Supportechnique;
import com.projet.projet.service.RendezVousService;
import com.projet.projet.service.SupportechniqueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v5")
public class SupportechniqueController {

    public SupportechniqueService service;

    public SupportechniqueController(SupportechniqueService service) {
        this.service = service;
    }

    //  get All supportechniques
    // http://localhost:8080/api/v5/supportechniques
    @GetMapping("/supportechniques")
    public List<Supportechnique> getAllSupportechniques() {return this.service.getAllSupportechniques();}


    @GetMapping("/supportechniques/{id}")
    public Supportechnique getSupportechnique(@PathVariable("id") Long id) {
        return this.service.getSupportechnique(id);
    }

    @GetMapping("/supportechniqueByUser/{id}")
    public List<Supportechnique> findByClient(@PathVariable("id") Long id){

        return this.service.getByClient(id);
    }


    @PostMapping("/addSupportechnique")
    public Supportechnique saveSupportechnique(@RequestBody Supportechnique supportechnique){
        System.out.println(supportechnique);
        return this.service.saveSupportechnique(supportechnique);
    }


    @GetMapping("/supportechniqueByProblematique/{problematique}")
    public Supportechnique findSupportechniqueByProblematique(@PathVariable String problematique) {
        return this.service.getSupportechniqueByProblematique(problematique);
    }


    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Supportechnique supportechnique){
        Supportechnique update = this.service.update(supportechnique);
        if (update.getId() > 0) {
            return new ResponseEntity<>(update, HttpStatus.OK);
        }
        return new ResponseEntity<>(update, HttpStatus.BAD_REQUEST);

    }

    @DeleteMapping("/delete/{idSupportechnique}")
    public  String deleteSupportechnique(@PathVariable("idSupportechnique") Long idSupportechnique){
        System.out.println(idSupportechnique);
        return this.service.deleteSupportechnique(idSupportechnique);
    }


}
