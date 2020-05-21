package org.codigolimpo.IBGE.domain;

import org.codigolimpo.IBGE.domain.DTO.EstadoDTO;
import org.codigolimpo.IBGE.repository.FederalUnitRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@SpringBootTest
public class FederalUnitIT {

    @Autowired
    FederalUnitRepository repository;

    @Test
    public void whenValidaSaveFederalUnit() {
        EstadoDTO testDTO = new EstadoDTO(9999, "FT", "Federal Unit of Test");
        FederalUnit teste = FederalUnit.createFromDTO(testDTO);
        FederalUnit anotherTest = FederalUnit.createFromDTO(testDTO);

        assertThat(teste.getId(), is(nullValue()));
        repository.save(teste);
        assertThat(teste.getId(), is(not(nullValue())));

        assertThat(teste, is(equalTo(anotherTest)));
    }
}
