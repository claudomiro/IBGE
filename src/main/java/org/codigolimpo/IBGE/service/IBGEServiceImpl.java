package org.codigolimpo.IBGE.service;

import org.codigolimpo.IBGE.domain.DTO.MunicipioDTO;
import org.springframework.web.client.RestTemplate;

public class IBGEServiceImpl implements IBGEService {

    private final RestTemplate restTemplate;

    public IBGEServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public MunicipioDTO municipalityData(int idIBGE) {
        final String uri = "https://servicodados.ibge.gov.br/api/v1/localidades/municipios/" + idIBGE;

        final Class<MunicipioDTO> clazz = MunicipioDTO.class;
        return restTemplate.getForObject(uri, clazz);

    }
}
