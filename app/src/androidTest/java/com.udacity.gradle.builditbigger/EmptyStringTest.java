package com.udacity.gradle.builditbigger;

import android.content.Context;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Assert;
import org.junit.Test;


public class EmptyStringTest {

    @Test
    public void testAsyncTask() throws InterruptedException {

        Context context = InstrumentationRegistry.getInstrumentation().getContext();
        final String[] testNullString = new String[1];

        EndpointsAsyncTask testAsyncTask = new EndpointsAsyncTask(context) {
            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);
                testNullString[0] = result;
            }
        };

        testAsyncTask.execute();
        Thread.sleep(5000);
        try {
            Assert.assertNotNull(testNullString[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
