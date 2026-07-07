package com.spring.ai.application.domain;

import org.springframework.context.i18n.LocaleContextHolder;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;


public class DateHelper {

    public static String formatTimestampToStringDate(Timestamp timestamp) {

        String localePrefix = String.valueOf(LocaleContextHolder.getLocale());
        LocalDateTime dateTime = LocalDateTime.ofInstant(timestamp.toInstant(), ZoneId.systemDefault());

        Locale locale = new Locale(localePrefix, localePrefix.equals("en") ? "US" : "BR");

        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
                .withLocale(locale);

        return dateTime.format(formatter);
    }
}
