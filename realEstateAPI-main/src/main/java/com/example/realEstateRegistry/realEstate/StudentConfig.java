package com.example.realEstateRegistry.realEstate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(RealEstateRepository repository) {
        return args -> {
            RealEstate mantas = new RealEstate(
                    "Dusetos",
                    "Vienazindzio",
                    3,
                    "Mantas",
                    200L,
                    20000D,
                    "House",
                    22D
            );
            RealEstate lukas = new RealEstate(
                    "Vilnius",
                    "Liepu",
                    5,
                    "Mantas",
                    20L,
                    69000D,
                    "Apartment",
                    15D
            );

            repository.saveAll(
                    List.of(mantas, lukas)
            );
        };

    }
}
