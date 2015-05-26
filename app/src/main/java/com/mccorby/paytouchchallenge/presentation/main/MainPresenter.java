package com.mccorby.paytouchchallenge.presentation.main;

import com.mccorby.paytouchchallenge.domain.abstractions.Bus;
import com.mccorby.paytouchchallenge.domain.entities.Actor;
import com.mccorby.paytouchchallenge.domain.interactors.InteractorInvoker;
import com.mccorby.paytouchchallenge.domain.interactors.actors.GetActorsInteractor;

import java.util.ArrayList;
import java.util.List;

/**
 * The Presenter in the MVP pattern.
 * This presenter is used by the Main list.
 * Note the registering and unregistering in the bus in the overriden methods
 * Created by JAC on 18/05/2015.
 */
public class MainPresenter extends com.mccorby.paytouchchallenge.presentation.Presenter {

    private final Bus mBus;
    private InteractorInvoker mInteractorInvoker;

    // The commands handled by this presenter
    private GetActorsInteractor mGetActorsInteractor;
    private final com.mccorby.paytouchchallenge.presentation.main.MainView mView;

    public MainPresenter(com.mccorby.paytouchchallenge.presentation.main.MainView view, Bus bus, InteractorInvoker invoker, GetActorsInteractor getActorsInteractor) {
        mView = view;
        this.mBus = bus;
        this.mGetActorsInteractor = getActorsInteractor;
        this.mInteractorInvoker = invoker;
    }

    public void onCreate() {
        mInteractorInvoker.execute(mGetActorsInteractor);
    }


    /**
     * Required by EventBus to be named as "onEvent".
     *
     * @param actorList
     */
    public void onEvent(List<Actor> actorList) {
        List<com.mccorby.paytouchchallenge.presentation.model.PresentationActor> presentationActors = new ArrayList<>(actorList.size());

        for (Actor actor : actorList) {
            com.mccorby.paytouchchallenge.presentation.model.PresentationActor presentationActor = com.mccorby.paytouchchallenge.presentation.model.Mapper.modelToData(actor);
            presentationActors.add(presentationActor);
        }

        mView.refreshActorList(presentationActors);
    }

    @Override
    public void onResume() {
        mBus.register(this);
    }

    @Override
    public void onPause() {
        mBus.unregister(this);
    }
}
