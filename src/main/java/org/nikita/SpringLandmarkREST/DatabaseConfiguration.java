package org.nikita.SpringLandmarkREST;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfiguration {
    private static final Logger log = LoggerFactory.getLogger(DatabaseConfiguration.class);

    @Bean
    CommandLineRunner initDatabase(){
        log.info("Initializing Database");
        return args -> {

        };
    }
}
