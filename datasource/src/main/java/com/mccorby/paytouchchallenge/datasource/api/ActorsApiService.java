package com.mccorby.paytouchchallenge.datasource.api;

import com.mccorby.paytouchchallenge.datasource.api.responses.ActorsApiResponse;

import retrofit.http.GET;

/**
 * Created by JAC on 18/05/2015.
 */
public interface ActorsApiService {

    @GET("/?page=1")
    ActorsApiResponse getActors();
}
