package com.galvanize;

public class ZipCodeProcessor {

    // don't alter this code...
    private final Verifier verifier;

    public ZipCodeProcessor(Verifier verifier) {
        this.verifier = verifier;
    }

    // write your code below here...
    public String process(String zipcode) {
        try {
            this.verifier.verify(zipcode);
        } catch (Exception e) {
            return (e.getMessage().equals("ERRCODE 21: INPUT_TOO_LONG") || e.getMessage().equals("ERRCODE 22: INPUT_TOO_SHORT")) ?
                    "The zip code you entered was the wrong length." :
                    (e.getMessage().equals("ERRCODE 27: NO_SERVICE")) ?
                            "We're sorry, but the zip code you entered is out of our range." :
                            "We're sorry, but there was an unknown exception.";
        }
        return "Thank you!  Your package will arrive soon.";

    }

}