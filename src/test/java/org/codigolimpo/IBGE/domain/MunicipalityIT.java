package org.codigolimpo.IBGE.domain;

import org.codigolimpo.IBGE.domain.DTO.MunicipioDTO;
import org.codigolimpo.IBGE.domain.FederalUnit;
import org.codigolimpo.IBGE.repository.FederalUnitRepository;
import org.codigolimpo.IBGE.repository.MunicipalityRepository;
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

    @Test
    public void whenValidaSaveMunicipality() {
        FederalUnit testFU = FederalUnit.createFromDTO(DTO_TEST);
        federalUnitRepository.save(testFU);

        MunicipioDTO dtoTest = new MunicipioDTO(999999, "Municipality of  Test");
        Municipality municipalityTest = testFU.createMunicipalityFromDTO(dtoTest);
        assertThat(municipalityTest.getId(), is(nullValue()));
        municipalityRepository.save(municipalityTest);
        assertThat(municipalityTest.getId(), is(not(nullValue())));

        Municipality anotherTest = testFU.createMunicipalityFromDTO(dtoTest);
        assertThat(municipalityTest, equalTo(anotherTest));
    }
}
