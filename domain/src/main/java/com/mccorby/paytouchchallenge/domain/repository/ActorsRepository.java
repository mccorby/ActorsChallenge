package com.mccorby.paytouchchallenge.domain.repository;

import com.mccorby.paytouchchallenge.domain.entities.Actor;

import java.util.List;

/**
 * Definition of the contract that must be implemented by any data source of Actors.
 *
 * Created by JAC on 18/05/2015.
 */
public interface ActorsRepository {

    List<Actor> getActors();

    Actor getActor(Integer identifier);
}
