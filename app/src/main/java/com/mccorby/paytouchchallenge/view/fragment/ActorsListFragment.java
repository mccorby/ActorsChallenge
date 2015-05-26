package com.mccorby.paytouchchallenge.view.fragment;


import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mccorby.paytouchchallenge.Constants;
import com.mccorby.paytouchchallenge.datasource.api.ActorsApiService;
import com.mccorby.paytouchchallenge.datasource.api.NetworkDatasourceImpl;
import com.mccorby.paytouchchallenge.datasource.memory.LocalDatasourceImpl;
import com.mccorby.paytouchchallenge.domain.BusImpl;
import com.mccorby.paytouchchallenge.domain.InteractorInvokerImpl;
import com.mccorby.paytouchchallenge.domain.abstractions.Bus;
import com.mccorby.paytouchchallenge.domain.interactors.InteractorInvoker;
import com.mccorby.paytouchchallenge.domain.interactors.actors.GetActorsInteractor;
import com.mccorby.paytouchchallenge.domain.paytouchchallenge.BuildConfig;
import com.mccorby.paytouchchallenge.domain.paytouchchallenge.R;
import com.mccorby.paytouchchallenge.domain.repository.ActorsRepository;
import com.mccorby.paytouchchallenge.presentation.main.MainPresenter;
import com.mccorby.paytouchchallenge.presentation.main.MainView;
import com.mccorby.paytouchchallenge.presentation.model.PresentationActor;
import com.mccorby.paytouchchallenge.repository.ActorsRepositoryImpl;
import com.mccorby.paytouchchallenge.repository.datasources.LocalDatasource;
import com.mccorby.paytouchchallenge.repository.datasources.NetworkDatasource;
import com.mccorby.paytouchchallenge.view.activity.DetailActivity;
import com.mccorby.paytouchchallenge.view.adapter.ActorListAdapter;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit.RestAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ActorsListFragment extends Fragment implements MainView, ActorListAdapter.OnActorListItemAction {

    private static final String TAG = ActorsListFragment.class.getSimpleName();

    MainPresenter mPresenter;
    private ActorListAdapter mAdapter;

    public ActorsListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // TODO This method to be replaced by proper DI (Dagger2)
        injectObjects();
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.onPause();
    }

    private void injectObjects() {
        // TODO RestAdapter should be a singleton
        ActorsApiService actorsApiService = new RestAdapter.Builder()
                .setEndpoint(BuildConfig.BACKEND_URL)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build()
                .create(ActorsApiService.class);
        Bus bus = new BusImpl();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        LocalDatasource localDatasource = new LocalDatasourceImpl();
        NetworkDatasource networkDatasource = new NetworkDatasourceImpl(actorsApiService);
        ActorsRepository actorsRepository = new ActorsRepositoryImpl(networkDatasource, localDatasource);
        GetActorsInteractor getActorsInteractor = new GetActorsInteractor(bus, actorsRepository);
        InteractorInvoker interactorInvoker = new InteractorInvokerImpl(executorService);
        mPresenter = new MainPresenter(this, bus, interactorInvoker, getActorsInteractor);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_actors_list, container, false);

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.fragment_actors_list_rv);
        // Use a linear layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new ActorListAdapter(null, this);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setHasFixedSize(true);

        mPresenter.onCreate();
        return rootView;
    }


    @Override
    public void refreshActorList(List<PresentationActor> actorList) {
        Log.d(TAG, "Fragment. Refreshing actor list " + actorList.size());
        mAdapter.setActorList(actorList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onActorSelected(PresentationActor actor) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra(Constants.ARG_ACTOR, actor);
        getActivity().startActivity(intent);
    }

    /**
     * Sort the list in this fragment
     * @param sortType
     */
    public void sortList(int sortType) {
        if (mAdapter.getActorList() != null) {
            // Following MVP the presenter should sort the list and return it to the view
            // We are shortcircuiting it for simplicity sake
            // mPresenter.sortList(sortType);
            List<PresentationActor> actorList = mAdapter.getActorList();
            Comparator<PresentationActor> comparator = null;
            switch (sortType) {
                case Constants.SORT_BY_POPULARITY:
                    comparator = new Comparator<PresentationActor>() {
                        @Override
                        public int compare(PresentationActor lhs, PresentationActor rhs) {
                            return Math.round(lhs.getPopularity() - rhs.getPopularity());
                        }
                    };
                    break;
                case Constants.SORT_BY_NAME:
                    comparator = new Comparator<PresentationActor>() {
                        @Override
                        public int compare(PresentationActor lhs, PresentationActor rhs) {
                            return lhs.getName().compareToIgnoreCase(rhs.getName());
                        }
                    };
                    break;
            }
            Collections.sort(actorList, comparator);
            mAdapter.notifyDataSetChanged();
        }
    }
}
