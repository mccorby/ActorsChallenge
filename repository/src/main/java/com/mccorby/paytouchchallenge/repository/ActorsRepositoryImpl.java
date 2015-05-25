package com.mccorby.paytouchchallenge.repository;

import com.mccorby.paytouchchallenge.domain.entities.Actor;
import com.mccorby.paytouchchallenge.domain.repository.ActorsRepository;
import com.mccorby.paytouchchallenge.repository.datasources.LocalDatasource;
import com.mccorby.paytouchchallenge.repository.datasources.NetworkDatasource;

import java.util.List;

public class ActorsRepositoryImpl implements ActorsRepository {

    private final NetworkDatasource mNetworkDatasource;
    private final LocalDatasource mLocalDatasource;

    public ActorsRepositoryImpl(NetworkDatasource networkDatasource, LocalDatasource localDatasource) {
        this.mNetworkDatasource = networkDatasource;
        this.mLocalDatasource = localDatasource;
    }

    /**
     * TODO This method adds some logic to the process of actors coming from backend.
     * In this sample I just add the list of actors to the local datasource.
     * Other implementations could handle a database or some other caching mechanism to avoid
     * unnecessary calls through the network.
     * @return
     */
    @Override
    public List<Actor> getActors() {
        List<Actor> actorList = mNetworkDatasource.getActors();
        mLocalDatasource.addActors(actorList);
        return mLocalDatasource.getActors();
    }

    @Override
    public Actor getActor(Integer identifier) {
        return mLocalDatasource.getActor(identifier);
    }
}
