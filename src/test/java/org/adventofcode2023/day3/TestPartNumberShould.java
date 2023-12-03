package org.adventofcode2023.day3;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class TestPartNumberShould {

    @Test
    void have_valid_part_number_value_on_created() {
        PartNumber subject = new PartNumber(100, 1, 0, 2, true);
        assertThat(subject.getValue(), equalTo(100));
        assertThat(subject.isAdjacentSymbolExists(), equalTo(true));
        assertThat(subject.getRow(), equalTo(1));
        assertThat(subject.getStartIndex(), equalTo(0));
        assertThat(subject.getEndIndex(), equalTo(2));
    }
}
