package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.jokelibrary.JokeLibraryActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.udacity.gradle.builditbigger.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.R;

import java.util.concurrent.ExecutionException;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_main, container, false);
        MobileAds.initialize(root.getContext(), new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });

        Button jokeButton = root.findViewById(R.id.joke_button);


        //Intent to launch JokeJavaLibary activity.
        jokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EndpointsAsyncTask theTask = new EndpointsAsyncTask(root.getContext());
                theTask.execute();
                try {
                    String retrievedJokeString = theTask.get();
                    Intent jokeToLibrary = new Intent(root.getContext(), JokeLibraryActivity.class);
                    jokeToLibrary.putExtra("jokeString",retrievedJokeString);
                    root.getContext().startActivity(jokeToLibrary);
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        return root;
    }
}
