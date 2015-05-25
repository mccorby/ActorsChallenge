package com.mccorby.paytouchchallenge.domain.abstractions;

/**
 * The contract a bus in this system must comply to.
 * With this I am abstracting the bus library to be used (EventBus, Otto,...).
 *
 * Created by JAC on 18/05/2015.
 */
public interface Bus {
    public void post(Object o);
    public void register(Object o);
    public void unregister(Object o);
}
