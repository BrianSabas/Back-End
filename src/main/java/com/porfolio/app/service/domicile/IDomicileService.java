
package com.porfolio.app.service.domicile;

import com.porfolio.app.model.Domicile;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IDomicileService {
    public List<Domicile> getDomicile();
    public void addDomicile(Domicile domicile);
    public void editDomicile(Domicile domicile);
    public void deleteDomicile(Long id);
    
}
