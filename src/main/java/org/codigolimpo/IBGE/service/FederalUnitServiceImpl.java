package org.codigolimpo.IBGE.service;

import org.codigolimpo.IBGE.domain.FederalUnit;
import org.codigolimpo.IBGE.repository.FederalUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FederalUnitServiceImpl implements FederalUnitService{

    private final FederalUnitRepository repository;

    @Autowired
    public FederalUnitServiceImpl(FederalUnitRepository repository) {
        this.repository = repository;
    }

    public FederalUnit saveFederalUnit(FederalUnit federalUnit) {
        return this.repository.save(federalUnit);

    }
}
