package org.codigolimpo.IBGE.domain;

import org.codigolimpo.IBGE.repository.FederalUnitRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.codigolimpo.IBGE.TestConstants.*;

@SpringBootTest
public class FederalUnitIT {

    @Autowired
    FederalUnitRepository repository;

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
