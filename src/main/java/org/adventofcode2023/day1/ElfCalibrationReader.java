package org.adventofcode2023.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ElfCalibrationReader {

    private List<CalibrationRecord> calibrationRecords = new ArrayList<>();

    private final Map<String,String> mapLettersInDigits =
            Stream.of(new String[][]{
                    {"one","1"},
                    {"two","2"},
                    {"three","3"},
                    {"four","4"},
                    {"five","5"},
                    {"six","6"},
                    {"seven","7"},
                    {"eight","8"},
                    {"nine","9"}
            }).collect(Collectors.toMap(entry -> entry[0], entry -> entry[1]));

    public ElfCalibrationReader(BufferedReader bufferedReader, boolean sanitize) {
        try {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (sanitize) {
                    String record = sanitizeCalibrationRecord(line);
                    calibrationRecords.add(new CalibrationRecord(record));
                } else {
                    calibrationRecords.add(new CalibrationRecord(line));
                }
            }
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
    }

    public int getCalibrationsSum() {
        return calibrationRecords.stream()
                .mapToInt(CalibrationRecord::getCalibrationValue)
                .sum();
    }

    private String sanitizeCalibrationRecord(final String record) {
        final String[] tempCalibrationRecord = {record};
        AtomicReference<String> firstOccurrenceDigit = new AtomicReference<>("");
        AtomicReference<String> lastOccurrenceDigit = new AtomicReference<>("");

        AtomicInteger min = new AtomicInteger(Integer.MAX_VALUE);
        AtomicInteger max = new AtomicInteger(Integer.MIN_VALUE);

        mapLettersInDigits.forEach((key, value) -> {

            if(record.contains(key)) {
                int firstOccurIndex = record.indexOf(key);
                if (firstOccurIndex < min.get()) {
                    firstOccurrenceDigit.set(key);
                    min.set(firstOccurIndex);
                }

                int lastOccurIndex = record.lastIndexOf(key);
                if (lastOccurIndex > max.get()) {
                    lastOccurrenceDigit.set(key);
                    max.set(lastOccurIndex);
                }
            }
        });

        Pattern pattern = Pattern.compile("([0-9]{1}+)");
        Matcher matcher = pattern.matcher(record);
        int firstDigitMatchIndex =Integer.MAX_VALUE;
        int lastDigitMatchIndex = Integer.MIN_VALUE;
        while (matcher.find()) {
            lastDigitMatchIndex = matcher.start(0);
            if (firstDigitMatchIndex == Integer.MAX_VALUE) {
                firstDigitMatchIndex = lastDigitMatchIndex;
            }
        }

        if(!firstOccurrenceDigit.get().isBlank() && min.get() < firstDigitMatchIndex) {
            tempCalibrationRecord[0] = tempCalibrationRecord[0]
                    .replaceFirst(firstOccurrenceDigit.get(),
                            mapLettersInDigits.get(firstOccurrenceDigit.get()));
        }

        if(!lastOccurrenceDigit.get().isBlank() && max.get() > lastDigitMatchIndex) {
            tempCalibrationRecord[0] = tempCalibrationRecord[0]
                    .replaceAll(lastOccurrenceDigit.get(),
                            mapLettersInDigits.get(lastOccurrenceDigit.get()));
        }
        return tempCalibrationRecord[0];
    }
}
