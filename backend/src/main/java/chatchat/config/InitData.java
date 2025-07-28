package chatchat.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import chatchat.entity.Role;
import chatchat.repository.RoleRepository;

@Configuration
public class InitData {

    @Bean
    public CommandLineRunner init(RoleRepository roleRepository) {
        return args -> {
            if (roleRepository.findByName("ADMIN") == null) {
                 roleRepository.save(new Role("ADMIN"));
            }
            if (roleRepository.findByName("USER") == null) {
                 roleRepository.save(new Role("USER"));
            }
        };
    }
}
