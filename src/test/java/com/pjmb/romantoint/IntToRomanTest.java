package com.pjmb.romantoint;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IntToRomanTest {

    @Test
    void convertIntegerToRomanNumber_Test() {
        assertThat(IntToRoman.convertIntegerToRomanNumber(0)).isEqualTo("");
        assertThat(IntToRoman.convertIntegerToRomanNumber(-1)).isEqualTo("");

        assertThat(IntToRoman.convertIntegerToRomanNumber(947)).isEqualTo("CMXLVII");
        assertThat(IntToRoman.convertIntegerToRomanNumber(2024)).isEqualTo("MMXXIV");
    }
}