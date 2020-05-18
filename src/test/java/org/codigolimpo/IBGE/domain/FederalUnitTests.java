package org.codigolimpo.IBGE.domain;

import org.junit.jupiter.api.Test;

import static org.codigolimpo.IBGE.TestConstants.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class FederalUnitTests {

    @Test
    public void whenValidStateDTOCreateDomainObject() {
        FederalUnit otherMinasDomain = FederalUnit.createFromDTO(DTO_MINAS);
        assertThat(MINAS.getId(), is(nullValue()));
        assertThat(MINAS.getIdIBGE(), equalTo(ID_IBGE_MINAS));
        assertThat(MINAS.getAcronym(), equalTo(ACRONYM_MINAS));
        assertThat(MINAS.getName(), equalTo(NAME_MINAS));

        assertThat(MINAS, equalTo(otherMinasDomain));
        assertThat(MINAS, is(not(equalTo(RONDONIA))));
    }

}
