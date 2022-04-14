package com.projet.projet.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "client")
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(nullable = true)
    private String nom;

    @Column(nullable = true)
    private String prenom;

    private String email;

    private String password;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String departement;

    private Long telephone;

    private String clientcode;

    public Long getId() {
        return id != null ? id : 0;
    }


}
