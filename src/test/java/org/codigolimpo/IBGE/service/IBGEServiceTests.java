package org.codigolimpo.IBGE.service;

import org.codigolimpo.IBGE.domain.DTO.EstadoDTO;
import org.codigolimpo.IBGE.domain.DTO.MunicipioDTO;
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
        String url = ibgeurLs.produceRESTURL(MUNICIPALITIES, ID_IBGE_ABRECAMPO);
        final Class<MunicipioDTO> type = MunicipioDTO.class;
        when(restTemplate.getForObject(url, type)).thenReturn(ABRECAMPO);

        assertWhenGivenCodeReturnMunicipalityDTO(this.service);
    }

    @Test
    public void whenGivenCodeReturnStateDTO() {

    }

    @Test
    public void returnAllStateDTOs() {
        EstadoDTO[] arrayExpected = {DTO_MINAS, DTO_RONDONIA, DTO_DF};
        when(restTemplate.getForObject(ibgeurLs.produceRESTURL(STATES),
                EstadoDTO[].class))
                .thenReturn(arrayExpected);


        assertAllStateDTOs(this.service, 3);
    }

    protected void assertAllStateDTOs(IBGEService service, int numberOfStates) {
        final Stream<EstadoDTO> dtoStream = service.allStates();
        List<EstadoDTO> dtoList = dtoStream.collect(Collectors.toList());
        assertThat(dtoList, hasItems(DTO_MINAS, DTO_RONDONIA, DTO_DF));
        assertThat(dtoList.size(), is(numberOfStates));
    }

    @Test
    public void whenGivenCorrectIdReturnAllMunicipalitiesInAState()
    {
        MunicipioDTO dto_abadia = new MunicipioDTO(3100104, "Abadia dos Dourados");
        MunicipioDTO dto_wenceslau = new MunicipioDTO(3172202, "Wenceslau Braz");
        MunicipioDTO[] expected = new MunicipioDTO[] {dto_abadia, ABRECAMPO, dto_wenceslau};

        when(restTemplate.getForObject(ibgeurLs.produceRESTURL(STATES, ID_IBGE_MINAS, MUNICIPALITIES),
                MunicipioDTO[].class)).thenReturn(expected);

        Stream<MunicipioDTO> municipioDTOs = this.service.allMunicipalitiesInAState(ID_IBGE_MINAS);
        List<MunicipioDTO> list = municipioDTOs.collect(Collectors.toList());
        assertThat(list, hasItems(dto_abadia, ABRECAMPO, dto_wenceslau));
        assertThat(list.size(), is(greaterThanOrEqualTo(3)));
    }

    protected void assertWhenGivenCodeReturnMunicipalityDTO(IBGEService service) {
        final MunicipioDTO actual = service.municipalityData(ID_IBGE_ABRECAMPO);
        assertThat(actual, equalTo(ABRECAMPO));
    }


}
