package org.codigolimpo.IBGE.domain.DTO;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class EstadoDTOTests {

    @Test
    public void whenGivenIDSiglaAndNameCreateDTO()
    {
        final EstadoDTO mg = new EstadoDTO(31, "MG", "Minas Gerais");
        final EstadoDTO another = new EstadoDTO(31, "MG", "Minas Gerais");
        final EstadoDTO rj = new EstadoDTO(33, "RJ", "Rio de Janeiro");

        assertThat(31, equalTo(mg.getId()));
        assertThat("MG", equalTo(mg.getSigla()));
        assertThat("Minas Gerais", equalTo(mg.getNome()));

        assertThat(mg, equalTo(another));
        assertThat(mg, not(equalTo(rj)));
    }
}
