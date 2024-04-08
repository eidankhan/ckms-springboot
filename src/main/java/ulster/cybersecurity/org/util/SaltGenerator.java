package ulster.cybersecurity.org.util;

import java.security.SecureRandom;
import org.apache.commons.codec.binary.Hex;

public class SaltGenerator {
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16]; // Or 32 bytes for a 256-bit salt
        random.nextBytes(salt);
        String hexSalt = Hex.encodeHexString(salt);
        System.out.println("Generated Hex Salt: " + hexSalt);
    }
}
