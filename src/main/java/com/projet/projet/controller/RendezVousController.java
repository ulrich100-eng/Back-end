package com.projet.projet.controller;

import com.projet.projet.model.RendezVous;
import com.projet.projet.service.RendezVousService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v2")

public class RendezVousController {

    public RendezVousService service;

    public RendezVousController(RendezVousService service) {
        this.service = service;
    }


    //  get All rendezvouss
    // http://localhost:8080/api/v2/rendezvousS
    @GetMapping("/rendezvousS")
    public List<RendezVous> getAllRendezVousS() {return this.service.getAllRendezVousS();}


    @GetMapping("/rendezvouss/{idRendezVous}")
    public RendezVous getRendezVous(@PathVariable("idRendezVous") Long idRendezVous) {
        return this.service.getRendezVous(idRendezVous);
    }


    @PostMapping("/addRendezVous")
    public RendezVous saveRendezVous(@RequestBody RendezVous rendezvous){
        return this.service.saveRendezVous(rendezvous);
    }



    @GetMapping("/rendezvousByHeure/{heure}")
    public List<RendezVous> findRendezVousByHeure(@PathVariable Date heure) {
        return this.service.getRendezVousByHeure(heure);
    }

    @GetMapping("/rendezvousByJour/{jour}")
    public List <RendezVous> findRendezVousByJour(@PathVariable Date jour) {
        return this.service.getRendezVousByJour(jour);
    }



    @GetMapping("/rendezvousByLieu/{lieu}")
    public List<RendezVous> findRendezVousByLieu(@PathVariable String lieu) {
        return this.service.getRendezVousByLieu(lieu);
    }

    @GetMapping("/rendezvousByClient/{id}")
        public List<RendezVous> findByClient(@PathVariable("id") Long id){
        return this.service.getByClient(id);
        }

    @GetMapping("/jour/{jour}/client/{id}")
    public List<RendezVous> findByClientAndJour(@PathVariable("jour") Date jour, @PathVariable("id") Long id){
        return this.service.getByClientAndJour(jour,id);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody RendezVous rendezvous){
        RendezVous update = this.service.update(rendezvous);
        if (update.getId() > 0) {
            return new ResponseEntity<>(update, HttpStatus.OK);
        }
        return new ResponseEntity<>(update, HttpStatus.BAD_REQUEST);
    }


    @DeleteMapping("/delete/{id}")
    public  String deleteRendezVous(@PathVariable("id") Long id){
        System.out.println(id);
        return this.service.deleteRendezVous(id);
    }
}
