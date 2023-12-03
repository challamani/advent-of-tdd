package org.adventofcode2023.day2;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class TestCubeGameShould {

    @Test
    void return_the_game_id_that_must_match_with_creation_time_id(){
        CubeGame cubeGame = new CubeGame(100);
        assertThat(cubeGame.getId(),equalTo(100));
    }

    @Test
    void return_zero_green_cubes_on_cube_game_instance_created(){
        CubeGame cubeGame = new CubeGame(1);
        assertThat(cubeGame.getGreenCubes(),equalTo(0));
    }

    @Test
    void return_zero_red_cubes_on_cube_game_instance_created(){
        CubeGame cubeGame = new CubeGame(1);
        assertThat(cubeGame.getRedCubes(),equalTo(0));
    }

    @Test
    void return_zero_blue_cubes_on_cube_game_instance_created(){
        CubeGame cubeGame = new CubeGame(1);
        assertThat(cubeGame.getBlueCubes(),equalTo(0));
    }

    @Test
    void return_10_blue_cubes_when_blue_cubes_are_added_to_game_instance(){
        CubeGame cubeGame = new CubeGame(1);
        cubeGame.addBlueCubes(10);
        assertThat(cubeGame.getBlueCubes(),equalTo(10));
    }

    @Test
    void return_20_red_cubes_when_red_cubes_are_added_to_game_instance(){
        CubeGame cubeGame = new CubeGame(1);
        cubeGame.addRedCubes(20);
        assertThat(cubeGame.getRedCubes(),equalTo(20));
    }

    @Test
    void return_30_green_cubes_when_green_cubes_are_added_to_game_instance(){
        CubeGame cubeGame = new CubeGame(1);
        cubeGame.addGreenCubes(30);
        assertThat(cubeGame.getGreenCubes(),equalTo(30));
    }

}