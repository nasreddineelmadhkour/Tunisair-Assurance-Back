
package org.example.tunisair.Services;

import org.example.tunisair.Entities.Adherent;
import org.example.tunisair.Entities.Enfants;
import org.example.tunisair.Repository.AdherentRepository;
import org.example.tunisair.Repository.EnfantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceEnfants implements IServiceEnfants {

    @Autowired
    EnfantsRepository enfantsRepository;
    @Autowired
    AdherentRepository adherentRepository;


    @Override
    public Adherent addEnfants(Enfants enfants, Long idAdherent) {

        Adherent adherent = adherentRepository.findById(idAdherent).orElse(null);
        if(adherent!=null){
            adherent.getEnfants().add(enfants);
            return adherentRepository.save(adherent);

        }

        return null;

    }

    @Override
    public void deleteEnfant(Long idEnfant) {


        enfantsRepository.deleteById(idEnfant);
    }

    @Override
    public Enfants updateEnfant(Enfants enfants, Long idEnfant) {
        Enfants enfants1 = enfantsRepository.findById(idEnfant).orElse(null);

        if(enfants1!=null){
            enfants.setIdEnfant(enfants1.getIdEnfant());
        return enfantsRepository.save(enfants);
        }


        return null;
    }


}
