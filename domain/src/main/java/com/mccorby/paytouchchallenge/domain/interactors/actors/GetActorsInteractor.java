package com.mccorby.paytouchchallenge.domain.interactors.actors;

import com.mccorby.paytouchchallenge.domain.abstractions.Bus;
import com.mccorby.paytouchchallenge.domain.entities.Actor;
import com.mccorby.paytouchchallenge.domain.interactors.Interactor;
import com.mccorby.paytouchchallenge.domain.repository.ActorsRepository;

import java.util.List;

/**
 * Implementation of command to get the list of actors.
 *
 * Created by JAC on 18/05/2015.
 */
public class GetActorsInteractor implements Interactor {
    private Bus mBus;
    private ActorsRepository mActorsRepository;

    public GetActorsInteractor(Bus bus, ActorsRepository repository) {
        this.mBus = bus;
        this.mActorsRepository = repository;
    }

    @Override
    public void execute() {
        List<Actor> actorList = mActorsRepository.getActors();
        mBus.post(actorList);
    }
}
