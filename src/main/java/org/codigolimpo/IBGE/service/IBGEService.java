package org.codigolimpo.IBGE.service;

import org.codigolimpo.IBGE.domain.DTO.EstadoDTO;
import org.codigolimpo.IBGE.domain.DTO.MunicipioDTO;

public interface IBGEService {

    MunicipioDTO municipalityData(int idIBGE);

    EstadoDTO stateData(int idIBGE);

}
