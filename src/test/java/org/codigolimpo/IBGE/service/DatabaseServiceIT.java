package org.codigolimpo.IBGE.service;

import org.codigolimpo.IBGE.domain.FederalUnit;
import org.codigolimpo.IBGE.domain.Municipality;
import org.codigolimpo.IBGE.repository.FederalUnitRepository;
import org.codigolimpo.IBGE.repository.MunicipalityRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.codigolimpo.IBGE.TestConstants.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest
public class DatabaseServiceIT {

    @Autowired
    private FederalUnitRepository federalUnitRepository;

    @Autowired
    private MunicipalityRepository municipalityRepository;

    @Autowired
    private DatabaseService service;

    @AfterEach
    public void cleanUp() {
        municipalityRepository.deleteAll();
        federalUnitRepository.deleteAll();
    }

    @Test
    public void whenValidMunicipalityDTOSaveAndAddObject() {
        FederalUnit testFU = FederalUnit.createFromDTO(DTO_FEDERAL_UNIT_TEST);
        service.saveFederalUnit(testFU);
        Municipality dto = testFU.createMunicipalityFromDTO(DTO_MUNICIPIO_TEST);
        service.saveMunicipality(dto);

        assertThat(dto.getId(), is(not(nullValue())));
        assertThat(testFU.getMunicipalities(), contains(dto));
    }

    @Test
    public void whenValidFederalUnitEntitySave() {
        FederalUnit test = FederalUnit.createFromDTO(DTO_FEDERAL_UNIT_TEST);
        assertThat(test.getId(), is(nullValue()));
        FederalUnit saved = service.saveFederalUnit(test);
        assertThat(test, is(sameInstance(saved)));
        assertThat(test.getId(), is(not(nullValue())));
    }


}
