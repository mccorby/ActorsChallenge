package com.mccorby.paytouchchallenge.datasource.memory;

import com.mccorby.paytouchchallenge.domain.entities.Actor;
import com.mccorby.paytouchchallenge.repository.datasources.LocalDatasource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JAC on 18/05/2015.
 */
public class LocalDatasourceImpl implements LocalDatasource {

    private List<Actor> mActorList;

    @Override
    public void addActors(List<Actor> actorList) {
        if (mActorList == null) {
            mActorList = new ArrayList<>(actorList.size());
        }
        mActorList.clear();
        mActorList.addAll(actorList);
    }

    @Override
    public List<Actor> getActors() {
        // TODO Return an inmutable list
        return mActorList;
    }

    @Override
    public Actor getActor(Integer identifier) {
        // TODO Dirty search!
        for (Actor actor : mActorList) {
            if (actor.getIdentifier().equals(identifier)) {
                return actor;
            }
        }
        return null;
    }
}
