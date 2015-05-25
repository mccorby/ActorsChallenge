package com.mccorby.paytouchchallenge.datasource.api.responses;

import com.google.gson.annotations.Expose;
import com.mccorby.paytouchchallenge.datasource.api.entities.ApiActor;

import java.util.List;

/**
 * This class is a wrapper for the results from backend.
 *
 * Created by JAC on 18/05/2015.
 */
public class ActorsApiResponse {

    /** Attribute as defined by the JSON. */
    @Expose
    private List<ApiActor> actors;

    public List<ApiActor> getActors() {
        return actors;
    }

    public void setActors(List<ApiActor> actors) {
        this.actors = actors;
    }
}
