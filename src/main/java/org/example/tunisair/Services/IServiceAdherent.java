package org.example.tunisair.Services;

import org.example.tunisair.Entities.Adherent;

import java.util.List;

public interface IServiceAdherent {
    public Adherent addAdherent(Adherent adherent,Long idEmploye);

    List<Adherent> getAllAdherent();

    Adherent getAccountDetails(Long idAccount);
}
