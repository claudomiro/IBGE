package org.codigolimpo.IBGE;

import org.codigolimpo.IBGE.domain.DTO.EstadoDTO;
import org.codigolimpo.IBGE.service.IBGEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class IbgeApplication {

    @Autowired
    IBGEService service;

    public static void main(String[] args) {
        SpringApplication.run(IbgeApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx)  {
        return (args -> run());
    }

    private void run() {
        for (EstadoDTO state : service.allStates().collect(Collectors.toList())) {
            System.out.println( String.format("(=====> %s (%s)", state.getNome(), state.getSigla()));
            printAllMunicipalities(state);
        }
    }

    private void printAllMunicipalities(EstadoDTO s) {
        service.allMunicipalitiesInAState(s.getId())
                .forEach(m -> System.out.println(m.getNome()));
    }
}