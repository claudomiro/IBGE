package org.codigolimpo.IBGE.service;

import org.codigolimpo.IBGE.domain.DTO.EstadoDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.codigolimpo.IBGE.TestConstants.*;

@SpringBootTest
public class IBGERESTServiceIT extends IBGERESTServiceTests {

    private IBGERESTService service;

    @Autowired
    private RestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        service = new IBGERESTServiceImpl(restTemplate);
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
        super.assertAllMunicipalitiesInAState(this.service, ID_IBGE_MINAS, 770);
    }





}