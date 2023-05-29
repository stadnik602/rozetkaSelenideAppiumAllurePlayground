package util;

import java.nio.charset.StandardCharsets;

public class WordingUtil {
    public static String toEncodedUtf8String(String original) {
        return new String(original.getBytes(), StandardCharsets.UTF_8);
    }
}
