package org.codigolimpo.IBGE.domain;

import org.codigolimpo.IBGE.TestConstants;
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
        FederalUnit teste = FederalUnit.createFromDTO(DTO_TEST);
        FederalUnit anotherTest = FederalUnit.createFromDTO(DTO_TEST);

        assertThat(teste.getId(), is(nullValue()));
        repository.save(teste);
        assertThat(teste.getId(), is(not(nullValue())));

        assertThat(teste, is(equalTo(anotherTest)));
    }
}
