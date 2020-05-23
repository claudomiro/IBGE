package org.codigolimpo.IBGE.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.codigolimpo.IBGE.domain.DTO.EstadoDTO;
import org.codigolimpo.IBGE.domain.DTO.MunicipioDTO;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@EqualsAndHashCode
public class FederalUnit {
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Exclude
    private Long id;

    @NaturalId
    private int idIBGE;
    private String acronym;
    private String name;

    @OneToMany(mappedBy = "federalUnit")
    @EqualsAndHashCode.Exclude
    private Set<Municipality> municipalities = new HashSet<>();

    public static FederalUnit createFromDTO(EstadoDTO dto) {
        return new FederalUnit(dto.getId(), dto.getSigla(), dto.getNome());
    }

    private FederalUnit() {
    }

    private FederalUnit(int idIBGE, String acronym, String name) {
        this.idIBGE = idIBGE;
        this.acronym = acronym;
        this.name = name;
    }

    Municipality createMunicipalityFromDTO(MunicipioDTO dto) {
        Municipality municipality = new Municipality(this, dto);
        getMunicipalities().add(municipality);
        return municipality;
    }

}
