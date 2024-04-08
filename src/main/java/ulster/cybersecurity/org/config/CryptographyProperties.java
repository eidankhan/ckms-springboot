package ulster.cybersecurity.org.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "security.cryptography")
@Setter
@Getter
public class CryptographyProperties {
    private String symmetricKeyAlgorithm;
    private int symmetricKeySize;
    private String asymmetricKeyAlgorithm;
    private int asymmetricKeySize;

    // Standard setters and getters for properties
}
