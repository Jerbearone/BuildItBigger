package com.android.javajokelibrary;

import java.util.Random;

public class JokingJoke {

    public String JokeReturn() {

        final int x = new Random().nextInt(3);
        String theJoke = "wut";

        if (x == 0) {
            theJoke = getJoke();
        }
        else if (x == 1) {
            theJoke =  getJoke2();
        }

        else if (x == 2) {
            theJoke =  getJoke3();
        }
        return theJoke;
    }

    public String getJoke() {
        return "Why was eldery X able to cross the street? Because he was vari-able...";
    }

    private String getJoke2() {
        return "terminating a thousand roaches is nothing. Only those who sit at there computer " +
                "for hours at end know the meaning of \"debugging\".";
    }

    private String getJoke3() {
        return "software developers are amazing, but what's really amazing are those who created" +
                " Google without Google";
    }
}
