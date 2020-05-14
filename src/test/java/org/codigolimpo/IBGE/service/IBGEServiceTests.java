package org.codigolimpo.IBGE.service;

import org.codigolimpo.IBGE.domain.DTO.MunicipioDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import static org.codigolimpo.IBGE.TestConstants.*;
import static org.codigolimpo.IBGE.service.IBGEURLs.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class IBGEServiceTests extends IBGEServiceIT{

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private IBGEServiceImpl service;
    private IBGEURLs ibgeurLs;

    @BeforeEach
    void setUp() {
        ibgeurLs = new IBGEURLs();
    }

    @Test
    public void whenGivenCodeReturnMunicipalityDTO() {
        String url = ibgeurLs.produceRESTURL(MUNICIPALITIES, ABRECAMPO_ID_IBGE);
        final Class<MunicipioDTO> type = MunicipioDTO.class;
        when(restTemplate.getForObject(url, type)).thenReturn(ABRECAMPO);

        super.assertWhenGivenCodeReturnMunicipalityDTO(this.service);
    }
}
