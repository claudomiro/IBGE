package org.codigolimpo.IBGE.domain.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@JsonIgnoreProperties(ignoreUnknown = true)
@Value
public class MunicipioDTO {
    int id;
    String nome;

    public MunicipioDTO(@JsonProperty("id") int id, @JsonProperty("nome") String nome) {
        this.id = id;
        this.nome = nome;
    }

}
