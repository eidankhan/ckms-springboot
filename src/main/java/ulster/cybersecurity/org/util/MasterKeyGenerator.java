package ulster.cybersecurity.org.util;

import java.security.SecureRandom;
import java.util.Base64;

public class MasterKeyGenerator {
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        byte[] key = new byte[32]; // 256 bits are 32 bytes
        random.nextBytes(key);
        String encodedKey = Base64.getEncoder().encodeToString(key);
        System.out.println("Generated Master Key: " + encodedKey);
        System.out.println("Master Key: " + MasterKeyUtil.getKey());
        System.out.println("Master Key Salt: " + MasterKeyUtil.getSalt());
    }
}
