package org.codigolimpo.IBGE.service;

import org.codigolimpo.IBGE.domain.DTO.MunicipioDTO;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class IBGEServiceIT {

    @Test
    public void whenGivenCodeReturnMunicipalityDTO()
    {
        final RestTemplate restTemplate = new RestTemplate();
        IBGEService service = new IBGEServiceImpl(restTemplate);
        final MunicipioDTO dto = service.municipalityData(3100302);

        assertThat(dto, equalTo(new MunicipioDTO(3100302, "Abre Campo")));

    }

}
