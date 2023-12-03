package org.adventofcode2023.day2;

public class CubeSet {
    private final int redCubes;
    private final int greenCubes;
    private final int blueCubes;
    public CubeSet(int redCubes, int greenCubes, int blueCubes) {
        this.redCubes = redCubes;
        this.greenCubes = greenCubes;
        this.blueCubes = blueCubes;
    }

    public int getRedCubes() {
        return redCubes;
    }

    public int getGreenCubes() {
        return greenCubes;
    }

    public int getBlueCubes() {
        return blueCubes;
    }
}
