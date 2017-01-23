package com.slima.csdashboard.core.repositories;

import com.slima.csdashboard.core.models.CreditValues;

/**
 * Created by sergio.lima on 21/01/2017.
 */
public interface INetworkRepository {
    void fetchCreditValuesAsync(Callback<CreditValues> callback);
}
