package org.codigolimpo.IBGE.domain;

import org.codigolimpo.IBGE.repository.FederalUnitRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.codigolimpo.IBGE.TestConstants.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest
public class FederalUnitIT {

    @Autowired
    FederalUnitRepository repository;

    @AfterEach
    public void cleanUp() {
        repository.deleteAll();
    }

    @Test
    public void whenValidaSaveFederalUnit() {
        FederalUnit test = FederalUnit.createFromDTO(DTO_FEDERAL_UNIT_TEST);
        FederalUnit anotherTest = FederalUnit.createFromDTO(DTO_FEDERAL_UNIT_TEST);

        assertThat(test.getId(), is(nullValue()));
        repository.save(test);
        assertThat(test.getId(), is(not(nullValue())));

        assertThat(test, is(equalTo(anotherTest)));
    }

}
