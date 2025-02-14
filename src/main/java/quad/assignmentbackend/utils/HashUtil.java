package quad.assignmentbackend.utils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.regex.Pattern;

public class HashUtil {
    private static final Pattern AlphanumericCharacters = Pattern.compile("[^a-z0-9]");

    public static String hashForId(String text) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(text.getBytes(StandardCharsets.UTF_8));
            String base64 = Base64.getEncoder().encodeToString(hash);
            // Make it web-safe
            return AlphanumericCharacters.matcher(base64.toLowerCase()).replaceAll("");

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing text", e);
        }
    }
}