package org.codigolimpo.IBGE.domain.DTO;

import lombok.Value;

@Value
public class EstadoDTO {
    int id;
    String sigla;
    String nome;

    public EstadoDTO(int id, String sigla, String nome)
    {
        this.id = id;
        this.sigla = sigla;
        this.nome = nome;
    }
}
