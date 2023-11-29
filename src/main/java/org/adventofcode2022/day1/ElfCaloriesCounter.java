package org.adventofcode2022.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ElfCaloriesCounter {

    private List<Elf> elfList = new ArrayList<>();

    public ElfCaloriesCounter(BufferedReader bufferedReader) throws IOException {
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
}
