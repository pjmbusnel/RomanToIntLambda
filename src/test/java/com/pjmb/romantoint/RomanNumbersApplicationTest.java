package com.pjmb.romantoint;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RomanNumbersApplicationTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void shouldConvertRomanNumberToInteger_Test() {
        ResponseEntity<String> response = restTemplate
                .getForEntity("/romantoint/MMXXIV", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        DocumentContext documentContext = JsonPath.parse(response.getBody());
        Integer output = documentContext.read("$.intValue");
        assertThat(output).isEqualTo(2024);

        String roman = documentContext.read("$.romanNumber");
        assertThat(roman).isEqualTo("MMXXIV");
    }

    @Test
    void shouldNotConvertRomanNumberWhenInputIsInvalid_Test() {
        ResponseEntity<String> response = restTemplate
                .getForEntity("/romantoint/MqMXwXeIV", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        DocumentContext documentContext = JsonPath.parse(response.getBody());
        Integer output = documentContext.read("$.intValue");
        assertThat(output).isEqualTo(0);
    }

    @Test
    void shouldConvertIntegerToRomanNumber_Test() {
        ResponseEntity<String> response = restTemplate
                .getForEntity("/integertoroman/2024", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        DocumentContext documentContext = JsonPath.parse(response.getBody());
        Integer output = documentContext.read("$.intValue");
        assertThat(output).isEqualTo(2024);

        String roman = documentContext.read("$.romanNumber");
        assertThat(roman).isEqualTo("MMXXIV");
    }

    @Test
    void shouldNotConvertIntegerToRomanNumberWhenInputIsInvalid_Test() {
        // TODO Modify getRomanNumberFromInteger to handle error properly
        ResponseEntity<String> response = restTemplate
                .getForEntity("/integertoroman/MqMXwXeIV", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}