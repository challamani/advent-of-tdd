package org.adventofcode2023.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EngineSchematicReaderService {

    private List<String> engineSchematicRecords = new ArrayList<>();
    Pattern pattern = Pattern.compile("[0-9]{1,3}");
    private List<PartNumber> partNumbers = new ArrayList<>();
    public EngineSchematicReaderService(BufferedReader bufferedReader) {
        try {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                engineSchematicRecords.add(line);
            }
        } catch (IOException ioException) {
            throw new RuntimeException(ioException);
        }
        int size = engineSchematicRecords.size();
        int length = engineSchematicRecords.get(0).length();
        AtomicInteger index = new AtomicInteger(0);
        engineSchematicRecords.stream().forEach(record -> {
            Matcher matcher = pattern.matcher(record);
            while (matcher.find()) {
                int partNumberValue = Integer.parseInt(matcher.group(0));
                int start = matcher.start(0);
                int end = matcher.end(0);

                boolean isAdjacentSymbolExists = false;
                int beginIndex = (start == 0) ? start : start - 1;
                int endIndex = (end == length) ? end : end + 1;
                if (index.get() != 0 && index.get() <= (size - 2)) {
                    isAdjacentSymbolExists = anyAdjacentSymbol(
                            beginIndex, endIndex, engineSchematicRecords.get(index.get() - 1),
                            engineSchematicRecords.get(index.get()),
                            engineSchematicRecords.get(index.get() + 1));
                } else if (index.get() == 0) {
                    isAdjacentSymbolExists = anyAdjacentSymbol(
                            beginIndex, endIndex, engineSchematicRecords.get(index.get() + 1),
                            engineSchematicRecords.get(index.get()));
                } else {
                    isAdjacentSymbolExists = anyAdjacentSymbol(
                            beginIndex, endIndex, engineSchematicRecords.get(index.get() - 1),
                            engineSchematicRecords.get(index.get()));
                }
                partNumbers.add(new PartNumber(partNumberValue, index.get(),
                        start, end, isAdjacentSymbolExists));
            }
            index.addAndGet(1);
        });
    }

    private boolean anyAdjacentSymbol(int start,int end,String...records) {
        boolean isSymbolExists = false;
        for (String record : records) {
            for (char ch : record.substring(start, end).toCharArray()) {
                if (ch != '.' && !(ch >= '0' && ch <= '9')) {
                    isSymbolExists = true;
                    break;
                }
            }
            if (isSymbolExists) {
                break;
            }
        }
        return isSymbolExists;
    }

    public long sumOfPartNumberValue() {
        return partNumbers.stream().filter(PartNumber::isAdjacentSymbolExists)
                .mapToInt(PartNumber::getValue).sum();
    }
}
