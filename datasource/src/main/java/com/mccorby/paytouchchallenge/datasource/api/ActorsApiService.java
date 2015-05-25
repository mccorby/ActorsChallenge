package com.mccorby.paytouchchallenge.datasource.api;

import com.mccorby.paytouchchallenge.datasource.api.entities.ApiActor;
import com.mccorby.paytouchchallenge.datasource.api.responses.ActorsApiResponse;

import java.util.List;

import retrofit.http.GET;

/**
 * Created by JAC on 18/05/2015.
 */
public interface ActorsApiService {

    @GET("/")
    ActorsApiResponse getActors();
}
