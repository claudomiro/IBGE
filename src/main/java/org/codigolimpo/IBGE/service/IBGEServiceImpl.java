package org.codigolimpo.IBGE.service;

import org.codigolimpo.IBGE.domain.DTO.EstadoDTO;
import org.codigolimpo.IBGE.domain.DTO.MunicipioDTO;
import org.springframework.web.client.RestTemplate;

public class IBGEServiceImpl implements IBGEService {

    private static final char SLASH = '/';
    private static final String URL_BASE = "https://servicodados.ibge.gov.br/api/v1/localidades";
    private static final String MUNICIPALITIES = "municipios";
    protected static final String STATES = "estados";

    private final RestTemplate restTemplate;

    public IBGEServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public MunicipioDTO municipalityData(int idIBGE) {
        final String municipalityURL = produceRESTURL(MUNICIPALITIES, idIBGE);
        final Class<MunicipioDTO> clazz = MunicipioDTO.class;
        return restTemplate.getForObject(municipalityURL, clazz);

    }

    @Override
    public EstadoDTO stateData(int idIBGE) {
        String stateURL = produceRESTURL(STATES, idIBGE);
        Class<EstadoDTO> clazz = EstadoDTO.class;
        return restTemplate.getForObject(stateURL, clazz);
    }

    private String produceRESTURL(String objectName, int id) {
        return URL_BASE + SLASH + objectName + SLASH + +id;
    }


}
