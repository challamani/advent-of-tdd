package org.adventofcode2023.day2;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class TestCubeSetShould {

    @Test
    void match_the_green_cubes_count_with_the_value_that_are_given_in_instance_creation(){
        CubeSet cubeSet = new CubeSet(1,1,1);
        assertThat(cubeSet.getGreenCubes(),equalTo(1));
    }
    @Test
    void match_the_red_cubes_count_with_the_value_that_are_given_in_instance_creation(){
        CubeSet cubeSet = new CubeSet(1,1,1);
        assertThat(cubeSet.getRedCubes(),equalTo(1));
    }
    @Test
    void match_the_blue_cubes_count_with_the_value_that_are_given_in_instance_creation(){
        CubeSet cubeSet = new CubeSet(1,1,1);
        assertThat(cubeSet.getBlueCubes(),equalTo(1));
    }
}
