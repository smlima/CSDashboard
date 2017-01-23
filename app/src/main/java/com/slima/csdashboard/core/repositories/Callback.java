package com.slima.csdashboard.core.repositories;

/**
 * Created by sergio.lima on 21/01/2017.
 */

public interface Callback<T> {

    void onSuccess(T value);
    void onError(Throwable throwable);
}
