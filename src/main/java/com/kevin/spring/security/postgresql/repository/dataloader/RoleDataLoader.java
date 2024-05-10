package com.kevin.spring.security.postgresql.repository.dataloader;

import com.kevin.spring.security.postgresql.models.Role;
import com.kevin.spring.security.postgresql.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static com.kevin.spring.security.postgresql.models.ERole.*;


@Component
public class RoleDataLoader implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        // Load initial data into the database
        roleRepository.save(new Role(ROLE_USER));
        roleRepository.save(new Role(ROLE_MODERATOR));
        roleRepository.save(new Role(ROLE_ADMIN));
    }
}