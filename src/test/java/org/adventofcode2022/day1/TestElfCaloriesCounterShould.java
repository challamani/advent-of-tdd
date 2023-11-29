package org.adventofcode2022.day1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestElfCaloriesCounterShould {

    @Test
    void throw_npe_when_null_buffer_reader_is_given(){
        assertThrowsExactly(NullPointerException.class,
                ()->new ElfCaloriesCounter(null));
    }

    @Test
    void return_24000_max_calories_for_the_given_input(){
        InputStream inputStream =  Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("./day1-input.txt");

        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        ElfCaloriesCounter elfCaloriesCounter = new ElfCaloriesCounter(bufferedReader);
        assertThat(elfCaloriesCounter.maxCalories(),equalTo(24000));
    }

    @Test
    void throw_runtime_exception_when_buffer_reader_throws_ioexception() throws IOException {
        BufferedReader bufferedReader = mock(BufferedReader.class);
        when(bufferedReader.readLine())
                .thenThrow(new IOException());
        assertThrowsExactly(RuntimeException.class,()->new ElfCaloriesCounter(bufferedReader));
    }

    @Test
    void return_10000_max_calories_for_the_given_input() throws IOException {
        BufferedReader bufferedReader = mock(BufferedReader.class);
        when(bufferedReader.readLine())
                .thenReturn("1000")
                .thenReturn("500")
                .thenReturn("")
                .thenReturn("10000")
                .thenReturn("")
                .thenReturn("300")
                .thenReturn("500")
                .thenReturn(null);
        ElfCaloriesCounter elfCaloriesCounter =  new ElfCaloriesCounter(bufferedReader);
        assertThat(elfCaloriesCounter.maxCalories(), equalTo(10000));
    }
}
