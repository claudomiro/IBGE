package org.codigolimpo.IBGE.service;

import org.codigolimpo.IBGE.domain.DTO.EstadoDTO;
import org.codigolimpo.IBGE.domain.DTO.MunicipioDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class IBGEServiceIT {
    protected static final int ABRECAMPO_ID_IBGE = 3100302;

    protected static final int MINAS_ID_IBGE = 31;
    protected static final String ABRE_CAMPO_NAME = "Abre Campo";
    protected static final MunicipioDTO ABRECAMPO = new MunicipioDTO(ABRECAMPO_ID_IBGE, ABRE_CAMPO_NAME);

    protected static final String MINAS_ACRONYM = "MG";
    protected static final String MINAS_NAME = "Minas Gerais";
    protected static final EstadoDTO MINAS = new EstadoDTO(MINAS_ID_IBGE, MINAS_ACRONYM, MINAS_NAME);
    private IBGEService service;

    @BeforeEach
    void setUp() {
        service = new IBGEServiceImpl(new RestTemplate());
    }

    @Test
    public void whenGivenCodeReturnMunicipalityDTO() {
        final MunicipioDTO actual = service.municipalityData(ABRECAMPO_ID_IBGE);
        assertThat(actual, equalTo(ABRECAMPO));
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

}