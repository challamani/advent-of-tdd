package org.adventofcode2023.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CalibrationRecord {

    private final String record;
    private final int calibrationValue;
    public CalibrationRecord(String record){
        this.record = record;
        calibrationValue = getValue();
    }
    private int getValue(){
        int value=0;
        if(this.record !=null && !this.record.isBlank()) {
            Pattern pattern = Pattern.compile("([0-9]{1}+)");
            List<Integer> digits = new ArrayList<>();
            pattern.matcher(record)
                    .results().forEach(matchResult ->
                            digits.add(Integer.valueOf(matchResult.group(0))));
            if(digits.size() > 0) {
                value = digits.get(0) * 10 + digits.get(digits.size() - 1);
            }
        }
        return value;
    }

    public int getCalibrationValue(){
        return calibrationValue;
    }
}
