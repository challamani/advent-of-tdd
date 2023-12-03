package org.adventofcode2023.day3;

public class PartNumber {

    private final int value;
    private final int startIndex;
    private final int endIndex;
    private final int row;
    private final boolean isAdjacentSymbolExists;

    public PartNumber(int value, int row, int startIndex, int endIndex
    ,boolean anyAdjacentSymbolExists) {
        this.value = value;
        this.row = row;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.isAdjacentSymbolExists = anyAdjacentSymbolExists;
    }

    public int getValue() {
        return value;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public int getRow() {
        return row;
    }

    public boolean isAdjacentSymbolExists() {
        return isAdjacentSymbolExists;
    }
}
