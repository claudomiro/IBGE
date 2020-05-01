package org.codigolimpo.IBGE.service;

import org.codigolimpo.IBGE.domain.DTO.EstadoDTO;
import org.codigolimpo.IBGE.domain.DTO.MunicipioDTO;

import java.util.stream.Stream;

public interface IBGEService {

    Stream<EstadoDTO> allStates();

    MunicipioDTO municipalityData(int idIBGE);

    EstadoDTO stateData(int idIBGE);

    Stream<MunicipioDTO> allMunicipalitiesInAState(int idIBGE);
}
