package ulster.cybersecurity.org.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ulster.cybersecurity.org.service.KeyGeneratorService;

import javax.crypto.SecretKey;
import java.util.Base64;

@RestController
@RequestMapping("/keys-generation")
public class KeyGeneratorController {
    private final KeyGeneratorService keyGeneratorService;
    public KeyGeneratorController(KeyGeneratorService keyGeneratorService) {
        this.keyGeneratorService = keyGeneratorService;
    }
    @GetMapping("/symmetric-key-generation")
    public ResponseEntity<?> getSymmetricKey(){
        SecretKey secretKey = keyGeneratorService.generateSymmetricKey();
        // Encode the key bytes in Base64 to get a String representation
        String encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
        return ResponseEntity.ok(encodedKey);
    }
}
