package org.adventofcode2022.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class ElfCaloriesReaderSpike {

    public static void main(String[] args) throws IOException {

        List<Elf> elfList = new ArrayList<>();
        ClassLoader classLoader =  Thread.currentThread().getContextClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream("./2022-day1-input.txt")) {
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(inputStream, StandardCharsets.UTF_8));

            String line;
            Elf elf = new Elf();
            elfList.add(elf);
            while ( (line = bufferedReader.readLine()) !=null){
                if(line.isBlank()){
                    elf = new Elf();
                    elfList.add(elf);
                }else{
                    elf.addCalories(Integer.parseInt(line));
                }
            }
        }

        elfList.forEach(elf -> System.out.println(elf.getTotalCalories()));
    }
}
