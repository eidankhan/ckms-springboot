package ulster.cybersecurity.org.util;

public class MasterKeyUtil {

    private static final String MASTER_KEY_ENV = "MASTER_KEY";
    private static final String MASTER_KEY_SALT = "MASTER_KEY_SALT";

    public static String getKey() {
        String masterKey = System.getenv(MASTER_KEY_ENV);
        if (masterKey == null || masterKey.trim().isEmpty()) {
            throw new IllegalStateException("Master key not found in environment variables.");
        }
        return masterKey;
    }

    public static String getSalt() {
        String masterKeySalt = System.getenv(MASTER_KEY_SALT);
        if (masterKeySalt == null || masterKeySalt.trim().isEmpty()) {
            throw new IllegalStateException("Master key salt not found in environment variables.");
        }
        return masterKeySalt;
    }

}
