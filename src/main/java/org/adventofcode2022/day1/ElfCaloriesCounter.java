package org.adventofcode2022.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class ElfCaloriesCounter {

    private List<Elf> elfList = new ArrayList<>();

    public ElfCaloriesCounter(BufferedReader bufferedReader) {
        String line;
        Elf elf = new Elf();
        elfList.add(elf);
        try {
            while ((line = bufferedReader.readLine()) != null) {
                if (line.isBlank()) {
                    elf = new Elf();
                    elfList.add(elf);
                } else {
                    elf.addCalories(Integer.parseInt(line));
                }
            }
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
    }

    public int maxCalories(){
        return elfList.stream()
                .max(Elf::compareTo)
                .get()
                .getTotalCalories();
    }
}
