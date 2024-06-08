package org.example.tunisair.Entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class BullteinSoins {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idBullteinSoins;

    String numBulltein;
    String matricule;
    Long codePrestataire;
    @JsonIgnore
    @ManyToOne
    Adherent adherent;

}
