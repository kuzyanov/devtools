package ru.devtools.utils;

import lombok.experimental.UtilityClass;

/** @author Stepan_Kuzyanov */
@UtilityClass
public class JwtUtils {

  public static String decodeJwtPayload(String jwt) {
    String[] split = jwt.split("\\.");

    if (split.length != 3) {
      throw new IllegalArgumentException("Invalid jwt token");
    }

    String payload = split[1];

    return Base64Utils.decodeBase64(payload);
  }
}
