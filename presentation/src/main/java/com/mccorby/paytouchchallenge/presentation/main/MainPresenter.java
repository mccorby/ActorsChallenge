package com.mccorby.paytouchchallenge.presentation.main;

import com.mccorby.paytouchchallenge.domain.abstractions.Bus;
import com.mccorby.paytouchchallenge.domain.entities.Actor;
import com.mccorby.paytouchchallenge.domain.interactors.InteractorInvoker;
import com.mccorby.paytouchchallenge.domain.interactors.actors.GetActorsInteractor;
import com.mccorby.paytouchchallenge.presentation.Presenter;
import com.mccorby.paytouchchallenge.presentation.model.Mapper;
import com.mccorby.paytouchchallenge.presentation.model.PresentationActor;

import java.util.ArrayList;
import java.util.List;

/**
 * The Presenter in the MVP pattern.
 * This presenter is used by the Main list.
 * Note the registering and unregistering in the bus in the overriden methods
 * Created by JAC on 18/05/2015.
 */
public class MainPresenter extends Presenter {

    private final Bus mBus;
    private InteractorInvoker mInteractorInvoker;

    // The commands handled by this presenter
    private GetActorsInteractor mGetActorsInteractor;
    private final MainView mView;

    public MainPresenter(MainView view, Bus bus, InteractorInvoker invoker, GetActorsInteractor getActorsInteractor) {
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
        List<PresentationActor> presentationActors = new ArrayList<>(actorList.size());

        for (Actor actor : actorList) {
            PresentationActor presentationActor = Mapper.modelToData(actor);
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
