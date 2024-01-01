package com.pjmb.romantoint;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RomanToIntTest {

    @Test
    void convertRomanNumber_Test() {
        assertThat(RomanToInt.convertRomanNumber("")).isEqualTo(0);
        assertThat(RomanToInt.convertRomanNumber(null)).isEqualTo(0);
        assertThat(RomanToInt.convertRomanNumber("abc")).isEqualTo(0);

        assertThat(RomanToInt.convertRomanNumber("i")).isEqualTo(1);
        assertThat(RomanToInt.convertRomanNumber("v")).isEqualTo(5);
        assertThat(RomanToInt.convertRomanNumber("x")).isEqualTo(10);
        assertThat(RomanToInt.convertRomanNumber("l")).isEqualTo(50);
        assertThat(RomanToInt.convertRomanNumber("c")).isEqualTo(100);
        assertThat(RomanToInt.convertRomanNumber("d")).isEqualTo(500);
        assertThat(RomanToInt.convertRomanNumber("m")).isEqualTo(1000);

        assertThat(RomanToInt.convertRomanNumber("IV")).isEqualTo(4);
        assertThat(RomanToInt.convertRomanNumber("CMXLVII")).isEqualTo(947);
        assertThat(RomanToInt.convertRomanNumber("cMxLvIi")).isEqualTo(947);
        assertThat(RomanToInt.convertRomanNumber("  CMXLVII  ")).isEqualTo(947);
        assertThat(RomanToInt.convertRomanNumber("MMXXIV")).isEqualTo(2024);
    }
}