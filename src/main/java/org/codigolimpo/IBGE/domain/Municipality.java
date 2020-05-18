package org.codigolimpo.IBGE.domain;

import lombok.Getter;
import org.codigolimpo.IBGE.domain.DTO.MunicipioDTO;

import java.util.Objects;

@Getter
public class Municipality {

    private Long id;
    private FederalUnit federalUnit;
    private int idIBGE;
    String name;

    public Municipality(FederalUnit federalUnit, MunicipioDTO dto) {
        this.federalUnit = federalUnit;
        this.idIBGE = dto.getId();
        this.name = dto.getNome();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Municipality that = (Municipality) o;
        return getIdIBGE() == that.getIdIBGE() &&
                Objects.equals(getId(), that.getId()) &&
                Objects.equals(getFederalUnit().getIdIBGE(), that.getFederalUnit().getIdIBGE()) &&
                Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFederalUnit().getIdIBGE(), getIdIBGE(), getName());
    }
}
