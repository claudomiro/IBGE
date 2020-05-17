package org.codigolimpo.IBGE.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.codigolimpo.IBGE.domain.DTO.EstadoDTO;

@Getter
@EqualsAndHashCode
public class FederalUnit {
    private Long id;
    private int idIBGE;
    private String acronym;
    private String name;

    public static FederalUnit createFromDTO(EstadoDTO dto) {
        return new FederalUnit(dto.getId(), dto.getSigla(), dto.getNome());
    }

    private FederalUnit( int idIBGE, String acronym, String name) {
        this.idIBGE = idIBGE;
        this.acronym = acronym;
        this.name = name;
    }
}
