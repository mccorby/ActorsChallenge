package com.mccorby.paytouchchallenge.domain.interactors;

/**
 * The Invoker abstraction in the Command pattern.
 * Possible implementations would use a ThreadPoolExecutor to handle the commands.
 *
 * Created by JAC on 18/05/2015.
 */
public interface InteractorInvoker {

    void execute(Interactor interactor);
}
