package org.adventofcode2023.day1;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestElfCalibrationReaderShould {

    /*
        Advent of Code 2023 -
        https://adventofcode.com/2023/day/1
     * **/
    @Test
    void return_zero_calibration_sum_on_empty_buffered_reader_in_creation() throws IOException {
        BufferedReader mockeBufferedReader = mock(BufferedReader.class);
        when(mockeBufferedReader.readLine())
                .thenReturn("")
                .thenReturn(null);

        ElfCalibrationReader elfCalibrationReader = new ElfCalibrationReader(mockeBufferedReader);
        assertThat(elfCalibrationReader.getCalibrationsSum(),equalTo(0));
    }
    @Test
    void throw_npe_when_null_buffered_reader_is_given(){
        assertThrowsExactly(NullPointerException.class,()->new ElfCalibrationReader(null));
    }
    @Test
    void throw_runtime_exception_when_buffered_reader_throws_ioe() throws IOException {
        BufferedReader mockeBufferedReader = mock(BufferedReader.class);
        when(mockeBufferedReader.readLine())
                .thenThrow(new IOException());
        assertThrowsExactly(RuntimeException.class, () -> new ElfCalibrationReader(mockeBufferedReader));
    }

    @Test
    void return_50_as_calibration_sum_for_the_given_input() throws IOException {
        BufferedReader mockeBufferedReader = mock(BufferedReader.class);
        when(mockeBufferedReader.readLine())
                .thenReturn("1aaa0bbb")
                .thenReturn("2aaa0bbb5y")
                .thenReturn("1aaa0bbb5y")
                .thenReturn(null);
        ElfCalibrationReader elfCalibrationReader = new ElfCalibrationReader(mockeBufferedReader);
        assertThat(elfCalibrationReader.getCalibrationsSum(),
                equalTo(50));
    }

    @Test
    void return_142_as_calibration_sum_for_the_given_buffered_reader() {

        InputStream inputStream = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream("./2023-day1-input.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        ElfCalibrationReader elfCalibrationReader = new ElfCalibrationReader(bufferedReader);
        assertThat(elfCalibrationReader.getCalibrationsSum(),
                equalTo(142));
    }

}
