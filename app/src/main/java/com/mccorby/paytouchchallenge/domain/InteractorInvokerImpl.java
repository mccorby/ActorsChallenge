package com.mccorby.paytouchchallenge.domain;

import com.mccorby.paytouchchallenge.domain.interactors.Interactor;
import com.mccorby.paytouchchallenge.domain.interactors.InteractorInvoker;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * The most simple possible implementation for the Interactor Invoker.
 * It just tell the interactor to execute.
 *
 * Created by JAC on 19/05/2015.
 */
public class InteractorInvokerImpl implements InteractorInvoker {

    private ExecutorService mExecutor;

    public InteractorInvokerImpl(ExecutorService poolExecutor) {
        this.mExecutor = poolExecutor;
    }

    @Override
    public void execute(final Interactor interactor) {
        mExecutor.execute(new Runnable() {
            @Override
            public void run() {
                interactor.execute();
            }
        });

    }
}
