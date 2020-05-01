package org.codigolimpo.IBGE.service;

import org.codigolimpo.IBGE.domain.DTO.EstadoDTO;
import org.codigolimpo.IBGE.domain.DTO.MunicipioDTO;
import org.springframework.web.client.RestTemplate;

public class IBGEServiceImpl implements IBGEService {

    private static final char SLASH = '/';
    private static final String MUNICIPALITIES = "municipios";
    private static final String URL_BASE = "https://servicodados.ibge.gov.br/api/v1/localidades";

    private final RestTemplate restTemplate;

    public IBGEServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public MunicipioDTO municipalityData(int idIBGE) {
        final String uriMunicipality = produceURLMunipality(idIBGE);
        final Class<MunicipioDTO> clazz = MunicipioDTO.class;
        return restTemplate.getForObject(uriMunicipality, clazz);

    }

    @Override
    public EstadoDTO stateData(int idIBGE) {
        return restTemplate.getForObject("https://servicodados.ibge.gov.br/api/v1/localidades/estados/" +
                + idIBGE, EstadoDTO.class);
    }

    private String produceURLMunipality(int idIBGE) {
        return URL_BASE + SLASH + MUNICIPALITIES + SLASH + idIBGE;
    }
}
