package com.mccorby.paytouchchallenge.view.fragment;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mccorby.paytouchchallenge.datasource.api.ActorsApiService;
import com.mccorby.paytouchchallenge.datasource.api.NetworkDatasourceImpl;
import com.mccorby.paytouchchallenge.datasource.memory.LocalDatasourceImpl;
import com.mccorby.paytouchchallenge.domain.BusImpl;
import com.mccorby.paytouchchallenge.domain.InteractorInvokerImpl;
import com.mccorby.paytouchchallenge.domain.abstractions.Bus;
import com.mccorby.paytouchchallenge.domain.interactors.InteractorInvoker;
import com.mccorby.paytouchchallenge.domain.interactors.actors.GetActorsInteractor;
import com.mccorby.paytouchchallenge.domain.paytouchchallenge.R;
import com.mccorby.paytouchchallenge.domain.repository.ActorsRepository;
import com.mccorby.paytouchchallenge.presentation.main.MainPresenter;
import com.mccorby.paytouchchallenge.presentation.main.MainView;
import com.mccorby.paytouchchallenge.presentation.model.PresentationActor;
import com.mccorby.paytouchchallenge.repository.ActorsRepositoryImpl;
import com.mccorby.paytouchchallenge.repository.datasources.LocalDatasource;
import com.mccorby.paytouchchallenge.repository.datasources.NetworkDatasource;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import javax.inject.Inject;

import retrofit.RestAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ActorsListFragment extends Fragment implements MainView {

    private static final String TAG = ActorsListFragment.class.getSimpleName();

    MainPresenter mPresenter;

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
                .setEndpoint("http://testandroid.pay-touch.com:8080/android-test/rest/actors")
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
        mPresenter.onCreate();
        return inflater.inflate(R.layout.fragment_actors_list, container, false);
    }


    @Override
    public void refreshActorList(List<PresentationActor> actorList) {
        Log.d(TAG, "Fragment. Refreshing actor list");
    }

    @Override
    public void refreshUi() {

    }
}
