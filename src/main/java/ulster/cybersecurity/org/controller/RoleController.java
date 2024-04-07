package ulster.cybersecurity.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ulster.cybersecurity.org.model.Role;
import ulster.cybersecurity.org.service.RoleService;

@RestController
@RequestMapping(value = "/roles")
public class RoleController {
    private final RoleService roleService;
    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Role role) {
        Boolean isNewRoleIntroduced = roleService.save(role);
        return isNewRoleIntroduced
                ? ResponseEntity.ok("New role introduced successfully")
                : ResponseEntity.ok("Unable to introduce new role");
    }
}
