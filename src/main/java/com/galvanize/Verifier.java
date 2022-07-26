package com.galvanize;

public class Verifier {

    public void verify(final String zipCode) throws Exception {
        if (zipCode.length() > 5) {
            throw new InvalidFormatException("The zip code you entered was the wrong length.");
        }
        if (zipCode.length() < 5) {
            throw new InvalidFormatException("The zip code you entered was the wrong length.");
        }
        if (zipCode.matches("^1[\\d]+$")) {
            throw new NoServiceException("We're sorry, but the zip code you entered is out of our range.");
        }
    }

}
