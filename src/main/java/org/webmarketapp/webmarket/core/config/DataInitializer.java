package org.webmarketapp.webmarket.core.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.webmarketapp.webmarket.domain.Repository.UserRepository;
import org.webmarketapp.webmarket.domain.model.User;

import java.time.LocalDate;

@Configuration
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.findByRole("ADMIN").isEmpty()) {
            User admin = new User(
                    null,
                    "System Administrator",
                    "admin@webmarket.com",
                    passwordEncoder.encode("admin123"),
                    LocalDate.of(1990, 1, 1),
                    "CEO",
                    0.0,
                    "ADMIN"
            );
            userRepository.save(admin);
            System.out.println("ADMIN user created successfully! Email: admin@webmarket.com | Pass: admin123");
        }
    }
}