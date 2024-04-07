package ulster.cybersecurity.org.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ulster.cybersecurity.org.model.Role;
import ulster.cybersecurity.org.repository.RoleRepository;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        initializeRoles();
    }

    private void initializeRoles() {
        // List of default roles you want to ensure exist
        String[] roles = {"ADMIN", "USER", "GUEST"};

        for (String roleName : roles) {
            // Check if the role already exists
            Role existingRole = roleRepository.findByName(roleName).orElse(null);
            if (existingRole == null) {
                // If not, insert the new role
                Role newRole = new Role();
                newRole.setName(roleName);
                roleRepository.save(newRole);
                System.out.println("Inserted new role: " + roleName);
            }
        }
    }
}
