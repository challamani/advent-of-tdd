package org.adventofcode2022.day1;

public class Elf implements Comparable<Elf>{

    private int totalCalories = 0;

    public void addCalories(int calories) {
        totalCalories += calories;
    }

    public int getTotalCalories(){
        return totalCalories;
    }

    @Override
    public int compareTo(Elf o) {
        return this.totalCalories - o.getTotalCalories();
    }
}
