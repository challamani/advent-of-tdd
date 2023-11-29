package org.adventofcode2022.day1;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.hamcrest.number.OrderingComparison.lessThan;

public class TestElfShould {

    @Test
    void return_zero_total_calories_when_elf_created(){
        Elf elf = new Elf();
        assertThat(elf.getTotalCalories(), equalTo(0));
    }

    @Test
    void match_the_total_calories_with_added_calories(){
        int expected=1000;
        Elf elf = new Elf();
        elf.addCalories(expected);
        assertThat(elf.getTotalCalories(),equalTo(expected));
    }

    @Test
    void return_zero_when_compare_two_elf_instances_with_same_calories(){
        Elf elfOne = new Elf();
        elfOne.addCalories(100);
        Elf elfTwo = new Elf();
        elfTwo.addCalories(100);
        assertThat(elfOne.compareTo(elfTwo), equalTo(0));
    }

    @Test
    void return_positive_when_compare_with_the_less_calories_elf(){
        Elf elfOne = new Elf();
        elfOne.addCalories(100);
        Elf elfTwo = new Elf();
        elfTwo.addCalories(50);
        assertThat(elfOne.compareTo(elfTwo), greaterThan(0));
    }

    @Test
    void return_negative_when_compare_with_the_high_calories_elf(){
        Elf elfOne = new Elf();
        elfOne.addCalories(100);
        Elf elfTwo = new Elf();
        elfTwo.addCalories(500);
        assertThat(elfOne.compareTo(elfTwo), lessThan(0));
    }

    @Test
    void match_the_total_calories_with_added_calories_for_elf1(){
        Elf elfOne = new Elf();
        elfOne.addCalories(1000);
        elfOne.addCalories(2000);
        elfOne.addCalories(3000);
        assertThat(elfOne.getTotalCalories(),equalTo(6000));
    }
}
