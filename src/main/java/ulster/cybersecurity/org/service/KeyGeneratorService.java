package ulster.cybersecurity.org.service;

import org.springframework.stereotype.Service;
import ulster.cybersecurity.org.config.CryptographyProperties;
import ulster.cybersecurity.org.exceptionhandler.KeyGeneratorException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

@Service
public class KeyGeneratorService {
    private final CryptographyProperties cryptographyProperties;
    public KeyGeneratorService(CryptographyProperties cryptographyProperties){
        this.cryptographyProperties = cryptographyProperties;
    }
    public SecretKey generateSymmetricKey() {
        try {
            // Create a new key generator instance for AES
            KeyGenerator keyGenerator = KeyGenerator.getInstance(cryptographyProperties.getSymmetricKeyAlgorithm());

            // Initialize the key generator with specific key size
            SecureRandom secureRandom = new SecureRandom();
            keyGenerator.init(cryptographyProperties.getSymmetricKeySize(), secureRandom);

            // Generate the key
            SecretKey secretKey = keyGenerator.generateKey();
            System.out.println("Asymmetric key generated successfully");
            return secretKey;
        } catch (NoSuchAlgorithmException e) {
            throw new KeyGeneratorException("Error while generating secret key");
        }
    }

}
