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
import ulster.cybersecurity.org.util.JwtResponse;

@RestController
@CrossOrigin
public class JwtAuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final JwtUserDetailsService userDetailsService;
    @Autowired
    public JwtAuthenticationController(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil,
                                       JwtUserDetailsService userDetailsService){
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public GenericResponse createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        GenericResponse authenticationResponse = authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        if(authenticationResponse.getCode() != 200)
            return authenticationResponse;
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        authenticationResponse.setData(new JwtResponse(token,
                userDetails.getAuthorities().toString(), userDetails.getUsername()));
        return authenticationResponse;
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
