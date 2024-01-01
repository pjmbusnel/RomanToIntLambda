package com.pjmb.romantoint;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/integertoroman")
class IntToRomanController {

    @GetMapping("/{integerNumber}")
    private ResponseEntity<RomanNumber> getRomanNumberFromInteger(@PathVariable String integerNumber) {
        // TODO catch error if integerNumber cant be converted to Integer and return error in Response
        Integer input = Integer.valueOf(integerNumber);
        String output = IntToRoman.convertIntegerToRomanNumber(input);
        RomanNumber result = new RomanNumber(output, input);
        return ResponseEntity.ok(result);
    }

}