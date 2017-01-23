package com.slima.csdashboard.core.repositories.implementation.network.methodservices;

import com.slima.csdashboard.core.models.CreditValues;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

/**
 * The CreditChecks Service which will call the correspondent methods to retrieve the
 * data (in JSON) and then marshall it into the data models
 *
 * Created by sergio.lima on 22/01/2017.
 */

public class CreditChecksService {

    private final ICreditCheckService mMICreditCheckService;

    public CreditChecksService(ICreditCheckService mICreditCheckService) {
        mMICreditCheckService = mICreditCheckService;
    }

    /**
     * get the credit check
     * @return  the data model
     * @throws IOException
     */
    public CreditValues getCreditCheck() throws IOException {

        Call<CreditValues> creditCheck = mMICreditCheckService.getCreditCheck();
        Response<CreditValues> execute = creditCheck.execute();
        return execute.body();
    }
}
