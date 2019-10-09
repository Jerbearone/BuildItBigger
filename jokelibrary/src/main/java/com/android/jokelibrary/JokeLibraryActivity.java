package com.android.jokelibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.android.jokelibrary.ui.jokelibrary.JokeLibraryFragment;

public class JokeLibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joke_library_activity);
        Intent jokeIntent = getIntent();
        String jokeString = jokeIntent.getStringExtra("jokeString");
        Bundle jokeBundle = new Bundle();
        jokeBundle.putString("joke", jokeString);

        JokeLibraryFragment jokeFragment = new JokeLibraryFragment();
        jokeFragment.setArguments(jokeBundle);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, jokeFragment)
                    .commitNow();
        }
    }
}
