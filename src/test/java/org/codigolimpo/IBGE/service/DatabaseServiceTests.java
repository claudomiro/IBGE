package org.codigolimpo.IBGE.service;

import org.codigolimpo.IBGE.domain.FederalUnit;
import org.codigolimpo.IBGE.domain.Municipality;
import org.codigolimpo.IBGE.repository.FederalUnitRepository;
import org.codigolimpo.IBGE.repository.MunicipalityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.codigolimpo.IBGE.TestConstants.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DatabaseServiceTests {

    @Mock
    private MunicipalityRepository municipalityRepository;

    @Mock
    private FederalUnitRepository federalUnitRepository;

    @InjectMocks
    private DatabaseServiceImpl service;

    private FederalUnit testFederalUnit;

    @BeforeEach
    void setUp() {
        testFederalUnit = FederalUnit.createFromDTO(DTO_FEDERAL_UNIT_TEST);
        when(federalUnitRepository.save(any(FederalUnit.class))).then(returnsFirstArg());
    }

    @Test
    public void whenValidFederalUnitEntitySave() {
        service.saveFederalUnit(testFederalUnit);

        verify(federalUnitRepository).save(testFederalUnit);
    }

    @Test
    public void whenValidMunicipalityDTOSaveAndAddObject() {
        when(municipalityRepository.save(any(Municipality.class))).then(returnsFirstArg());

        Municipality testMunicipality = testFederalUnit.createMunicipalityFromDTO(DTO_MUNICIPIO_TEST);
        service.saveFederalUnit(testFederalUnit);
        service.saveMunicipality(testMunicipality);

        verify(municipalityRepository).save(testMunicipality);
        assertThat(testFederalUnit.getMunicipalities(), contains(testMunicipality));
    }

}
