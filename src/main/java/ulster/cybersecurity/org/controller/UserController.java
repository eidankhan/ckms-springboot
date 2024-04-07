package ulster.cybersecurity.org.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ulster.cybersecurity.org.model.User;
import ulster.cybersecurity.org.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody User user,
                                      @RequestParam(required = false) String role) throws Exception {
        return ResponseEntity.ok(userService.save(user, role));
    }
}
