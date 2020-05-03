package org.codigolimpo.IBGE.service;

import org.codigolimpo.IBGE.domain.DTO.EstadoDTO;
import org.codigolimpo.IBGE.domain.DTO.MunicipioDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.stream.Stream;

@Service
public class IBGEServiceImpl implements IBGEService {

    private static final String SEPARATOR = String.valueOf('/');
    private static final String URL_BASE = "https://servicodados.ibge.gov.br/api/v1/localidades";
    protected static final String STATES = "estados";
    private static final String MUNICIPALITIES = "municipios";

    private final RestTemplate restTemplate;

    public IBGEServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Stream<EstadoDTO> allStates() {
        String url = produceRESTURL(STATES);
        Class<EstadoDTO[]> type = EstadoDTO[].class;
        final EstadoDTO[] dtoArray = restTemplate.getForObject(url, type);
        if (dtoArray == null) {
            throw new RuntimeException("Retrieving all States returned null");
        }
        return Arrays.stream(dtoArray);
    }

    @Override
    public Stream<MunicipioDTO> allMunicipalitiesInAState(int idIBGE) {
        final String uri = produceRESTURL(STATES, idIBGE, MUNICIPALITIES);
        final Class<MunicipioDTO[]> type = MunicipioDTO[].class;
        final MunicipioDTO[] dtoArray = restTemplate.getForObject(uri, type);
        if(dtoArray == null)
        {
            throw new RuntimeException("Retrieving all Municipalities returned null");
        }
        return Arrays.stream(dtoArray);
    }

    @Override
    public MunicipioDTO municipalityData(int idIBGE) {
        final String municipalityURL = produceRESTURL(MUNICIPALITIES, idIBGE);
        final Class<MunicipioDTO> type = MunicipioDTO.class;
        return restTemplate.getForObject(municipalityURL, type);

    }

    @Override
    public EstadoDTO stateData(int idIBGE) {
        String stateURL = produceRESTURL(STATES, idIBGE);
        Class<EstadoDTO> type = EstadoDTO.class;
        return restTemplate.getForObject(stateURL, type);
    }

    private String produceRESTURL(String objectName, int id) {
        return String.join(SEPARATOR, produceRESTURL(objectName), String.valueOf(id));
    }

    private String produceRESTURL(String objectName) {
        return String.join(SEPARATOR, URL_BASE, objectName);
    }

    private String produceRESTURL(String objectNameOutside, int id, String objectNameInside) {
        final String baseURL = produceRESTURL(objectNameOutside, id);
        return String.join(SEPARATOR, baseURL, objectNameInside);
    }



}
