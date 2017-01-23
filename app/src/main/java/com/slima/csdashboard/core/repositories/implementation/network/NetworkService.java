package com.slima.csdashboard.core.repositories.implementation.network;

import com.slima.csdashboard.core.repositories.implementation.network.methodservices.CreditChecks;
import com.slima.csdashboard.core.repositories.implementation.network.methodservices.ICreditCheckService;

import okhttp3.OkHttpClient;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * Created by sergio.lima on 22/01/2017.
 */

public class NetworkService {

    private final String mBaseUrl = "https://5lfoiyb0b3.execute-api.us-west-2.amazonaws.com/prod/mockcredit/";
    private final CreditChecks mCreditChecks;

    public NetworkService() {

        OkHttpClient client = new OkHttpClient.Builder().build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();


        ICreditCheckService mICreditCheckService = retrofit.create(ICreditCheckService.class);

        mCreditChecks = new CreditChecks(mICreditCheckService);
    }

    public CreditChecks getCreditChecks() {
        return mCreditChecks;
    }
}
