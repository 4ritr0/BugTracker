package com.example.bugtracker;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bugtracker.model.Tester;
import com.example.bugtracker.repository.TesterRepository;

@SpringBootApplication
public class BugtrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BugtrackerApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(TesterRepository testerRepository) {
        return args -> {
            Tester tester = new Tester();
            tester.setUsername("test_user");
            tester.setPassword("pass123");
            testerRepository.save(tester);
            System.out.println("Tester saved!");
        };
    }
}