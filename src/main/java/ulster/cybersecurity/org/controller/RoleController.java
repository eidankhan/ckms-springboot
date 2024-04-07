package ulster.cybersecurity.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @GetMapping
    public ResponseEntity<?> save(@RequestBody Role role) {
        return ResponseEntity.ok(roleService.save(role));
    }
}
