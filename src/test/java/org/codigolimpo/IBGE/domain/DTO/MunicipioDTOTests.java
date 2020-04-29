package org.codigolimpo.IBGE.domain.DTO;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class MunicipioDTOTests {

    @Test
    public void whenGivenIDAndNameCreateDTO()
    {
        MunicipioDTO abreCampo = new MunicipioDTO(3100302, "Abre Campo");
        MunicipioDTO another = new MunicipioDTO(3100302, "Abre Campo");
        final MunicipioDTO aguanil = new MunicipioDTO(3100807, "Aguanil");

        assertThat(3100302, equalTo(abreCampo.getId()));
        assertThat("Abre Campo", equalTo(abreCampo.getNome()));

        assertThat(abreCampo, equalTo(another));
        assertThat(aguanil, not(equalTo(abreCampo)));
    }
}
