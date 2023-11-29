package org.adventofcode2022.day1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.fail;

@ExtendWith(MockitoExtension.class)
public class TestElfCaloriesCounterShould {

    @Test
    void throw_npe_when_null_buffer_reader_is_given(){
        assertThrowsExactly(NullPointerException.class, ()->new ElfCaloriesCounter(null));
    }

    @Test
    void return_24000_max_calories_for_the_given_input(){
        InputStream inputStream =  Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("./day1-input.txt");

        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(inputStream, StandardCharsets.UTF_8));

    }

    @Test
    void return_24000_max_calories_for_the_given_input_stream(){
        fail("not yet implemented");
    }
}
