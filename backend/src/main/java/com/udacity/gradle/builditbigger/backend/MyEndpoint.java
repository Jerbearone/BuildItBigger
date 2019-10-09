package com.udacity.gradle.builditbigger.backend;

import com.android.javajokelibrary.JokingJoke;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    @ApiMethod(name = "tellJoke")
    public MyBean tellJoke() {
        MyBean response = new MyBean();
        String joke = getJoke();


        response.setData(joke);

        return response;
    }

    private String getJoke() {
        String theJoke = new JokingJoke().JokeReturn();
        return theJoke;

    }

}
