package org.codigolimpo.IBGE.service;

import org.codigolimpo.IBGE.domain.DTO.MunicipioDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import static org.codigolimpo.IBGE.TestConstants.ABRECAMPO;
import static org.codigolimpo.IBGE.TestConstants.ABRECAMPO_ID_IBGE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class IBGEServiceTests {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private IBGEServiceImpl service;

    @Test
    public void whenGivenCodeReturnMunicipalityDTO() {
        String url = "https://servicodados.ibge.gov.br/api/v1/localidades/municipios/" + ABRECAMPO_ID_IBGE;
        final Class<MunicipioDTO> type = MunicipioDTO.class;
        when(restTemplate.getForObject(url, type)).thenReturn(ABRECAMPO);

        final MunicipioDTO actual = this.service.municipalityData(ABRECAMPO_ID_IBGE);
        assertThat(actual, equalTo(ABRECAMPO));
    }
}
