package com.slima.csdashboard.core.repositories;

import com.slima.csdashboard.core.models.CreditValues;

/**
 * Network repository interface
 *
 * Created by sergio.lima on 21/01/2017.
 */
public interface INetworkRepository {

    /**
     * method to fetch data from the network layer
     * @param callback  the callback to return the correct CreditValues data model
     */
    void fetchCreditValuesAsync(Callback<CreditValues> callback);
}
