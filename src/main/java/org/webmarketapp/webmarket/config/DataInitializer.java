package org.webmarketapp.webmarket.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.webmarketapp.webmarket.Repository.UserRepository;
import org.webmarketapp.webmarket.model.User;

import java.time.LocalDate;

@Configuration
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.findByRole("ADMIN").isEmpty()) {
            User admin = new User(
                    null,
                    "System Administrator",
                    LocalDate.of(1990, 1, 1),
                    "CEO",
                    0.0,
                    "ADMIN"
            );
            userRepository.save(admin);
            System.out.println("ADMIN user created successfully!");
        }
    }
}