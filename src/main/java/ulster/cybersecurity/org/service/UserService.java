package ulster.cybersecurity.org.service;

import ulster.cybersecurity.org.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Autowired
    private ulster.cybersecurity.org.repository.userRepository userRepository;

    public User save(User user){
        // Encoding password before saving to database
        user.setPassword(bcryptEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User getRoleByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
