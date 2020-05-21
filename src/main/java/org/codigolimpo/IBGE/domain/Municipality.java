package org.codigolimpo.IBGE.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.codigolimpo.IBGE.domain.DTO.MunicipioDTO;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@ToString
@EqualsAndHashCode
public class Municipality {
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Exclude
    private Long id;

    @ManyToOne
    private FederalUnit federalUnit;

    @NaturalId
    private int idIBGE;
    String name;

    Municipality(FederalUnit federalUnit, MunicipioDTO dto) {
        this.federalUnit = federalUnit;
        this.idIBGE = dto.getId();
        this.name = dto.getNome();
    }

}
