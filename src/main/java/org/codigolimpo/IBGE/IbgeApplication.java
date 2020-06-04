package org.codigolimpo.IBGE;

import org.codigolimpo.IBGE.domain.DTO.MunicipioDTO;
import org.codigolimpo.IBGE.domain.FederalUnit;
import org.codigolimpo.IBGE.domain.Municipality;
import org.codigolimpo.IBGE.service.DatabaseService;
import org.codigolimpo.IBGE.service.IBGERESTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class IbgeApplication {

    @Autowired
    IBGERESTService ibgeRESTtService;

    @Autowired
    DatabaseService databaseService;

    public static void main(String[] args) {
        SpringApplication.run(IbgeApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx)  {
        return (args -> run(args));

    }

    private void run(String[] args) {
        if(args.length ==1 && "REFRESH".equalsIgnoreCase(args[0])) {
            System.out.println("'REFRESH' commanded. contructing local database.");
            ibgeRESTtService.allStates()
                    .map(dto -> FederalUnit.createFromDTO(dto))
                    .forEach(this::saveFederalUnit );
        } else {
            System.out.println("Pass 'REFRESH' as argument to populate local database");
        }
    }

    private void saveFederalUnit(FederalUnit federalUnit) {
        System.out.println(federalUnit.getName());
        databaseService.saveFederalUnit(federalUnit);
        ibgeRESTtService.allMunicipalitiesInAState(federalUnit.getIdIBGE())
                .forEach(municipioDTO -> saveMunicipality(federalUnit, municipioDTO));
    }

    private void saveMunicipality(FederalUnit federalUnit, MunicipioDTO municipioDTO) {
        Municipality municipality = federalUnit.createMunicipalityFromDTO(municipioDTO);
        databaseService.saveMunicipality(municipality);
    }

}