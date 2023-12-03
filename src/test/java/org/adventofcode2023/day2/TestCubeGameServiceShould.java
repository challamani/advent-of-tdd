package org.adventofcode2023.day2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestCubeGameServiceShould {

    @Test
    void throw_npe_when_null_buffered_reader_given_as_input(){
        assertThrowsExactly(NullPointerException.class,() -> new CubeGameService(null));
    }

    @Test
    void throw_runtime_exception_when_reader_throws_ioe() throws IOException {
        BufferedReader mockBufferedReader = mock(BufferedReader.class);
        when(mockBufferedReader.readLine())
                .thenThrow(new IOException());
        assertThrowsExactly(RuntimeException.class,() -> new CubeGameService(mockBufferedReader));
    }

    @Test
    void return_zero_as_sum_of_games_ids_for_the_given_game_set_and_bag_capacity() throws IOException {
        BufferedReader mockBufferedReader = mock(BufferedReader.class);
        CubeSet mockedCubeSet = mock(CubeSet.class);

        when(mockBufferedReader.readLine())
                .thenReturn("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green")
                .thenReturn(null);

        when(mockedCubeSet.getGreenCubes()).thenReturn(4);
        when(mockedCubeSet.getRedCubes()).thenReturn(5);
        when(mockedCubeSet.getBlueCubes()).thenReturn(1);

        CubeGameService cubeGameService = new CubeGameService(mockBufferedReader);
        assertThat(cubeGameService.getGamesIdsSum(mockedCubeSet), equalTo(0));
    }

    @Test
    void return_8_as_game_ids_sum_for_the_given_input() throws IOException {
        BufferedReader mockBufferedReader = mock(BufferedReader.class);
        CubeSet mockedCubeSet = mock(CubeSet.class);

        when(mockBufferedReader.readLine())
                .thenReturn("Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green")
                .thenReturn("Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue")
                .thenReturn("Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red")
                .thenReturn("Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red")
                .thenReturn("Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green")
                .thenReturn(null);

        when(mockedCubeSet.getGreenCubes()).thenReturn(13);
        when(mockedCubeSet.getBlueCubes()).thenReturn(14);
        when(mockedCubeSet.getRedCubes()).thenReturn(12);

        CubeGameService cubeGameService = new CubeGameService(mockBufferedReader);
        assertThat(cubeGameService.getGamesIdsSum(mockedCubeSet), equalTo(8));
    }

    @Test
    void return_8_as_game_ids_sum_for_for_the_given_buffered_reader(){
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("2023-day2-input.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        CubeSet mockedCubeSet = mock(CubeSet.class);
        when(mockedCubeSet.getGreenCubes()).thenReturn(13);
        when(mockedCubeSet.getBlueCubes()).thenReturn(14);
        when(mockedCubeSet.getRedCubes()).thenReturn(12);
        CubeGameService cubeGameService = new CubeGameService(bufferedReader);
        assertThat(cubeGameService.getGamesIdsSum(mockedCubeSet), equalTo(8));
    }

    @Test
    void return_10_sum_of_game_ids_when_cubes_bag_capacity_matching_for_all_games() throws IOException {
        BufferedReader mockBufferedReader = mock(BufferedReader.class);
        when(mockBufferedReader.readLine())
                .thenReturn("Game 1: 3 blue, 4 red; 2 red, 2 green, 6 blue; 2 green")
                .thenReturn("Game 9: 3 blue, 4 red; 2 red, 2 green, 6 blue; 2 green")
                .thenReturn(null);

        CubeSet mockedBagCapacity = mock(CubeSet.class);
        when(mockedBagCapacity.getGreenCubes()).thenReturn(90);
        when(mockedBagCapacity.getRedCubes()).thenReturn(90);
        when(mockedBagCapacity.getBlueCubes()).thenReturn(90);

        CubeGameService cubeGameService = new CubeGameService(mockBufferedReader);
        assertThat(cubeGameService.getGamesIdsSum(mockedBagCapacity), equalTo(10));
    }

    @Test
    void return_zero_sum_of_game_ids_when_bag_capacity_problem_with_green_cubes() throws IOException {
        BufferedReader mockBufferedReader = mock(BufferedReader.class);
        when(mockBufferedReader.readLine())
                .thenReturn("Game 1: 3 blue, 4 red, 2 green; 2 red, 2 green, 6 blue; 2 green")
                .thenReturn(null);

        CubeSet  mockedBagCapacity = mock(CubeSet.class);
        when(mockedBagCapacity.getGreenCubes()).thenReturn(0);
        CubeGameService cubeGameService = new CubeGameService(mockBufferedReader);
        assertThat(cubeGameService.getGamesIdsSum(mockedBagCapacity), equalTo(0));
    }

    @Test
    void return_zero_sum_of_game_ids_when_bag_capacity_problem_with_red_cubes() throws IOException {
        BufferedReader mockBufferedReader = mock(BufferedReader.class);
        when(mockBufferedReader.readLine())
                .thenReturn("Game 1: 1 blue, 1 red; 1 red, 1 green, 1 blue; 1 green")
                .thenReturn(null);

        CubeSet  mockedBagCapacity = mock(CubeSet.class);
        when(mockedBagCapacity.getGreenCubes()).thenReturn(90);
        when(mockedBagCapacity.getRedCubes()).thenReturn(0);
        CubeGameService cubeGameService = new CubeGameService(mockBufferedReader);
        assertThat(cubeGameService.getGamesIdsSum(mockedBagCapacity), equalTo(0));
    }

    @Test
    void return_zero_sum_of_game_ids_when_bag_capacity_problem_with_blue_cubes() throws IOException {
        BufferedReader mockBufferedReader = mock(BufferedReader.class);
        when(mockBufferedReader.readLine())
                .thenReturn("Game 1: 1 blue, 1 red; 1 red, 1 green, 1 blue; 1 green")
                .thenReturn(null);

        CubeSet  mockedBagCapacity = mock(CubeSet.class);
        when(mockedBagCapacity.getGreenCubes()).thenReturn(90);
        when(mockedBagCapacity.getRedCubes()).thenReturn(90);
        when(mockedBagCapacity.getBlueCubes()).thenReturn(0);
        CubeGameService cubeGameService = new CubeGameService(mockBufferedReader);
        assertThat(cubeGameService.getGamesIdsSum(mockedBagCapacity), equalTo(0));
    }

    @Test
    void return_4_as_sum_of_game_ids_when_unexpected_cube_encountered_in_input() throws IOException {
        BufferedReader mockBufferedReader = mock(BufferedReader.class);
        when(mockBufferedReader.readLine())
                .thenReturn("Game 1: 3 blue, 4 red; 2 red, 2 green, 6 blue; 2 green, 2 black")
                .thenReturn("Game 2: 3 blue, 4 red; 2 red, 2 green, 6 blue; 2 green, 1 white")
                .thenReturn("Game 1: 3 blue, 4 red; 2 red, 2 green, 6 blue; 2 green, 3 brown")
                .thenReturn(null);

        CubeSet mockedBagCapacity = mock(CubeSet.class);
        when(mockedBagCapacity.getGreenCubes()).thenReturn(9);
        when(mockedBagCapacity.getRedCubes()).thenReturn(9);
        when(mockedBagCapacity.getBlueCubes()).thenReturn(9);

        CubeGameService cubeGameService = new CubeGameService(mockBufferedReader);
        assertThat(cubeGameService.getGamesIdsSum(mockedBagCapacity), equalTo(4));
    }
}
