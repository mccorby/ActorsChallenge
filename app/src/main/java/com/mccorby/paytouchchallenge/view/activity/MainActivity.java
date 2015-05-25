package com.mccorby.paytouchchallenge.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mccorby.paytouchchallenge.domain.paytouchchallenge.R;
import com.mccorby.paytouchchallenge.view.fragment.ActorsListFragment;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new ActorsListFragment())
                    .commit();
        }
    }
}
