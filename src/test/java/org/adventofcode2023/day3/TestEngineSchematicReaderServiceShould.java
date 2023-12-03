package org.adventofcode2023.day3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.BufferedReader;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestEngineSchematicReaderServiceShould {

    @Test
    void throw_npe_when_null_buffered_reader_given_to_instance_creation() {
        assertThrowsExactly(NullPointerException.class, () -> new EngineSchematicReaderService(null));
    }

    @Test
    void throw_runtime_exception_when_buffered_reader_throws_ioe() throws IOException {
        BufferedReader mockedBufferedReader = mock(BufferedReader.class);
        when(mockedBufferedReader.readLine()).thenThrow(new IOException());
        assertThrowsExactly(RuntimeException.class, () -> new EngineSchematicReaderService(mockedBufferedReader));
    }

    @Test
    void return_4361l_as_sum_of_part_number_values_for_the_given_input() throws IOException {
        BufferedReader mockedBufferedReader = mock(BufferedReader.class);
        when(mockedBufferedReader.readLine())
                .thenReturn("467..114..")
                .thenReturn("...*......")
                .thenReturn("..35..633.")
                .thenReturn("......#...")
                .thenReturn("617*......")
                .thenReturn(".....+.58.")
                .thenReturn("..592.....")
                .thenReturn("......755.")
                .thenReturn("...$.*....")
                .thenReturn(".664.598..")
                .thenReturn(null);

        EngineSchematicReaderService engineSchematicReaderService = new EngineSchematicReaderService(mockedBufferedReader);
        assertThat(engineSchematicReaderService.sumOfPartNumberValue(),equalTo(4361l));
    }

    @Test
    void return_0l_as_sum_of_part_number_values_for_the_given_input() throws IOException {
        BufferedReader mockedBufferedReader = mock(BufferedReader.class);
        when(mockedBufferedReader.readLine())
                .thenReturn("467..114..")
                .thenReturn("..35..633.")
                .thenReturn("..592.....")
                .thenReturn("......755.")
                .thenReturn(".664.598..")
                .thenReturn(null);
        EngineSchematicReaderService engineSchematicReaderService = new EngineSchematicReaderService(mockedBufferedReader);
        assertThat(engineSchematicReaderService.sumOfPartNumberValue(),equalTo(0l));
    }

    @Test
    void return_1855L_as_sum_of_part_number_values_when_part_number_exists_in_the_edge_of_the_row() throws IOException {
        BufferedReader mockedBufferedReader = mock(BufferedReader.class);
        when(mockedBufferedReader.readLine())
                .thenReturn("467..114..")
                .thenReturn("$.35...633")
                .thenReturn("..592....%")
                .thenReturn(".......755")
                .thenReturn(null);
        EngineSchematicReaderService engineSchematicReaderService = new EngineSchematicReaderService(mockedBufferedReader);
        assertThat(engineSchematicReaderService.sumOfPartNumberValue(),equalTo(1855L));
    }
}
