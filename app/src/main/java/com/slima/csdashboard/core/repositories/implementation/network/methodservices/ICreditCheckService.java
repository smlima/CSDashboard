package com.slima.csdashboard.core.repositories.implementation.network.methodservices;

import com.slima.csdashboard.core.models.CreditValues;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by sergio.lima on 22/01/2017.
 */

public interface ICreditCheckService {

    @GET("values")
    Call<CreditValues> getCreditCheck();
}