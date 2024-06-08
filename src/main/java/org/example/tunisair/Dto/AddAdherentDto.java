package org.example.tunisair.Dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter @Data
public class AddAdherentDto {
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

}
