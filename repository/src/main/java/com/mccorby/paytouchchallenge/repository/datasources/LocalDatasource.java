package com.mccorby.paytouchchallenge.repository.datasources;

import com.mccorby.paytouchchallenge.domain.entities.Actor;

import java.util.List;

/**
 * Created by JAC on 18/05/2015.
 */
public interface LocalDatasource {

    void addActors(List<Actor> actorList);

    Actor getActor(Integer identifier);

    List<Actor> getActors();
}
