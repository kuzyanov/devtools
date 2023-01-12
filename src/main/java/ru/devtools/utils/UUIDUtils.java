package ru.devtools.utils;

import java.util.Optional;
import java.util.UUID;
import lombok.experimental.UtilityClass;

/**
 * @author Stepan_Kuzyanov
 */
@UtilityClass
public class UUIDUtils {

  private static final String DASH = "-";

  public static UUID fromNotDashedString(String str) {
    return Optional.ofNullable(str)
        .filter(s -> s.length() == 32)
        .map(UUIDUtils::formatFromNotDashedString)
        .map(UUID::fromString)
        .orElseThrow(() -> new IllegalArgumentException("Invalid UUID string: " + str));
  }

  private static String formatFromNotDashedString(String str) {
    return String.join(DASH, str.substring(0, 8), str.substring(8, 12), str.substring(12, 16), str.substring(16, 20), str.substring(20));
  }
}
