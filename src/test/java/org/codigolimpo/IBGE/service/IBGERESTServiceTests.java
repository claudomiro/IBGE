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
public class IBGERESTServiceTests {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private IBGERESTServiceImpl service;
    private IBGEURLs ibgeurLs;

    @BeforeEach
    void setUp() {
        ibgeurLs = new IBGEURLs();
    }

    @Test
    public void whenGivenCodeReturnMunicipalityDTO() {
        String url = ibgeurLs.produceRESTURL(MUNICIPALITIES, ID_IBGE_ABRECAMPO);
        final Class<MunicipioDTO> type = MunicipioDTO.class;
        when(restTemplate.getForObject(url, type)).thenReturn(DTO_ABRECAMPO);

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

    protected void assertAllStateDTOs(IBGERESTService service, int numberOfStates) {
        final Stream<EstadoDTO> dtoStream = service.allStates();
        List<EstadoDTO> dtoList = dtoStream.collect(Collectors.toList());
        assertThat(dtoList, hasItems(DTO_MINAS, DTO_RONDONIA, DTO_DF));
        assertThat(dtoList.size(), is(numberOfStates));
    }

    @Test
    public void whenGivenCorrectIdReturnAllMunicipalitiesInAState()
    {
        MunicipioDTO[] expected = new MunicipioDTO[] {DTO_ABADIA, DTO_ABRECAMPO, DTO_WENCESLAU};

        when(restTemplate.getForObject(ibgeurLs.produceRESTURL(STATES, ID_IBGE_MINAS, MUNICIPALITIES),
                MunicipioDTO[].class)).thenReturn(expected);

        assertAllMunicipalitiesInAState(this.service, ID_IBGE_MINAS, 3);
    }

    protected void assertAllMunicipalitiesInAState(IBGERESTService service, int idIBGE, int numberOfMunicipalities) {
        Stream<MunicipioDTO> municipioDTOs = service.allMunicipalitiesInAState(idIBGE);
        List<MunicipioDTO> list = municipioDTOs.collect(Collectors.toList());
        assertThat(list, hasItems(DTO_ABADIA, DTO_ABRECAMPO, DTO_WENCESLAU));
        assertThat(list.size(), is(greaterThanOrEqualTo(numberOfMunicipalities)));
    }

    protected void assertWhenGivenCodeReturnMunicipalityDTO(IBGERESTService service) {
        final MunicipioDTO actual = service.municipalityData(ID_IBGE_ABRECAMPO);
        assertThat(actual, equalTo(DTO_ABRECAMPO));
    }


}
