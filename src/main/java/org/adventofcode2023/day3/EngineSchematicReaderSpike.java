package org.adventofcode2023.day3;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class EngineSchematicReaderSpike {

    public static void main(String[] args)  {

        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("2023-day3-input.txt");
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(inputStream, StandardCharsets.UTF_8));

        EngineSchematicReaderService engineSchematicReaderService = new EngineSchematicReaderService(bufferedReader);
        System.out.println(engineSchematicReaderService.sumOfPartNumberValue()); //540131
    }

}
