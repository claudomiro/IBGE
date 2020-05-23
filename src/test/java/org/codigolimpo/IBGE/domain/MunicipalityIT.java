package org.codigolimpo.IBGE.domain;

import org.codigolimpo.IBGE.repository.FederalUnitRepository;
import org.codigolimpo.IBGE.repository.MunicipalityRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.codigolimpo.IBGE.TestConstants.*;

@SpringBootTest
public class MunicipalityIT {

    @Autowired
    MunicipalityRepository municipalityRepository;

    @Autowired
    FederalUnitRepository federalUnitRepository;

    @AfterEach
    public void cleanUp()
    {
        municipalityRepository.deleteAll();
        federalUnitRepository.deleteAll();
    }

    @Test
    public void whenValidaSaveMunicipality() {
        FederalUnit testFU = FederalUnit.createFromDTO(DTO_FEDERAL_UNIT_TEST);
        federalUnitRepository.save(testFU);

        Municipality municipalityTest = testFU.createMunicipalityFromDTO(DTO_MUNICIPIO_TEST);
        assertThat(municipalityTest.getId(), is(nullValue()));
        municipalityRepository.save(municipalityTest);
        assertThat(municipalityTest.getId(), is(not(nullValue())));

        Municipality anotherTest = testFU.createMunicipalityFromDTO(DTO_MUNICIPIO_TEST);
        assertThat(municipalityTest, equalTo(anotherTest));
    }
}
