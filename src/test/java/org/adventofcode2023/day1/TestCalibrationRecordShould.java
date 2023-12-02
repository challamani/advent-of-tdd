package org.adventofcode2023.day1;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class TestCalibrationRecordShould {

    @Test
    void return_zero_value_when_empty_record_is_given_on_creation(){
        CalibrationRecord subject = new CalibrationRecord("");
        assertThat(subject.getCalibrationValue(),equalTo(0));
    }

    @Test
    void return_zero_value_when_null_record_is_given_on_creation(){
        CalibrationRecord subject = new CalibrationRecord(null);
        assertThat(subject.getCalibrationValue(),equalTo(0));
    }

    @Test
    void return_11_when_1AA0AB1_record_passed() {
        CalibrationRecord subject = new CalibrationRecord("1AA0AB1");
        assertThat(subject.getCalibrationValue(), equalTo(11));
    }

    @Test
    void return_zero_when_only_zeros_exists_in_input_record(){
        CalibrationRecord subject = new CalibrationRecord("0AA0AB0");
        assertThat(subject.getCalibrationValue(), equalTo(0));
    }

    @Test
    void return_zero_when_no_digits_found_in_the_given_calibration_record(){
        CalibrationRecord subject = new CalibrationRecord("aAAzABu");
        assertThat(subject.getCalibrationValue(), equalTo(0));
    }

    @Test
    void return_first_and_last_digits_when_more_than_two_digits_found_in_the_calibration_record(){
        CalibrationRecord subject = new CalibrationRecord("9aA8Az7ABu9z");
        assertThat(subject.getCalibrationValue(), equalTo(99));
    }

    @Test
    void return_87_when_digits_are_spelled_out_in_letters_and_sanity_disabled(){
        CalibrationRecord subject = new CalibrationRecord("nineaA8Az7ABuninez");
        assertThat(subject.getCalibrationValue(), equalTo(87));
    }

}
