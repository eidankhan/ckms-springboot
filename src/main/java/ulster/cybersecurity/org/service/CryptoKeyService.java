package ulster.cybersecurity.org.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.stereotype.Service;
import ulster.cybersecurity.org.config.CryptographyProperties;
import ulster.cybersecurity.org.exceptionhandler.KeyGeneratorException;
import ulster.cybersecurity.org.model.CryptoKey;
import ulster.cybersecurity.org.repository.CryptoKeyRepository;
import ulster.cybersecurity.org.util.MasterKeyUtil;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.Instant;

@Service
public class CryptoKeyService {
    private final CryptographyProperties cryptographyProperties;

    private final CryptoKeyRepository cryptoKeyRepository;
    private final String masterKey;
    private final String masterKeySalt;

    @Autowired
    public CryptoKeyService(CryptoKeyRepository cryptoKeyRepository, CryptographyProperties cryptographyProperties) {
        this.cryptoKeyRepository = cryptoKeyRepository;
        this.cryptographyProperties = cryptographyProperties;
        this.masterKey = MasterKeyUtil.getKey();
        this.masterKeySalt = MasterKeyUtil.getSalt();
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

    public void storeSymmetricKey(String symmetricKey, String createdBy) {
        // Create an encryptor with the master key and a salt
        TextEncryptor encryptor = Encryptors.text(masterKey, masterKeySalt);

        // Encrypt the symmetric key
        String encryptedKey = encryptor.encrypt(symmetricKey);

        // Prepare the key and metadata for storage
        CryptoKey cryptoKey = new CryptoKey();
        cryptoKey.setType("symmetric");
        CryptoKey.KeyData keyData = new CryptoKey.KeyData();
        keyData.setSymmetricKey(encryptedKey);
        cryptoKey.setKeyData(keyData);

        CryptoKey.Metadata metadata = new CryptoKey.Metadata();
        metadata.setCreationDate(Instant.now());
        metadata.setVersion(1);
        metadata.setActive(true);
        metadata.setCreatedBy(createdBy);
        cryptoKey.setMetadata(metadata);

        cryptoKey.setEncrypted(true);

        // Store the key in MongoDB
        cryptoKeyRepository.save(cryptoKey);
        System.out.println("Symmetric key saved successfully");
    }
}
