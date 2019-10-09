package com.udacity.gradle.builditbigger;

import android.content.Context;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
public class EmptyStringTest {

    @Test
    public void testAsyncTask() throws InterruptedException {

        Context context = InstrumentationRegistry.getInstrumentation().getContext();
        String testNullString = null;
        EndpointsAsyncTask testAsyncTask = new EndpointsAsyncTask(context);
        testAsyncTask.execute();
        Thread.sleep(5000);
        try {
            testNullString = testAsyncTask.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertNotNull(testNullString);

    }
}
