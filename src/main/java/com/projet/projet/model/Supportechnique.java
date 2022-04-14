package com.projet.projet.model;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "supportechnique")
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Supportechnique implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;


    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    private String problematique;



    @Column(nullable = true)
    private String rapportfinal;

    private String conclusion;


    public Long getId() {
        return id != null ? id : 0;
    }


}
