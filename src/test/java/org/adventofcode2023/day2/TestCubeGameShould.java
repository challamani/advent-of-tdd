package org.adventofcode2023.day2;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class TestCubeGameShould {

    @Test
    void return_the_game_id_that_must_match_with_creation_time_id() {
        CubeGame cubeGame = new CubeGame(100);
        assertThat(cubeGame.getId(), equalTo(100));
    }

    @Test
    void return_zero_cube_sets_size_on_cube_game_instance_created() {
        CubeGame cubeGame = new CubeGame(1);
        assertThat(cubeGame.getCubeSets().size(), equalTo(0));
    }

    @Test
    void return_one_cube_set_with_10_blue_cubes_when_blue_cubes_are_added_to_game_instance() {
        CubeGame cubeGame = new CubeGame(1);
        cubeGame.addCubeSet(new CubeSet(1, 1, 10));

        assertThat(cubeGame.getCubeSets().size(), equalTo(1));
        assertThat(cubeGame.getCubeSets().stream().findFirst()
                .orElse(new CubeSet(0, 0, 0))
                .getBlueCubes(), equalTo(10));
    }

    @Test
    void return_20_red_cubes_when_red_cubes_are_added_to_game_instance() {
        CubeGame cubeGame = new CubeGame(1);
        cubeGame.addCubeSet(new CubeSet(20, 1, 10));

        assertThat(cubeGame.getCubeSets().size(), equalTo(1));
        assertThat(cubeGame.getCubeSets().stream().findFirst()
                .orElse(new CubeSet(0, 0, 0))
                .getRedCubes(), equalTo(20));
    }

}