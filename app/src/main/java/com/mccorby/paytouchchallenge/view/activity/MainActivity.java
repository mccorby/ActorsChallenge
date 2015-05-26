package com.mccorby.paytouchchallenge.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.mccorby.paytouchchallenge.domain.paytouchchallenge.R;
import com.mccorby.paytouchchallenge.view.fragment.ActorsListFragment;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    private ActorsListFragment mListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.action_toolbar);
        toolbar.setTitle("");

        toolbar.setLogo(R.mipmap.paytouch);

        Spinner spinner = (Spinner) findViewById(R.id.spinner_nav);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.sort_options_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        setSupportActionBar(toolbar);

        if (savedInstanceState == null) {
            mListFragment = new ActorsListFragment();
            getFragmentManager().beginTransaction()
                    .add(R.id.container, mListFragment)
                    .commit();
        }
    }

    @Override

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        mListFragment.sortList(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
