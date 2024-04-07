package ulster.cybersecurity.org.service;

import com.mongodb.DuplicateKeyException;
import org.springframework.stereotype.Service;
import ulster.cybersecurity.org.exceptionhandler.RoleAlreadyExistsException;
import ulster.cybersecurity.org.model.Role;
import ulster.cybersecurity.org.repository.RoleRepository;

@Service
public class RoleService {
    private final RoleRepository roleRepository;
    public RoleService(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    public Boolean save(Role role){
        Role existingRole = roleRepository.findByName(role.getName()).orElse(null);
        if(existingRole != null)
            throw new RoleAlreadyExistsException(existingRole.getName()+" role already exists");
        roleRepository.save(role);
        return true;
    }
}
