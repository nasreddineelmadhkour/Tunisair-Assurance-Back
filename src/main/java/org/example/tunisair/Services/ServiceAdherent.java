package org.example.tunisair.Services;

import org.example.tunisair.Entities.Account;
import org.example.tunisair.Entities.Adherent;
import org.example.tunisair.Repository.AccountRepository;
import org.example.tunisair.Repository.AdherentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceAdherent implements IServiceAdherent {

    @Autowired
    AdherentRepository adherentRepository;
    @Autowired
    AccountRepository accountRepository;

    @Override
    public Adherent addAdherent(Adherent adherent,Long idEmploye) {

        Account employe = accountRepository.findById(idEmploye).orElse(null);
        System.out.println("hello");
        if(employe!= null){
            System.out.println(employe.getEmail());
            adherent.setEmploye(employe);
        }
        return adherentRepository.save(adherent);
    }

    @Override
    public List<Adherent> getAllAdherent() {
        return adherentRepository.findAll();
    }

    @Override
    public Adherent getAccountDetails(Long idAccount) {
        return adherentRepository.findById(idAccount).orElse(null);
    }


}
