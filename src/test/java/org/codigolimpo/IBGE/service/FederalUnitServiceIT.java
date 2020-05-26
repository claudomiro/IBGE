package org.codigolimpo.IBGE.service;

import org.codigolimpo.IBGE.domain.FederalUnit;
import org.codigolimpo.IBGE.repository.FederalUnitRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.codigolimpo.IBGE.TestConstants.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;



@SpringBootTest
public class FederalUnitServiceIT {

    @Autowired
    FederalUnitService service ;

    @Autowired
    FederalUnitRepository repository;

    @AfterEach
    public void cleanUp() {
        repository.deleteAll();
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
