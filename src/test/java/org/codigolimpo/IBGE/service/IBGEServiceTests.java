package org.codigolimpo.IBGE.service;

import org.codigolimpo.IBGE.domain.DTO.EstadoDTO;
import org.codigolimpo.IBGE.domain.DTO.MunicipioDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.codigolimpo.IBGE.TestConstants.*;
import static org.codigolimpo.IBGE.service.IBGEURLs.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class IBGEServiceTests {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private IBGEServiceImpl service;
    private IBGEURLs ibgeurLs;

    @BeforeEach
    void setUp() {
        ibgeurLs = new IBGEURLs();
    }

    @Test
    public void whenGivenCodeReturnMunicipalityDTO() {
        String url = ibgeurLs.produceRESTURL(MUNICIPALITIES, ABRECAMPO_ID_IBGE);
        final Class<MunicipioDTO> type = MunicipioDTO.class;
        when(restTemplate.getForObject(url, type)).thenReturn(ABRECAMPO);

        assertWhenGivenCodeReturnMunicipalityDTO(this.service);
    }

    @Test
    public void whenGivenCodeReturnStateDTO() {

    }

    @Test
    public void returnAllStateDTOs() {

    }

    @Test
    public void whenGivenCorrectIdReturnAllMunicipalitiesInAState()
    {

    }

    protected void assertWhenGivenCodeReturnMunicipalityDTO(IBGEService service) {
        final MunicipioDTO actual = service.municipalityData(ABRECAMPO_ID_IBGE);
        assertThat(actual, equalTo(ABRECAMPO));
    }


}
