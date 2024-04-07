package ulster.cybersecurity.org.service;

import ulster.cybersecurity.org.exceptionhandler.DefaultRoleNotFoundException;
import ulster.cybersecurity.org.exceptionhandler.RoleNotFoundException;
import ulster.cybersecurity.org.model.Role;
import ulster.cybersecurity.org.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ulster.cybersecurity.org.repository.RoleRepository;
import ulster.cybersecurity.org.repository.UserRepository;

import java.util.Collections;

@Service
public class UserService {
    private final PasswordEncoder bcryptEncoder;
    private final UserRepository userRepository;

    private final RoleRepository roleRepository;
    @Autowired
    public UserService(PasswordEncoder bcryptEncoder, UserRepository userRepository,
                       RoleRepository roleRepository) {
        this.bcryptEncoder = bcryptEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public User save(User user){
        // Encoding password before saving to database
        user.setPassword(bcryptEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User save(User user, String roleName){
        Role userRole = (roleName == null || roleName.isEmpty())
                ? roleRepository.findByName("ADMIN").orElseThrow(() -> new DefaultRoleNotFoundException("Default role not found"))
                : roleRepository.findByName(roleName).orElseThrow(() -> new RoleNotFoundException("Role not found"));
        user.setRoles(Collections.singleton(userRole));
        return userRepository.save(user);
    }
}
