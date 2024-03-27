package com.adria.notification.config.security;

import com.adria.notification.exceptions.GenericException;
import com.adria.notification.models.enums.error.ErrorCode;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

@Component
public class EncryptionSecurity {

    private static final String ENCRYPTION_ALGORITHM = "AES/GCM/NoPadding";

    private static final int GCM_IV_LENGTH = 12;

    private static final int GCM_TAG_LENGTH = 16;

    private static final String KEY_GENERATOR_ALGORITHM = "AES";

    public String encryptSecret(@NonNull String secret, @NonNull String key) {

        try {

            byte[] iv = new byte[GCM_IV_LENGTH];

            (new SecureRandom()).nextBytes(iv);

            GCMParameterSpec ivSpec = new GCMParameterSpec(GCM_TAG_LENGTH * Byte.SIZE, iv);

            Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);

            cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(key), ivSpec);

            byte[] cipherText = cipher.doFinal(secret.getBytes());

            byte[] encryptedSecret = new byte[iv.length + cipherText.length];

            System.arraycopy(iv, 0, encryptedSecret, 0, iv.length);

            System.arraycopy(cipherText, 0, encryptedSecret, iv.length, cipherText.length);

            return Base64.getEncoder().encodeToString(encryptedSecret);

        } catch (Exception e) {

            throw new GenericException(ErrorCode.SYSTEM_ENCRYPTION_ERROR, e);

        }

    }

    public String decryptSecret(@NonNull String encryptedSecret, @NonNull String key) {

        try {

            byte[] rawEncryptedSecret = Base64.getDecoder().decode(encryptedSecret);

            byte[] iv = Arrays.copyOfRange(rawEncryptedSecret, 0, GCM_IV_LENGTH);

            GCMParameterSpec ivSpec = new GCMParameterSpec(GCM_TAG_LENGTH * Byte.SIZE, iv);

            Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);

            cipher.init(Cipher.DECRYPT_MODE, getSecretKey(key), ivSpec);

            byte[] decodedSecret = cipher.doFinal(rawEncryptedSecret, GCM_IV_LENGTH, rawEncryptedSecret.length - GCM_IV_LENGTH);

            return new String(decodedSecret);

        } catch (Exception e) {

            throw new GenericException(ErrorCode.SYSTEM_DECRYPTION_ERROR, e);

        }

    }

    private SecretKey getSecretKey(String encodedSecretKey) {

        byte[] decodedSecretKey = Base64.getDecoder().decode(encodedSecretKey);

        return new SecretKeySpec(decodedSecretKey, 0, decodedSecretKey.length, KEY_GENERATOR_ALGORITHM);

    }


}
