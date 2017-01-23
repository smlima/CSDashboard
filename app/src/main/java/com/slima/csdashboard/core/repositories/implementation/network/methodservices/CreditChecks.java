package com.slima.csdashboard.core.repositories.implementation.network.methodservices;

import com.slima.csdashboard.core.models.CreditValues;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by sergio.lima on 22/01/2017.
 */

public class CreditChecks {

    private final ICreditCheckService mMICreditCheckService;

    public CreditChecks(ICreditCheckService mICreditCheckService) {
        mMICreditCheckService = mICreditCheckService;
    }

    public CreditValues getCreditCheck() throws IOException {

        Call<CreditValues> creditCheck = mMICreditCheckService.getCreditCheck();
        Response<CreditValues> execute = creditCheck.execute();
        return execute.body();
    }
}
