package com.pjmb.romantoint;

import java.util.HashMap;
import java.util.Map;

public class IntToRoman {

    private static int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    private static String[] romanLetters = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    public static String convertIntegerToRomanNumber(int num) {
        StringBuilder roman = new StringBuilder();
        for(int i=0;i<values.length;i++) {
            while(num >= values[i]) {
                num = num - values[i];
                roman.append(romanLetters[i]);
            }
        }
        return roman.toString();
    }

}
