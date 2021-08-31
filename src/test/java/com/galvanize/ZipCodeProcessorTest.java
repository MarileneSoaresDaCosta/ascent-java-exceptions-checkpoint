package com.galvanize;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZipCodeProcessorTest {
    ZipCodeProcessor zipCodeProcessor;

    @BeforeEach
    void init() {
        zipCodeProcessor = new ZipCodeProcessor(new Verifier());
    }

    // write your tests here
    @Test
    public void processReturnsCorrectStringWhenZipCodeLengthIsCorrect() {
        assertEquals("Thank you!  Your package will arrive soon.", zipCodeProcessor.process("80302"));
    }

    @Test
    public void processReturnsWrongLengthStringWhenZipCodeIsNotCorrectLength() {
        assertEquals(
                "The zip code you entered was the wrong length.",
                zipCodeProcessor.process("2345678")
        );
        assertEquals(
                "The zip code you entered was the wrong length.",
                zipCodeProcessor.process("321")
        );
    }

    @Test
    public void processReturnsOutOfRangeStringWhenZipCodeIsOutOfRange() {
        assertEquals(
                "We're sorry, but the zip code you entered is out of our range.",
                zipCodeProcessor.process("12234")
        );
    }

}