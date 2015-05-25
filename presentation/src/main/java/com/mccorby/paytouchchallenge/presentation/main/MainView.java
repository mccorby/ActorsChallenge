package com.mccorby.paytouchchallenge.presentation.main;

import com.mccorby.paytouchchallenge.presentation.model.PresentationActor;

import java.util.List;

/**
 * The "view" interface in the MVP.
 * This interface provides the contract the Main View (Activity) must implement.
 * Created by JAC on 18/05/2015.
 */
public interface MainView {

    void refreshActorList(List<PresentationActor> actorList);

    void refreshUi();
}
