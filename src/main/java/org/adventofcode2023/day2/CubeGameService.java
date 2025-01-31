package org.adventofcode2023.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class CubeGameService {
    private List<CubeGame> cubeGames = new ArrayList<>();
    /**
     * Problem statement https://adventofcode.com/2023/day/2
     * */
    public CubeGameService(BufferedReader bufferedReader) {
        try {

            String line;
            String colonDelimiter = ":";
            String singleSpaceDelimiter = " ";
            String semiColonDelimiter = ";";
            String commaDelimiter = ",";

            while ((line = bufferedReader.readLine()) != null) {
                String[] gameIdAndCubeSets = line.split(colonDelimiter);
                String[] gameLabelAndId = gameIdAndCubeSets[0]
                        .split(singleSpaceDelimiter);

                int gameId = Integer.parseInt(gameLabelAndId[1]);
                CubeGame cubeGame = new CubeGame(gameId);
                cubeGames.add(cubeGame);

                Arrays.stream(gameIdAndCubeSets[1].trim().split(semiColonDelimiter))
                        .forEach(cubeGameSet -> {
                            AtomicInteger redCubes = new AtomicInteger(0);
                            AtomicInteger blueCubes = new AtomicInteger(0);
                            AtomicInteger greenCubes = new AtomicInteger(0);

                            Arrays.stream(cubeGameSet.trim().split(commaDelimiter))
                                    .forEach(cubeRecord -> {
                                        String[] cubeAndCount = cubeRecord.trim().split(singleSpaceDelimiter);
                                        int count = Integer.parseInt(cubeAndCount[0].trim());
                                        switch (cubeAndCount[1].trim()) {
                                            case "red" -> redCubes.set(count);
                                            case "green" -> greenCubes.set(count);
                                            case "blue" -> blueCubes.set(count);
                                        }
                                    });
                            cubeGame.addCubeSet(new CubeSet(redCubes.get(), greenCubes.get(), blueCubes.get()));
                        });
            }
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
    }

    public int getGamesIdsSum(CubeSet bagCapacity) {
        return cubeGames.stream()
                .filter(cubeGame ->
                        cubeGame.getCubeSets().stream().allMatch(cubeSet ->
                                (bagCapacity.getGreenCubes() >= cubeSet.getGreenCubes()
                                        && bagCapacity.getRedCubes() >= cubeSet.getRedCubes()
                                        && bagCapacity.getBlueCubes() >= cubeSet.getBlueCubes())))
                .mapToInt(CubeGame::getId)
                .sum();
    }

    /**
     * what is the fewest number of cubes of each color that could have been in the bag to make the game possible
     * Find the max cubes in each game sets
     * Calculate the sum of the power of those sets
     * */
    public long sumOfPowerOfCubeSets() {
        AtomicLong sumOfPowerOfCubeSets = new AtomicLong();
        cubeGames.stream()
                .forEach(cubeGame -> {
                    int maxRedCubes = cubeGame.getCubeSets().stream().mapToInt(CubeSet::getRedCubes)
                            .max().orElse(1);
                    int maxGreenCubes = cubeGame.getCubeSets().stream().mapToInt(CubeSet::getGreenCubes)
                            .max().orElse(1);
                    int maxBlueCubes = cubeGame.getCubeSets().stream().mapToInt(CubeSet::getBlueCubes)
                            .max().orElse(1);

                    sumOfPowerOfCubeSets.addAndGet(((long) maxRedCubes * maxGreenCubes * maxBlueCubes));
                });

        return sumOfPowerOfCubeSets.get();
    }
}