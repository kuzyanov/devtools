package ru.devtools.dto;

import lombok.Data;

/** @author Stepan_Kuzyanov */
@Data
public class CronSequenceRequestDto {
  private String cron;
  private String timeZone = "UTC";
  private int count = 10;
}
