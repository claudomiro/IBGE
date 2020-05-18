package org.codigolimpo.IBGE.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.codigolimpo.IBGE.domain.DTO.EstadoDTO;
import org.codigolimpo.IBGE.domain.DTO.MunicipioDTO;

import java.util.ArrayList;
import java.util.List;

@Getter
@EqualsAndHashCode
public class FederalUnit {
    private Long id;
    private int idIBGE;
    private String acronym;
    private String name;
    private List<Municipality> municipios;

    public static FederalUnit createFromDTO(EstadoDTO dto) {
        return new FederalUnit(dto.getId(), dto.getSigla(), dto.getNome());
    }

    private FederalUnit( int idIBGE, String acronym, String name) {
        this.idIBGE = idIBGE;
        this.acronym = acronym;
        this.name = name;
        this.municipios = new ArrayList<>();
    }

    Municipality createMunicipalityFromDTO(MunicipioDTO dto) {
        Municipality municipality = new Municipality(this, dto);
        this.municipios.add(municipality);
        return municipality;
    }
}
