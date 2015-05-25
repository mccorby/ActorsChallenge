package com.mccorby.paytouchchallenge.repository.datasources;

import com.mccorby.paytouchchallenge.domain.entities.Actor;

import java.util.List;

/**
 * This interface defines a contract that any datasource using the network must implement.
 *
 * Created by JAC on 18/05/2015.
 */
public interface NetworkDatasource {

    /**
     * Get a list of actors from backend.
     * @return a list of Actor objects
     */
    List<Actor> getActors();
}
