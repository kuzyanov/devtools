package ru.devtools.utils;

import static java.util.TimeZone.getTimeZone;
import static java.util.stream.Collectors.joining;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import lombok.experimental.UtilityClass;
import org.springframework.scheduling.support.CronSequenceGenerator;

/** @author Stepan_Kuzyanov */
@UtilityClass
public class CronUtils {

  public static String cronSequenceString(String cron, String timeZoneId, int count) {
    return cronSequence(cron, timeZoneId, count).stream()
        .map(Date::toInstant)
        .map(instant -> instant.atZone(ZoneId.of(timeZoneId)))
        .map(ZonedDateTime::toString)
        .collect(joining("\n"));
  }

  private static List<Date> cronSequence(String cron, String timeZoneId, int count) {
    TimeZone timeZone = getTimeZone(timeZoneId);
    CronSequenceGenerator generator = new CronSequenceGenerator(cron, timeZone);

    Date date = new Date();
    List<Date> dates = new ArrayList<>(count);

    for (int i = 0; i < count; i++) {
      date = generator.next(date);
      dates.add(date);
    }

    return dates;
  }
}
