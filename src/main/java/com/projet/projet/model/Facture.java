package com.projet.projet.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "facture")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Facture  implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;


    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Temporal(TemporalType.DATE)
    private Date datefacture;

    private String departement;

    private Double montantotal;


    private String statut;

    private String service ;

    private Double montantpaye;

    private Double reste;

    public Long getId() {
        return id != null ? id : 0 ;
    }


}
