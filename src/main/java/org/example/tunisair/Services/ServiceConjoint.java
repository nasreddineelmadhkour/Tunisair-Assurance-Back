package org.example.tunisair.Services;

import org.example.tunisair.Entities.Adherent;
import org.example.tunisair.Entities.Conjoint;
import org.example.tunisair.Repository.AdherentRepository;
import org.example.tunisair.Repository.ConjointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceConjoint implements IServiceConjoint {

    @Autowired
    ConjointRepository ConjointRepository;
    @Autowired
    private ConjointRepository conjointRepository;
    @Autowired
    AdherentRepository adherentRepository;

    @Override
    public Adherent addConjoint(Conjoint conjoint, Long idAdherent) {
        Adherent adherent =adherentRepository.findById(idAdherent).orElse(null);
        if(adherent!=null){
            adherent.setConjoint(conjoint);
            return adherentRepository.save(adherent);

        }
        return null;
    }

    @Override
    public void deleteConjoint(Long idConjoint) {
        conjointRepository.deleteById(idConjoint);
    }

    @Override
    public Conjoint updateConjoint(Conjoint conjoint, Long idConjoint) {
        Conjoint conjoint1= conjointRepository.findById(idConjoint).orElse(null);
        if(conjoint1!=null){
            conjoint.setIdConjoint(conjoint1.getIdConjoint());
        return conjointRepository.save(conjoint);
        }


        return null;
    }


}

