package ulster.cybersecurity.org.service;

import org.springframework.stereotype.Service;
import ulster.cybersecurity.org.model.Role;
import ulster.cybersecurity.org.repository.RoleRepository;

@Service
public class RoleService {
    private final RoleRepository roleRepository;
    public RoleService(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    public Boolean save(Role role){
        roleRepository.save(role);
        return true;
    }
}
