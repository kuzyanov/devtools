package ru.devtools.utils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import lombok.experimental.UtilityClass;

/** @author Stepan_Kuzyanov */
@UtilityClass
public class Base64Utils {

  public static String decodeBase64(String data) {
    byte[] decoded = base64ToBytes(data);
    return new String(decoded, StandardCharsets.UTF_8);
  }

  public static byte[] base64ToBytes(String data) {
    return Base64.getDecoder().decode(data);
  }

  public static String encodeBase64(String data) {
    return encodeBase64(data.getBytes(StandardCharsets.UTF_8));
  }

  public static String encodeBase64(byte[] data) {
    return Base64.getEncoder().encodeToString(data);
  }
}
