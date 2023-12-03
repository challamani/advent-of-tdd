package org.adventofcode2023.day2;

public class CubeGame {

    private int greenCubes = 0;
    private int redCubes = 0;
    private int blueCubes = 0;
    private final int id;
    public CubeGame(int gameId){
        this.id = gameId;
    }

    public void addGreenCubes(int noOfCubes){
        greenCubes += noOfCubes;
    }

    public void addRedCubes(int noOfCubes){
        redCubes += noOfCubes;
    }

    public void addBlueCubes(int noOfCubes){
        blueCubes += noOfCubes;
    }

    public int getGreenCubes() {
        return greenCubes;
    }

    public int getRedCubes() {
        return redCubes;
    }

    public int getBlueCubes() {
        return blueCubes;
    }

    public int getId() {
        return id;
    }
}
