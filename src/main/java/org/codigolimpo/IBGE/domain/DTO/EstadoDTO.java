package org.codigolimpo.IBGE.domain.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@JsonIgnoreProperties(ignoreUnknown = true)
@Value
public class EstadoDTO {
    int id;
    String sigla;
    String nome;

    public EstadoDTO(@JsonProperty("id") int id,
                     @JsonProperty("sigla") String sigla,
                     @JsonProperty("nome") String nome)
    {
        this.id = id;
        this.sigla = sigla;
        this.nome = nome;
    }
}
