package com.pjmb.romantoint;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/romantoint")
class RomanToIntController {

    @GetMapping("/{romanNumber}")
    private ResponseEntity<RomanNumber> getIntegerFromRomanNumber(@PathVariable String romanNumber) {
        String input = romanNumber.trim();
        Integer output = RomanToInt.convertRomanNumber(input);
        RomanNumber result = new RomanNumber(input, output);
        return ResponseEntity.ok(result);
    }

}