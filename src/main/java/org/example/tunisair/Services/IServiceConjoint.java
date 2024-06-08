package org.example.tunisair.Services;


import org.example.tunisair.Entities.Adherent;
import org.example.tunisair.Entities.Conjoint;

public interface IServiceConjoint {
    public Adherent addConjoint(Conjoint conjoint, Long idAdherent);

    void deleteConjoint(Long idConjoint);

    Conjoint updateConjoint(Conjoint conjoint, Long idConjoint);
}
