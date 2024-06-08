package org.example.tunisair.Entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Entity @Getter
@Setter
public class Adherent {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idAdherent;
    String nomFamille;
    String prenom;
    Date dateNaissance;
    String lieux;
    String sexe;
    String situationFamilliale;
    Date dateAdhhesionAssurance;
    String cin;
    String matriculeCnam;
    String telephone;
    String rib;
    String adresseAdherent;
    String gouvrement;
    String proffession;
    Double montanatSalaire;
    String email;
    String codepostal;


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
    String beneficiaire;
    String description;

    @ManyToMany(cascade = CascadeType.ALL)
    List<Enfants> enfants= new ArrayList<>();
    @OneToOne (cascade = CascadeType.ALL)
    Conjoint conjoint;
    @OneToMany(mappedBy = "adherent")
    List<BullteinSoins> bullteinSoins=new ArrayList<>();





    @ManyToOne
    Account employe ;
}
