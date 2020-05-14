package org.codigolimpo.IBGE.service;

import org.codigolimpo.IBGE.TestConstants;
import org.codigolimpo.IBGE.domain.DTO.EstadoDTO;
import org.codigolimpo.IBGE.domain.DTO.MunicipioDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.codigolimpo.IBGE.TestConstants.*;

@SpringBootTest
public class IBGEServiceIT extends IBGEServiceTests {

    private IBGEService service;

    @Autowired
    private RestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        service = new IBGEServiceImpl(restTemplate);
    }

    @Test
    public void whenGivenCodeReturnMunicipalityDTO() {
        assertWhenGivenCodeReturnMunicipalityDTO(this.service);
    }

    @Test
    public void whenGivenCodeReturnStateDTO() {
        final EstadoDTO actual = service.stateData(MINAS_ID_IBGE);
        assertThat(actual, equalTo(MINAS));
    }

    @Test
    public void returnAllStateDTOs() {
        final Stream<EstadoDTO> dtoStream = service.allStates();
        List<EstadoDTO> dtoList = dtoStream.collect(Collectors.toList());
        assertThat(dtoList, is(not(empty())));
        assertThat(dtoList, hasItem(MINAS));
    }

    @Test
    public void whenGivenCorrectIdReturnAllMunicipalitiesInAState()
    {
        final Stream<MunicipioDTO> dtoStream = service.allMunicipalitiesInAState(MINAS_ID_IBGE);

        final List<MunicipioDTO> list = dtoStream.collect(Collectors.toList());

        assertThat(list, is(not(empty())));
        assertThat(list, hasItem(ABRECAMPO));
    }





}