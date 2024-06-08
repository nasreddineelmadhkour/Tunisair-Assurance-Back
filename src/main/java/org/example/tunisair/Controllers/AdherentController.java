package org.example.tunisair.Controllers;

import org.example.tunisair.Dto.AddAdherentDto;
import org.example.tunisair.Entities.Adherent;
import org.example.tunisair.Services.IServiceAdherent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/adherent")

public class AdherentController {

    @Autowired
    IServiceAdherent iServiceAdherent;


    @PostMapping("/addAdherent/{idEmploye}")
    @PreAuthorize("hasAuthority('EMPLOYE')")
    public Adherent addAdherent(@RequestBody AddAdherentDto adherent, @PathVariable Long idEmploye) {

        Adherent adherent1 = new Adherent();
        adherent1.setCin(adherent.getCin());
        adherent1.setDateNaissance(adherent.getDateNaissance());
        adherent1.setPrenom(adherent.getPrenom());
        adherent1.setNomFamille(adherent.getNomFamille());
        adherent1.setLieux(adherent.getLieux());
        adherent1.setSexe(adherent.getSexe());
        adherent1.setSituationFamilliale(adherent.getSituationFamilliale());
        adherent1.setDateAdhhesionAssurance(adherent.getDateAdhhesionAssurance());
        adherent1.setMatriculeCnam(adherent.getMatriculeCnam());
        adherent1.setTelephone(adherent.getTelephone());
        adherent1.setRib(adherent.getRib());
        adherent1.setAdresseAdherent(adherent.getAdresseAdherent());
        adherent1.setGouvrement(adherent.getGouvrement());
        adherent1.setProffession(adherent.getProffession());
        adherent1.setMontanatSalaire(adherent.getMontanatSalaire());
        adherent1.setEmail(adherent.getEmail());
        adherent1.setCodepostal(adherent.getCodepostal());
        adherent1.setTaille("");
        adherent1.setPoids("");
        adherent1.setMaladie(false);
        adherent1.setInfirmite(false);
        adherent1.setMaladiesPsyciatrique(false);
        adherent1.setMaladiesCancereuses(false);
        adherent1.setOperations(false);
        adherent1.setEpoqueOperations(new Date());
        adherent1.setDescription("");
        adherent1.setDescriptionMaladies("");
        adherent1.setDescriptionInfirmite("");
        adherent1.setDescriptionOperations("");
        adherent1.setDescriptionMaladiesPsyciatrique("");
        adherent1.setDescriptionMaladiesCancereuses("");
        adherent1.setBeneficiaire("");


        System.out.println("hello1");
        return iServiceAdherent.addAdherent(adherent1,idEmploye);
    }



    @GetMapping("/getAllAdherent")
    public List<Adherent> getAllAdherent(){
        return iServiceAdherent.getAllAdherent();
    }

    @GetMapping("/getAccountDetails/{idAccount}")
    public Adherent getAccountDetails(@PathVariable Long idAccount){
        return  iServiceAdherent.getAccountDetails(idAccount);
    }
}
