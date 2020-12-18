package ru.devtools.utils;

import lombok.experimental.UtilityClass;

/** @author Stepan_Kuzyanov */
@UtilityClass
public class JwtUtils {

  public static String decodeJwtHeader(String jwt) {
    String[] split = jwt.split("\\.");

    if (split.length != 3) {
      throw new IllegalArgumentException("Invalid jwt token");
    }

    String header = split[0];

    return Base64Utils.decodeBase64(header);
  }

  public static String decodeJwtPayload(String jwt) {
    String[] split = jwt.split("\\.");

    if (split.length != 3) {
      throw new IllegalArgumentException("Invalid jwt token");
    }

    String payload = split[1];

    return Base64Utils.decodeBase64(payload);
  }
}
