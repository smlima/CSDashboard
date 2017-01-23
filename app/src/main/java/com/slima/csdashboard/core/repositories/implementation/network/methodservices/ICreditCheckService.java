package com.slima.csdashboard.core.repositories.implementation.network.methodservices;

import com.slima.csdashboard.core.models.CreditValues;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * specification of the methods to be done
 *
 * Created by sergio.lima on 22/01/2017.
 */

public interface ICreditCheckService {

    /**
     * retrieve the data from the values method endpoint
     * @return  Call for CreditValues data model
     */
    @GET("values")
    Call<CreditValues> getCreditCheck();
}