package org.example.tunisair.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.*;

@Data
@Entity
@Table(name = "account")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idAccount;
    String nom;
    String prenom;
    String email;
    String password;
    @JsonIgnore
    @Enumerated(EnumType.STRING)
    Role role;
    @JsonIgnore
    Date datecreation;

    @JsonIgnore
    @OneToMany (mappedBy = "employe")
    List<Adherent> adherents = new ArrayList<>();




}
