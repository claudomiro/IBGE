package org.codigolimpo.IBGE.service;

import org.codigolimpo.IBGE.domain.DTO.EstadoDTO;
import org.codigolimpo.IBGE.domain.DTO.MunicipioDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.codigolimpo.IBGE.service.IBGEURLs.*;

@Service
public class IBGEServiceImpl implements IBGEService {

    private final RestTemplate restTemplate;
    private final IBGEURLs ibgeurLs;

    public IBGEServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        ibgeurLs = new IBGEURLs();
    }

    @Override
    public Stream<EstadoDTO> allStates() {
        String url = ibgeurLs.produceRESTURL(STATES);
        Class<EstadoDTO[]> type = EstadoDTO[].class;
        final EstadoDTO[] dtoArray = restTemplate.getForObject(url, type);
        if (dtoArray == null) {
            throw new RuntimeException("Retrieving all States returned null");
        }
        return Arrays.stream(dtoArray);
    }

    @Override
    public Stream<MunicipioDTO> allMunicipalitiesInAState(int idIBGE) {
        final String uri = ibgeurLs.produceRESTURL(STATES, idIBGE, MUNICIPALITIES);
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
        final String municipalityURL = ibgeurLs.produceRESTURL(MUNICIPALITIES, idIBGE);
        final Class<MunicipioDTO> type = MunicipioDTO.class;
        return restTemplate.getForObject(municipalityURL, type);

    }

    @Override
    public EstadoDTO stateData(int idIBGE) {
        String stateURL = ibgeurLs.produceRESTURL(STATES, idIBGE);
        Class<EstadoDTO> type = EstadoDTO.class;
        return restTemplate.getForObject(stateURL, type);
    }



}
