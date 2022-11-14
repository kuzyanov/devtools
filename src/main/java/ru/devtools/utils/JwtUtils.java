package ru.devtools.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;
import ru.devtools.dto.JwtDto;

/** @author Stepan_Kuzyanov */
@UtilityClass
public class JwtUtils {

  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

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

  public static JwtDto decodeJwtUrl(String jwt) throws Exception {
    String[] split = jwt.split("\\.");

    if (split.length != 3) {
      throw new IllegalArgumentException("Invalid jwt token");
    }

    return new JwtDto()
        .setHeader(OBJECT_MAPPER.readTree(Base64Utils.decodeBase64Url(split[0])))
        .setPayload(OBJECT_MAPPER.readTree(Base64Utils.decodeBase64Url(split[1])))
        .setSign(split[2]);
  }
}
