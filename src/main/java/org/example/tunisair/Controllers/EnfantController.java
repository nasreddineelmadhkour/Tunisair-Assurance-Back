package org.example.tunisair.Controllers;

import org.example.tunisair.Entities.Adherent;
import org.example.tunisair.Entities.Enfants;
import org.example.tunisair.Services.IServiceAdherent;
import org.example.tunisair.Services.IServiceEnfants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/enfant")
@RestController
public class EnfantController {

    @Autowired
    IServiceEnfants iServiceEnfants;


    @PostMapping("/addEnfant/{idAdherent}")
    public Adherent addEnfant(@RequestBody Enfants enfants , @PathVariable Long idAdherent){
        return iServiceEnfants.addEnfants(enfants,idAdherent);
    }
    @PutMapping("/updateEnfant/{idEnfant}")
    public Enfants updateEnfant(@RequestBody Enfants enfants , @PathVariable Long idEnfant){
        return iServiceEnfants.updateEnfant(enfants,idEnfant);
    }
    @DeleteMapping("/deleteEnfant/{idEnfant}")
    public void deleteEnfant( @PathVariable Long idEnfant){
        iServiceEnfants.deleteEnfant(idEnfant);
    }
}
