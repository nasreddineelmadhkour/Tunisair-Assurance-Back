package org.example.tunisair.Services;
import org.example.tunisair.Entities.Adherent;
import org.example.tunisair.Entities.Enfants;

public interface IServiceEnfants {


        public Adherent addEnfants(Enfants enfants, Long idAdherent);

    void deleteEnfant(Long idEnfant);

    Enfants updateEnfant(Enfants enfants, Long idEnfant);
}

