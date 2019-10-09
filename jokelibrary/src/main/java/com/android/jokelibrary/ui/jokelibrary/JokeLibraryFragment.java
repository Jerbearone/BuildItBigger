package com.android.jokelibrary.ui.jokelibrary;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.jokelibrary.R;

public class JokeLibraryFragment extends Fragment {
    private TextView jokeView;
    String jokeString;

    public static JokeLibraryFragment newInstance() {
        return new JokeLibraryFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.joke_library_fragment, container, false);

        //bundle for the joke button.
        Bundle jokeBundle = getArguments();
        jokeString = jokeBundle.getString("joke");
        jokeView = rootView.findViewById(R.id.joke_text);
        jokeView.setText(jokeString);


        return rootView;


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

}
