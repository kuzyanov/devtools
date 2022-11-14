package ru.devtools.dto;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;
import lombok.experimental.Accessors;

/** @author Stepan_Kuzyanov */
@Data
@Accessors(chain = true)
public class JwtDto {
  private JsonNode header;
  private JsonNode payload;
  private String sign;
}
