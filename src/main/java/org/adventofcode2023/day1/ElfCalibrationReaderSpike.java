package org.adventofcode2023.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ElfCalibrationReaderSpike {

    public static void main(String[] args) throws IOException {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try(InputStream inputStream = classLoader.getResourceAsStream("./2023-day1-input.txt")){
            BufferedReader bufferedReader  = new BufferedReader(
                    new InputStreamReader(inputStream, StandardCharsets.UTF_8)
            );
            String line;
            List<CalibrationRecord> calibrationRecords = new ArrayList<>();
            while ((line = bufferedReader.readLine()) !=null){
                calibrationRecords.add(new CalibrationRecord(line));
            }
            int sumOfCalibrationRecords  = calibrationRecords.stream()
                    .mapToInt(CalibrationRecord::getCalibrationValue)
                    .sum();

            System.out.println(sumOfCalibrationRecords); //54573
        }
    }
}
