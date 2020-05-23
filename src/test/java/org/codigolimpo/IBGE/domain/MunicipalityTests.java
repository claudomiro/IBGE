package org.codigolimpo.IBGE.domain;

import org.junit.jupiter.api.Test;

import static org.codigolimpo.IBGE.TestConstants.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MunicipalityTests {

    @Test
    public void whenValidDTOsCreateMunicipality() {
        Municipality abreCampo = MINAS.createMunicipalityFromDTO(DTO_ABRECAMPO);
        Municipality anotherAbreCampo = MINAS.createMunicipalityFromDTO(DTO_ABRECAMPO);
        Municipality abadia = MINAS.createMunicipalityFromDTO(DTO_ABADIA);
        assertThat(abreCampo.getId(), is(nullValue()));
        assertThat(abreCampo.getFederalUnit(), equalTo(MINAS));
        assertThat(abreCampo.getIdIBGE(), equalTo(ID_IBGE_ABRECAMPO));
        assertThat(abreCampo.getName(), equalTo(NAME_ABRECAMPO));
        assertThat(abreCampo, equalTo(anotherAbreCampo));
        assertThat(abreCampo, is(not(equalTo(abadia))));
        assertThat(MINAS.getMunicipalities(), contains(abreCampo, abadia));
    }
}
