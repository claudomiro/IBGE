package org.codigolimpo.IBGE.domain.DTO;

import java.util.Objects;

public class MunicipioDTO {
    final private int id;
    final private String nome;

    public MunicipioDTO(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public  String getNome() {
        return nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MunicipioDTO that = (MunicipioDTO) o;
        return getId() == that.getId() &&
                getNome().equals(that.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome());
    }
}
