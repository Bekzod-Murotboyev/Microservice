package dev.bekzod.servicesecurity.components;

import dev.bekzod.servicesecurity.entities.UserEntity;
import dev.bekzod.servicesecurity.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public record DataLoader(
        UserRepository userRepository,
        PasswordEncoder passwordEncoder
) implements CommandLineRunner {
    @Override
    public void run(String... args) {
        userRepository
                .findByUsername("root")
                .orElseGet(() -> userRepository.save(
                        new UserEntity(
                                1,
                                "root",
                                passwordEncoder.encode("root123"),
                                true, true, true, true
                        )));
    }
}
