package org.example.tunisair.Controllers;

import org.example.tunisair.Entities.BullteinSoins;
import org.example.tunisair.Services.IServiceBullteinSoins;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bullteinSoins")
public class BullteinSoinsController {

    @Autowired
    IServiceBullteinSoins iServiceBullteinSoins;



    @PostMapping("/addBullteinSoins/{idAdherent}")
    public BullteinSoins addBullteinSoins(@RequestBody BullteinSoins bullteinSoins , @PathVariable Long idAdherent){
        return iServiceBullteinSoins.addBullteinSoins(bullteinSoins,idAdherent);
    }

    @GetMapping("/getAllBullteinSoins")
    public List<BullteinSoins> getAllBullteinSoins(){
        return iServiceBullteinSoins.getAllBullteinSoins();
    }

    @GetMapping("/getAllBullteinSoinsByAdherent/{idAdherent}")
    public List<BullteinSoins> getAllBullteinSoinsByAdherent(@PathVariable Long idAdherent){
        return iServiceBullteinSoins.getAllBullteinSoinsByAdherent(idAdherent);
    }

    @PutMapping("/updateBullteinSoins/{idBullteinSoins}")
    public BullteinSoins updateBullteinSoins(@RequestBody BullteinSoins bullteinSoins , @PathVariable Long idBullteinSoins)
    {
        return iServiceBullteinSoins.updateBullteinSoins(bullteinSoins, idBullteinSoins);
    }

    @DeleteMapping("/deleteBullteinSoins/{idBullteinSoins}")
    public void deleteBullteinSoins(@PathVariable Long idBullteinSoins){
        iServiceBullteinSoins.deleteBullteinSoins(idBullteinSoins);
    }


}
