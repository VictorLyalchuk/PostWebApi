package org.example;

import org.example.Services.DatabaseSeeder;
import org.example.storage.StorageProperty;
import org.example.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@SpringBootApplication
@EnableConfigurationProperties(StorageProperty.class)
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner runner(StorageService storageService, DatabaseSeeder databaseSeeder) {
        return args -> {
            storageService.init();
            databaseSeeder.SeedAllTables();
        };
    }
}