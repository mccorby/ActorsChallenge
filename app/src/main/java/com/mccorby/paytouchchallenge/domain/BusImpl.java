package com.mccorby.paytouchchallenge.domain;

import android.os.Handler;
import android.os.Looper;

import com.mccorby.paytouchchallenge.domain.abstractions.Bus;

import de.greenrobot.event.EventBus;

/**
 * An implementation of the Bus in domain using EventBus.
 * Created by JAC on 19/05/2015.
 */
public class BusImpl extends EventBus implements Bus {
    private static final Handler handler = new Handler(Looper.getMainLooper());

    @Override
    public void post(final Object event) {
        handler.post(new Runnable() {
            @Override public void run() {
                BusImpl.super.post(event);
            }
        });
    }
}
