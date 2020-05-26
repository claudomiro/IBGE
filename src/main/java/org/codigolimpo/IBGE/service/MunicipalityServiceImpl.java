package org.codigolimpo.IBGE.service;

import org.codigolimpo.IBGE.domain.Municipality;
import org.codigolimpo.IBGE.repository.MunicipalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MunicipalityServiceImpl implements MunicipalityService {

    private MunicipalityRepository repository;

    @Autowired
    public MunicipalityServiceImpl(MunicipalityRepository repository) {
        this.repository = repository;
    }

    public Municipality saveMunicipality(Municipality municipality){
        return repository.save(municipality);
    }
}
