package org.codigolimpo.IBGE;

import org.codigolimpo.IBGE.domain.DTO.EstadoDTO;
import org.codigolimpo.IBGE.domain.DTO.MunicipioDTO;

public interface TestConstants {

    int ID_IBGE_ABRECAMPO = 3100302;
    int ID_IBGE_MINAS = 31;
    int ID_IBGE_RONDONIA = 11;
    int ID_IBGE_DF = 53;
    String NAME_ABRECAMPO = "Abre Campo";
    MunicipioDTO ABRECAMPO = new MunicipioDTO(ID_IBGE_ABRECAMPO, NAME_ABRECAMPO);

    String ACRONYM_RONDONIA = "RO";
    String ACRONYM_MINAS = "MG";
    String ACRONYM_DF = "DF";

    String NAME_RONDONIA = "Rondônia";
    String NAME_MINAS = "Minas Gerais";
    String NAME_DF = "Distrito Federal";

    EstadoDTO DTO_MINAS = new EstadoDTO(ID_IBGE_MINAS, ACRONYM_MINAS, NAME_MINAS);
    EstadoDTO DTO_RONDONIA = new EstadoDTO(ID_IBGE_RONDONIA, ACRONYM_RONDONIA, NAME_RONDONIA);
    EstadoDTO DTO_DF = new EstadoDTO(ID_IBGE_DF, ACRONYM_DF, NAME_DF);
}
