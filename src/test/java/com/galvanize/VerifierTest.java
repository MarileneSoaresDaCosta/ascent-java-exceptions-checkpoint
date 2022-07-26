package com.galvanize;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.NotSerializableException;

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
        assertEquals("ERRCODE 21: INPUT_TOO_LONG", e.getMessage());
    }

    @Test
    public void itThrowsInvalidFormatExceptionWhenZipcodeIsTooShort(){
        InvalidFormatException e = assertThrows(InvalidFormatException.class, () -> verifier.verify("232"));
        assertEquals("ERRCODE 22: INPUT_TOO_SHORT", e.getMessage());
    }

    @Test
    public void itThrowsNoServiceExceptionWhenZipcodeStartsWithOne(){
        NoServiceException e = assertThrows(NoServiceException.class, () -> verifier.verify("10232"));
        assertEquals("ERRCODE 27: NO_SERVICE", e.getMessage());
    }

}
