package org.codigolimpo.IBGE.service;

import org.codigolimpo.IBGE.domain.FederalUnit;
import org.codigolimpo.IBGE.domain.Municipality;

public interface DatabaseService {

    FederalUnit saveFederalUnit(FederalUnit federalUnit);
    
    Municipality saveMunicipality(Municipality municipality);
}
