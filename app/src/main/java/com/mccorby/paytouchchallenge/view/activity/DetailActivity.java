package com.mccorby.paytouchchallenge.view.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mccorby.paytouchchallenge.Constants;
import com.mccorby.paytouchchallenge.domain.paytouchchallenge.R;
import com.mccorby.paytouchchallenge.presentation.model.PresentationActor;
import com.mccorby.paytouchchallenge.view.fragment.ActorDetailFragment;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.action_toolbar);
        // Set the toolbar before adding the listener to the navigation icon!
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        if (savedInstanceState == null) {
            PresentationActor actor = getIntent().getExtras().getParcelable(Constants.ARG_ACTOR);
            if (actor == null) {
                actor = new PresentationActor();
            }
            Fragment fragment = new ActorDetailFragment();
            Bundle args = new Bundle();
            args.putParcelable(Constants.ARG_ACTOR, actor);
            fragment.setArguments(args);
            getFragmentManager().beginTransaction()
                    .add(R.id.container, fragment)
                    .commit();
        }
    }
}
