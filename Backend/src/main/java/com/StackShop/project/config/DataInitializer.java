package com.StackShop.project.config;

import com.StackShop.project.security.RoleRepository;
import com.StackShop.project.user.Role;
import com.StackShop.project.user.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        // Initialize roles if they don't exist
        for (UserRole userRole : UserRole.values()) {
            if (roleRepository.findByRoleName(userRole).isEmpty()) {
                roleRepository.save(new Role(userRole));
                System.out.println("Created role: " + userRole);
            }
        }
    }
}

