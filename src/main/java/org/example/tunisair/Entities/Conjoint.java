package org.example.tunisair.Entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Entity

public class Conjoint {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
            Long idConjoint;
    String nom;

    String prenom;
    String profession;
    String employeur;
    String taille;
    String poids;
    boolean maladie;
    boolean infirmite;
    boolean maladiesPsyciatrique;
    boolean maladiesCancereuses;
    boolean operations;
    Date epoqueOperations;
    String descriptionMaladies;
    String descriptionInfirmite;
    String descriptionMaladiesPsyciatrique;
    String descriptionMaladiesCancereuses;
    String descriptionOperations;

    @JsonIgnore
    @OneToOne(mappedBy = "conjoint")
    Adherent adherent;



}
