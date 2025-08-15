package socketprogram;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

public class Crypto {
    // NOTE: In production, use a unique, random salt per deployment and store securely.
    private static final byte[] SALT = "chatapp.salt.v1".getBytes();
    private static final int ITERATIONS = 100_000;
    private static final int KEY_LENGTH = 256; // bits
    private static final int GCM_TAG_BITS = 128;

    private static final SecureRandom RNG = new SecureRandom();

    public static SecretKey deriveKey(char[] passphrase) throws Exception {
        PBEKeySpec spec = new PBEKeySpec(passphrase, SALT, ITERATIONS, KEY_LENGTH);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        byte[] keyBytes = skf.generateSecret(spec).getEncoded();
        return new SecretKeySpec(keyBytes, "AES");
    }

    public static String encrypt(String plaintext, SecretKey key) throws Exception {
        byte[] iv = new byte[12]; // 96-bit IV is recommended for GCM
        RNG.nextBytes(iv);

        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, key, new GCMParameterSpec(GCM_TAG_BITS, iv));
        byte[] cipherText = cipher.doFinal(plaintext.getBytes("UTF-8"));

        // Package as: base64( iv || ciphertext )
        byte[] out = new byte[iv.length + cipherText.length];
        System.arraycopy(iv, 0, out, 0, iv.length);
        System.arraycopy(cipherText, 0, out, iv.length, cipherText.length);
        return Base64.getEncoder().encodeToString(out);
    }

    public static String decrypt(String base64, SecretKey key) throws Exception {
        byte[] input = Base64.getDecoder().decode(base64);
        if (input.length < 13) throw new IllegalArgumentException("Invalid ciphertext");
        byte[] iv = new byte[12];
        byte[] cipherText = new byte[input.length - 12];
        System.arraycopy(input, 0, iv, 0, 12);
        System.arraycopy(input, 12, cipherText, 0, cipherText.length);

        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(Cipher.DECRYPT_MODE, key, new GCMParameterSpec(GCM_TAG_BITS, iv));
        byte[] plain = cipher.doFinal(cipherText);
        return new String(plain, "UTF-8");
    }
}