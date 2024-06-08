package org.example.tunisair.Controllers;

import org.example.tunisair.Entities.Adherent;
import org.example.tunisair.Entities.Conjoint;
import org.example.tunisair.Services.IServiceConjoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conjoint")
public class ConjointController {


    @Autowired
    IServiceConjoint iServiceConjoint;

    @PostMapping("/addConjoint/{idAdherent}")
    public Adherent addConjoint(@RequestBody Conjoint conjoint, @PathVariable Long idAdherent){
        return iServiceConjoint.addConjoint(conjoint,idAdherent);
    }

    @PutMapping("/updateConjoint/{idConjoint}")
    public Conjoint updateConjoint(@RequestBody Conjoint conjoint, @PathVariable Long idConjoint){
        return iServiceConjoint.updateConjoint(conjoint,idConjoint);
    }
    @DeleteMapping("/deleteConjoint/{idConjoint}")
    public void deleteConjoint(@PathVariable Long idConjoint){
         iServiceConjoint.deleteConjoint(idConjoint);
    }

}
