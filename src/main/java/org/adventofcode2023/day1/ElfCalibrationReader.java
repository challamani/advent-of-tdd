package org.adventofcode2023.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ElfCalibrationReader {

    List<CalibrationRecord> calibrationRecords = new ArrayList<>();
    public ElfCalibrationReader(BufferedReader bufferedReader){
        try{
            String line;
            while ((line = bufferedReader.readLine()) !=null){
                calibrationRecords.add(new CalibrationRecord(line));
            }
        }catch (IOException ioException){
            throw new RuntimeException(ioException);
        }
    }

    public int getCalibrationsSum() {
        return calibrationRecords.stream()
                .mapToInt(CalibrationRecord::getCalibrationValue)
                .sum();
    }
}
