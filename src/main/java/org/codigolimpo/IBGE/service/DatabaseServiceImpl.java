package org.codigolimpo.IBGE.service;

import org.codigolimpo.IBGE.domain.FederalUnit;
import org.codigolimpo.IBGE.domain.Municipality;
import org.codigolimpo.IBGE.repository.FederalUnitRepository;
import org.codigolimpo.IBGE.repository.MunicipalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseServiceImpl implements DatabaseService {

    private MunicipalityRepository municipalityRepository;

    private final FederalUnitRepository federalUnitRepository;

    @Autowired
    public DatabaseServiceImpl(MunicipalityRepository municipalityRepository,
                               FederalUnitRepository federalUnitRepository) {
        this.municipalityRepository = municipalityRepository;
        this.federalUnitRepository = federalUnitRepository;
    }

    public Municipality saveMunicipality(Municipality municipality){
        return municipalityRepository.save(municipality);
    }

    public FederalUnit saveFederalUnit(FederalUnit federalUnit) {
        return this.federalUnitRepository.save(federalUnit);

    }

}
