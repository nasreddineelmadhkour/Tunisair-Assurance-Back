package org.example.tunisair.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter
public class Enfants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idEnfant;
    String nom;
    String prenom;
    Date dateNaissance;
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
    @ManyToMany(mappedBy = "enfants")
    List<Adherent> adherents = new ArrayList<>();

}
