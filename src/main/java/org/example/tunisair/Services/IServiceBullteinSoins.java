
package org.example.tunisair.Services;
import org.example.tunisair.Entities.BullteinSoins;
import org.example.tunisair.Entities.Conjoint;

import java.util.List;

public interface  IServiceBullteinSoins {
    public BullteinSoins addBullteinSoins(BullteinSoins bullteinSoins , Long idAdherent);
    public BullteinSoins updateBullteinSoins(BullteinSoins bullteinSoins , Long idBullteinSoins);
    public List<BullteinSoins> getAllBullteinSoins();

    public List<BullteinSoins> getAllBullteinSoinsByAdherent(Long idAdherent);

    public void deleteBullteinSoins(Long idBullteinSoins);
}
