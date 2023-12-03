package org.adventofcode2023.day2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class CubeGameReaderSpike {

    public static void main(String[] args) {

        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("2023-day2-input.txt");
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(inputStream, StandardCharsets.UTF_8));

        CubeGameService cubeGameService = new CubeGameService(bufferedReader);
        CubeSet bagCapacity = new CubeSet(12, 13, 14);

        //System.out.println(cubeGameService.getGamesIdsSum(bagCapacity)); //2447
        System.out.println(cubeGameService.sumOfPowerOfCubeSets()); //56322
    }


}
