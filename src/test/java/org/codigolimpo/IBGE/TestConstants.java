package org.codigolimpo.IBGE;

import org.codigolimpo.IBGE.domain.DTO.EstadoDTO;
import org.codigolimpo.IBGE.domain.DTO.MunicipioDTO;

public interface TestConstants {

    int ABRECAMPO_ID_IBGE = 3100302;
    int MINAS_ID_IBGE = 31;
    String ABRE_CAMPO_NAME = "Abre Campo";
    MunicipioDTO ABRECAMPO = new MunicipioDTO(ABRECAMPO_ID_IBGE, ABRE_CAMPO_NAME);

    String MINAS_ACRONYM = "MG";
    String MINAS_NAME = "Minas Gerais";
    EstadoDTO MINAS = new EstadoDTO(MINAS_ID_IBGE, MINAS_ACRONYM, MINAS_NAME);
}
