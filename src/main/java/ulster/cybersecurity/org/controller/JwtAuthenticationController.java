package ulster.cybersecurity.org.controller;

import ulster.cybersecurity.org.config.JwtTokenUtil;
import ulster.cybersecurity.org.model.User;
import ulster.cybersecurity.org.service.JwtUserDetailsService;
import ulster.cybersecurity.org.service.UserService;
import ulster.cybersecurity.org.util.GenericResponse;
import ulster.cybersecurity.org.util.JwtRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public GenericResponse createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        GenericResponse authenticationResponse = authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        if(authenticationResponse.getCode() != 200)
            return authenticationResponse;
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        User currentUser = userService.getRoleByUsername(userDetails.getUsername());
//        authenticationResponse.setData(new JwtResponse(token,
//                currentUser.getUserType(), currentUser.getName()));
        return authenticationResponse;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody User user) throws Exception {
        return ResponseEntity.ok(userService.save(user));
    }

    private GenericResponse authenticate(String username, String password) throws Exception {
        GenericResponse response = null;
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            response = new GenericResponse(200, "AUTHENTICATED");
        } catch (DisabledException e) {
            response = new GenericResponse(401, "USER_DISABLED");
            System.err.println("Exception --> "+e.getMessage());
        } catch (BadCredentialsException e) {
            response = new GenericResponse(401, "INVALID_CREDENTIALS");
            System.err.println("Exception --> "+e.getMessage());
        }
        return response;
    }
}
