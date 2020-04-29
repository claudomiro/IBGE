package org.codigolimpo.IBGE.domain.DTO;

import lombok.Value;

@Value
public class MunicipioDTO {
    int id;
    String nome;

    public MunicipioDTO(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

}
