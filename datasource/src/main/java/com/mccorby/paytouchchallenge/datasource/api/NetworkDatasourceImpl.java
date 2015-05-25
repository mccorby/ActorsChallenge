package com.mccorby.paytouchchallenge.datasource.api;

import com.mccorby.paytouchchallenge.datasource.api.entities.ApiActor;
import com.mccorby.paytouchchallenge.datasource.api.entities.Mapper;
import com.mccorby.paytouchchallenge.datasource.api.responses.ActorsApiResponse;
import com.mccorby.paytouchchallenge.domain.entities.Actor;
import com.mccorby.paytouchchallenge.repository.datasources.NetworkDatasource;

import java.util.ArrayList;
import java.util.List;

/**
 * This class implements the contract defined in NetworkDatasource.
 * It is part of the components required by Retrofit
 */
public class NetworkDatasourceImpl implements NetworkDatasource {

    private ActorsApiService mApiService;

    public NetworkDatasourceImpl(ActorsApiService service) {
        this.mApiService = service;
    }

    @Override
    public List<Actor> getActors() {
        ActorsApiResponse apiContactsResponse = mApiService.getActors();

        // Transform the model from Api to the domain model
        // Note that this (as many other cases in this sample) might look overkilling
        // but it is for demonstration of the clean architecture

        List<ApiActor> results = apiContactsResponse.getActors();
        List<Actor> actors = new ArrayList<>();
        if (results != null) {
            for (ApiActor apiActor : results) {
                actors.add(Mapper.transformActor(apiActor));
            }
        }
        return actors;
    }
}
