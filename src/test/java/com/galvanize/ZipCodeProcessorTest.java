package com.galvanize;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZipCodeProcessorTest {
    private ZipCodeProcessor processor;
    private Verifier verifier;

    @BeforeEach
    void setup(){
        verifier = new Verifier();
        processor = new ZipCodeProcessor(verifier);
    }
    // write your tests here
    @Test
    public void returnsZipCodeWrongLengthWhenZipIsTooLong(){
        assertEquals("The zip code you entered was the wrong length.", processor.process("232323232323"));
    }

    @Test
    public void returnsZipCodeWrongLengthWhenZipIsTooShort(){
        assertEquals("The zip code you entered was the wrong length.", processor.process("232"));
    }

    @Test
    public void returnsZipCodeOutOfRangeWhenZipStartsWithOne(){
        assertEquals("We're sorry, but the zip code you entered is out of our range.", processor.process("10232"));
    }

    @Test
    public void returnsPackageWillArriveWhenZipIsValid(){
        assertEquals("Thank you!  Your package will arrive soon.", processor.process("80302"));
    }


//    @Test
//    public void assertTrue() {
//        assertEquals(true, true);
//    }

}