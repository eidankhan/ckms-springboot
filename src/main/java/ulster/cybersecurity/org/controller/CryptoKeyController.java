package ulster.cybersecurity.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ulster.cybersecurity.org.service.CryptoKeyService;

import javax.crypto.SecretKey;
import java.util.Base64;

@RestController
@RequestMapping("/crypto-keys")
public class CryptoKeyController {
    private final CryptoKeyService cryptoKeyService;
    @Autowired
    public CryptoKeyController(CryptoKeyService cryptoKeyService) {
        this.cryptoKeyService = cryptoKeyService;
    }
    @GetMapping("/generate-symmetric-key")
    public ResponseEntity<?> getSymmetricKey(){
        SecretKey secretKey = cryptoKeyService.generateSymmetricKey();
        // Encode the key bytes in Base64 to get a String representation
        String encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
        return ResponseEntity.ok(encodedKey);
    }

    @GetMapping("/store-symmetric-key")
    public ResponseEntity<?> storeSymmetricKey(){
        SecretKey secretKey = cryptoKeyService.generateSymmetricKey();
        String symmetricKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
        cryptoKeyService.storeSymmetricKey(symmetricKey,"eidancodez");
        return ResponseEntity.ok("Symmetric key stored in the database successfully");
    }
}
