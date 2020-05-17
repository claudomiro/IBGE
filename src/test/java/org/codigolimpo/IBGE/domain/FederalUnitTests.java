package org.codigolimpo.IBGE.domain;

import org.junit.jupiter.api.Test;

import static org.codigolimpo.IBGE.TestConstants.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class FederalUnitTests {

    @Test
    public void whenValidStateDTOCreateDomainObject() {
        FederalUnit minasDomain_01 = FederalUnit.createFromDTO(DTO_MINAS);
        FederalUnit minasDomain_02 = FederalUnit.createFromDTO(DTO_MINAS);
        FederalUnit rondoniaDomain = FederalUnit.createFromDTO(DTO_RONDONIA);
        assertThat(minasDomain_01.getId(), is(nullValue()));
        assertThat(minasDomain_01.getIdIBGE(), equalTo(ID_IBGE_MINAS));
        assertThat(minasDomain_01.getAcronym(), equalTo(ACRONYM_MINAS));
        assertThat(minasDomain_01.getName(), equalTo(NAME_MINAS));

        assertThat(minasDomain_01, equalTo(minasDomain_02));
        assertThat(minasDomain_01, is(not(equalTo(rondoniaDomain))));
    }

}
