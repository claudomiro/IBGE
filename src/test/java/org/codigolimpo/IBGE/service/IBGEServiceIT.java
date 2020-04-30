package org.codigolimpo.IBGE.service;

import org.codigolimpo.IBGE.domain.DTO.MunicipioDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class IBGEServiceIT {
    private IBGEService service;

    @BeforeEach
    void setUp() {
        service = new IBGEServiceImpl(new RestTemplate());
    }

    @Test
    public void whenGivenCodeReturnMunicipalityDTO()
    {
        final MunicipioDTO actual = service.municipalityData(3100302);
        MunicipioDTO expected = new MunicipioDTO(3100302, "Abre Campo");
        assertThat(actual, equalTo(expected));
    }
}
