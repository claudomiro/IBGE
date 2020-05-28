package org.codigolimpo.IBGE.service;

import org.codigolimpo.IBGE.domain.FederalUnit;
import org.codigolimpo.IBGE.domain.Municipality;
import org.codigolimpo.IBGE.repository.FederalUnitRepository;
import org.codigolimpo.IBGE.repository.MunicipalityRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.codigolimpo.IBGE.TestConstants.DTO_FEDERAL_UNIT_TEST;
import static org.codigolimpo.IBGE.TestConstants.DTO_MUNICIPIO_TEST;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.nullValue;
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

    @Test
    public void whenValidFederalUnitEntitySave() {
        when(federalUnitRepository.save(any(FederalUnit.class))).then(returnsFirstArg());
        FederalUnit testFederalUnit = FederalUnit.createFromDTO(DTO_FEDERAL_UNIT_TEST);

        FederalUnit saved = service.saveFederalUnit(testFederalUnit);

        verify(federalUnitRepository).save(testFederalUnit);
    }

    @Test
    public void whenValidMunicipalityDTOSaveAndAddObject() {
        when(federalUnitRepository.save(any(FederalUnit.class))).then(returnsFirstArg());
        when(municipalityRepository.save(any(Municipality.class))).then(returnsFirstArg());
        FederalUnit testFU = FederalUnit.createFromDTO(DTO_FEDERAL_UNIT_TEST);
        service.saveFederalUnit(testFU);
        Municipality dto = testFU.createMunicipalityFromDTO(DTO_MUNICIPIO_TEST);
        service.saveMunicipality(dto);
        verify(municipalityRepository).save(dto);

        assertThat(testFU.getMunicipalities(), contains(dto));
    }

}
