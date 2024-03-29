package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.android.jokelibrary.JokeLibraryActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;


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
                final String[] jokeString = new String[1];
                EndpointsAsyncTask theTask = new EndpointsAsyncTask(root.getContext()) {
                    @Override
                    protected void onPostExecute(String result) {
                        super.onPostExecute(result);
                        if (result != null) {
                            jokeString[0] = result;
                            Intent jokeToLibrary = new Intent(root.getContext(), JokeLibraryActivity.class);
                            jokeToLibrary.putExtra("jokeString", jokeString[0]);
                            root.getContext().startActivity(jokeToLibrary);
                        }
                        else {
                            Toast.makeText(root.getContext(), "Backend connection error", Toast.LENGTH_LONG);
                        }
                    }
                };
                theTask.execute();
            }
        });

        AdView mAdView = root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
        return root;
    }
}
