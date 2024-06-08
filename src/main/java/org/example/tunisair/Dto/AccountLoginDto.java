package org.example.tunisair.Dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import org.example.tunisair.Entities.Role;

import java.util.Date;

@Getter @Setter
public class AccountLoginDto {


    Long idAccount;
    String nom;
    String prenom;
    String token;
    String email;
    String password;

    @Enumerated(EnumType.STRING)
    Role role;

    Date datecreation;


}
