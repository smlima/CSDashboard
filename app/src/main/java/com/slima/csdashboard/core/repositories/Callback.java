package com.slima.csdashboard.core.repositories;

/**
 * Standard Callback to be used on the event calls, like on the Repository calls
 *
 * Created by sergio.lima on 21/01/2017.
 */

public interface Callback<T> {

    /**
     * call whenever a succe happens
     * @param value the correspondent value to send back
     */
    void onSuccess(T value);

    /**
     * call whenever an error happens
     * @param throwable the error
     */
    void onError(Throwable throwable);
}
