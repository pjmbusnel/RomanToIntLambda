package com.pjmb.romantoint;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

    private static Map<Character, Integer> romanNumbersValues = new HashMap<>();
    static {
        romanNumbersValues.put('I', 1);
        romanNumbersValues.put('V', 5);
        romanNumbersValues.put('X', 10);
        romanNumbersValues.put('L', 50);
        romanNumbersValues.put('C', 100);
        romanNumbersValues.put('D', 500);
        romanNumbersValues.put('M', 1000);
    }

    public static Integer convertRomanNumber(String romanNumber) {
        if (romanNumber == null || romanNumber.isEmpty())
            return 0;

        romanNumber = romanNumber.trim().toUpperCase();
        if (!validateRomanNumberString(romanNumber))
            return 0;

        int number = 0;

        for (int i = romanNumber.length() - 1; i >= 0; i--) {
            int currValue = romanNumbersValues.get(romanNumber.charAt(i));

            if (i < romanNumber.length() - 1 && currValue < romanNumbersValues.get(romanNumber.charAt(i + 1))) {
                number -= currValue;
            } else {
                number += currValue;
            }
        }

        return number;
    }

    private static boolean validateRomanNumberString(String romanNumberStr) {
        String tempStr = romanNumberStr
                .replaceAll("I","")
                .replaceAll("V","")
                .replaceAll("X","")
                .replaceAll("L","")
                .replaceAll("C","")
                .replaceAll("D","")
                .replaceAll("M","");

        if (tempStr.isEmpty())
            return true;

        return false;
    }
}
