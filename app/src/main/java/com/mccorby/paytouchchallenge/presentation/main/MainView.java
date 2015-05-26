package com.mccorby.paytouchchallenge.presentation.main;

import java.util.List;

/**
 * The "view" interface in the MVP.
 * This interface provides the contract the Main View (Activity) must implement.
 * Created by JAC on 18/05/2015.
 */
public interface MainView {

    void refreshActorList(List<com.mccorby.paytouchchallenge.presentation.model.PresentationActor> actorList);

}
