package com.mccorby.paytouchchallenge.domain.interactors.actors;

import com.mccorby.paytouchchallenge.domain.abstractions.Bus;
import com.mccorby.paytouchchallenge.domain.entities.Actor;
import com.mccorby.paytouchchallenge.domain.interactors.Interactor;
import com.mccorby.paytouchchallenge.domain.repository.ActorsRepository;

/**
 * Implementation of command to get a single actor.
 *
 * Created by JAC on 18/05/2015.
 */
public class GetActorInteractor implements Interactor {

    private Bus mBus;
    private ActorsRepository mActorsRepository;
    private Integer mId;

    public GetActorInteractor(Bus bus, ActorsRepository repository) {
        this.mBus = bus;
        this.mActorsRepository = repository;
    }

    public void setData(Integer identifier) {
        mId = identifier;
    }

    @Override
    public void execute() {
        Actor actor = mActorsRepository.getActor(mId);
        mBus.post(actor);
    }
}
