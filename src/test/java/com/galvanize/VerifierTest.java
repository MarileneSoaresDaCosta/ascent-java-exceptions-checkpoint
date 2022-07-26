package com.galvanize;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VerifierTest {
    private Verifier verifier;

    @BeforeEach
    public void setVerifier() {
        verifier = new Verifier();
    }
    @Test
    public void itThrowsInvalidFormatExceptionWhenZipcodeIsTooLong(){
        InvalidFormatException e = assertThrows(InvalidFormatException.class, () -> verifier.verify("232323232323"));
        assertEquals("The zip code you entered was the wrong length.", e.getLocalizedMessage());
    }
}
