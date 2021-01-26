package se.ikea.payments.delayedcapture.utils;

import org.springframework.format.datetime.standard.TemporalAccessorParser;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class Utils {

    private static final DateTimeFormatter IOPD_MESSAGE_DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSZ");


    public static final Timestamp parseStringToTimestamp(String timestamp) {

            return Timestamp.valueOf(LocalDateTime.from(IOPD_MESSAGE_DATE_FORMATTER.parse(timestamp)));
    }
}
