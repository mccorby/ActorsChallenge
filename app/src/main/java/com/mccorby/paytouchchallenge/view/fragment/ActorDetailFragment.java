package com.mccorby.paytouchchallenge.view.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mccorby.paytouchchallenge.Constants;
import com.mccorby.paytouchchallenge.domain.paytouchchallenge.R;
import com.mccorby.paytouchchallenge.presentation.model.PresentationActor;
import com.mccorby.paytouchchallenge.view.adapter.WorkListAdapter;

/**
 *
 */
public class ActorDetailFragment extends Fragment {

    private static final String TAG = ActorDetailFragment.class.getSimpleName();
    private PresentationActor mActor;
    private WorkListAdapter mAdapter;

    public ActorDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        mActor = getArguments().getParcelable(Constants.ARG_ACTOR);

        Log.d(TAG, "Selected actor in detail fragment " + mActor.toString());

        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        buildUI(rootView);
        return rootView;
    }


    private void buildUI(View rootView) {
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.fragment_works_list_rv);
        // Use a linear layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new WorkListAdapter(getActivity(), mActor.getKnownFor());
        recyclerView.setAdapter(mAdapter);
        recyclerView.setHasFixedSize(true);

        TextView nameTv = (TextView) rootView.findViewById(R.id.detail_actor_name_tv);
        TextView locationTv = (TextView) rootView.findViewById(R.id.detail_actor_location_tv);
        TextView descriptionTv = (TextView) rootView.findViewById(R.id.detail_actor_description_tv);

        nameTv.setText(mActor.getName());
        locationTv.setText(mActor.getLocation());
        descriptionTv.setText(mActor.getDescription());

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

}
