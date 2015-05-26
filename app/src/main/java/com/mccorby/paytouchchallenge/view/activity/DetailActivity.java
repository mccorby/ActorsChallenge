package com.mccorby.paytouchchallenge.view.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

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
        setSupportActionBar(toolbar);

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
