package ru.devtools.rest.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_OCTET_STREAM_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

import org.apache.commons.text.StringEscapeUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.devtools.utils.Base64Utils;
import ru.devtools.utils.JwtUtils;

/** @author Stepan_Kuzyanov */
@RestController
@RequestMapping("/utils")
public class UtilsController {

  @PostMapping(value = "/base64-string", consumes = TEXT_PLAIN_VALUE, produces = TEXT_PLAIN_VALUE)
  public String base64toString(@RequestBody String data) {
    return Base64Utils.decodeBase64(data);
  }

  @PostMapping(value = "/base64-json", consumes = TEXT_PLAIN_VALUE, produces = APPLICATION_JSON_VALUE)
  public String base64toJson(@RequestBody String data) {
    return Base64Utils.decodeBase64(data);
  }

  @PostMapping(value = "/base64-bytes", consumes = TEXT_PLAIN_VALUE, produces = APPLICATION_OCTET_STREAM_VALUE)
  public byte[] base64ToBytes(@RequestBody String data) {
    return Base64Utils.base64ToBytes(data);
  }

  @PostMapping(value = "/jwt-decode", consumes = TEXT_PLAIN_VALUE, produces = APPLICATION_JSON_VALUE)
  public String decodeJwtPayload(@RequestBody String token) {
    return JwtUtils.decodeJwtPayload(token);
  }

  @PostMapping(value = "/html4-unescape", consumes = TEXT_PLAIN_VALUE, produces = TEXT_PLAIN_VALUE)
  public String unescapeHtml4String(@RequestBody String str) {
    return StringEscapeUtils.unescapeHtml4(str);
  }

  @PostMapping(value = "/html4-unescape-xml", consumes = TEXT_PLAIN_VALUE, produces = APPLICATION_XML_VALUE)
  public String unescapeHtml4XmlString(@RequestBody String str) {
    return StringEscapeUtils.unescapeHtml4(str);
  }
}
