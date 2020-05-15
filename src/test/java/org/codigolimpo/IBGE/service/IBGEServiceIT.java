package org.codigolimpo.IBGE.service;

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
        final EstadoDTO actual = service.stateData(ID_IBGE_MINAS);
        assertThat(actual, equalTo(DTO_MINAS));
    }

    @Test
    public void returnAllStateDTOs() {
        super.assertAllStateDTOs(this.service, 27);
    }

    @Test
    public void whenGivenCorrectIdReturnAllMunicipalitiesInAState()
    {
        final Stream<MunicipioDTO> dtoStream = service.allMunicipalitiesInAState(ID_IBGE_MINAS);

        final List<MunicipioDTO> list = dtoStream.collect(Collectors.toList());

        assertThat(list, is(not(empty())));
        assertThat(list, hasItem(ABRECAMPO));
    }





}