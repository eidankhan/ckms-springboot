package ulster.cybersecurity.org.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.Instant;

@Document(collection = "crypto_keys")
@Setter
@Getter
public class CryptoKey {

    @Id
    private String keyId;
    private String type;
    private KeyData keyData;
    private Metadata metadata;
    private boolean encrypted;

    // Constructors, Getters, and Setters

    @Setter
    @Getter
    public static class KeyData {
        private String publicKey;
        private String privateKey;
        private String symmetricKey;

        // Constructors, Getters, and Setters
    }

    @Setter
    @Getter
    public static class Metadata {
        private Instant creationDate;
        private int version;
        private boolean active;
        private String createdBy;

        // Constructors, Getters, and Setters
    }
}
