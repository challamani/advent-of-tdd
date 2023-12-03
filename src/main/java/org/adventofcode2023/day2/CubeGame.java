package org.adventofcode2023.day2;

import java.util.ArrayList;
import java.util.List;

public class CubeGame {

    private final List<CubeSet> cubeSets;
    private final int id;
    public CubeGame(int gameId){
        this.id = gameId;
        this.cubeSets = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public List<CubeSet> getCubeSets() {
        return cubeSets;
    }
    public void addCubeSet(CubeSet cubeSet){
        this.cubeSets.add(cubeSet);
    }
}
