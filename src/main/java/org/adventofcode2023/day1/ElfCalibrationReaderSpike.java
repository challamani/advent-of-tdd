package org.adventofcode2023.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
public class ElfCalibrationReaderSpike {

    public static void main(String[] args) throws IOException {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try(InputStream inputStream = classLoader.getResourceAsStream("./2023-day1-input.txt")){
            BufferedReader bufferedReader  = new BufferedReader(
                    new InputStreamReader(inputStream, StandardCharsets.UTF_8)
            );
            //System.out.println(">>> part 1 "+part1(bufferedReader)); //part-1, 54573
            System.out.println(">>> part 2 :"+part2(bufferedReader)); //part-2, 54591
        }
    }

    private static int part1(BufferedReader bufferedReader){
        ElfCalibrationReader elfCalibrationReader =
                new ElfCalibrationReader(bufferedReader, false);
        return elfCalibrationReader.getCalibrationsSum();
    }

    private static int part2(BufferedReader bufferedReader){
        ElfCalibrationReader elfCalibrationReader =
                new ElfCalibrationReader(bufferedReader, true);
        return elfCalibrationReader.getCalibrationsSum();
    }

}
