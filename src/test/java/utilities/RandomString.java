package utilities;

import java.util.Random;

public class RandomString {

    public static String generateRandomString(int length) {
        String CHARACTER = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ01234567890";
        Random random = new Random();
        if (length < 1) throw new IllegalArgumentException("Length must be positive");
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(CHARACTER.length());
            sb.append(CHARACTER.charAt(randomIndex));
        }
        return sb.toString();
    }
}
