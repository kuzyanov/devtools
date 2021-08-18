package ru.devtools.rest.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_OCTET_STREAM_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;
import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.devtools.dto.CronSequenceRequestDto;
import ru.devtools.dto.SingleResponseDto;
import ru.devtools.utils.Base64Utils;
import ru.devtools.utils.CronUtils;
import ru.devtools.utils.JwtUtils;

/** @author Stepan_Kuzyanov */
@RestController
@RequestMapping("/utils")
@RequiredArgsConstructor
public class UtilsController {

  @PostMapping(value = "/file-base64", consumes = MULTIPART_FORM_DATA_VALUE, produces = TEXT_PLAIN_VALUE)
  public String fileToBase64(@RequestParam("file") MultipartFile file) throws IOException {
    return Base64Utils.encodeBase64(file.getBytes());
  }

  @PostMapping(value = "/string-base64", consumes = TEXT_PLAIN_VALUE, produces = TEXT_PLAIN_VALUE)
  public String stringToBase64(@RequestBody String data) {
    return Base64Utils.encodeBase64(data);
  }

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

  @PostMapping(value = "/jwt-decode-header", consumes = TEXT_PLAIN_VALUE, produces = APPLICATION_JSON_VALUE)
  public String decodeJwtHeader(@RequestBody String token) {
    return JwtUtils.decodeJwtHeader(token);
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

  @PostMapping(value = "/unescape-xml", consumes = TEXT_PLAIN_VALUE, produces = APPLICATION_XML_VALUE)
  public String unescapeXmlString(@RequestBody String str) {
    return StringEscapeUtils.unescapeXml(str);
  }

  @PostMapping(value = "/escape-json", consumes = TEXT_PLAIN_VALUE)
  public SingleResponseDto<String> escapeJson(@RequestBody String str) {
    return SingleResponseDto.of(str);
  }

  @PostMapping(value = "/cron-sequence", consumes = APPLICATION_JSON_VALUE, produces = TEXT_PLAIN_VALUE)
  public String cronSequence(@RequestBody CronSequenceRequestDto request) {
    return CronUtils.cronSequenceString(request.getCron(), request.getTimeZone(), request.getCount());
  }
}
