package org.example.tunisair.Services;
import org.example.tunisair.Entities.Adherent;
import org.example.tunisair.Entities.BullteinSoins;
import org.example.tunisair.Repository.AdherentRepository;
import org.example.tunisair.Repository.BullteinSoinsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceBullteinSoins implements IServiceBullteinSoins {
    @Autowired
    BullteinSoinsRepository bullteinSoinsRepository;
    @Autowired
    AdherentRepository adherentRepository;
    @Override
    public BullteinSoins addBullteinSoins(BullteinSoins bullteinSoins , Long idAdherent) {
        Adherent adherent = adherentRepository.findById(idAdherent).orElse(null);
        if(adherent!=null){
            bullteinSoins.setAdherent(adherent);
            return bullteinSoinsRepository.save(bullteinSoins);

        }
        return  null;
    }

    @Override
    public BullteinSoins updateBullteinSoins(BullteinSoins bullteinSoins, Long idBullteinSoins) {
        bullteinSoins.setIdBullteinSoins(idBullteinSoins);
        return bullteinSoinsRepository.save(bullteinSoins);
    }

    @Override
    public List<BullteinSoins> getAllBullteinSoins() {
        return bullteinSoinsRepository.findAll();
    }

    @Override
    public List<BullteinSoins> getAllBullteinSoinsByAdherent(Long idAdherent) {
        return bullteinSoinsRepository.findAll().stream().filter(bullteinSoins -> bullteinSoins.getAdherent().getIdAdherent()==idAdherent).toList();
    }

    @Override
    public void deleteBullteinSoins(Long idBullteinSoins) {
        bullteinSoinsRepository.deleteById(idBullteinSoins);
    }
}

