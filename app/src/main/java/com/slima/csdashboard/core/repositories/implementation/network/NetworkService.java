package com.slima.csdashboard.core.repositories.implementation.network;

import com.slima.csdashboard.core.repositories.implementation.network.methodservices.CreditChecksService;
import com.slima.csdashboard.core.repositories.implementation.network.methodservices.ICreditCheckService;

import okhttp3.OkHttpClient;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * The network service layer implementaiton
 * in this case i used the Retrofit client, because its so easy to implement and
 * well known throughout the dev community. And also it has a lot of support and docs
 *
 * Created by sergio.lima on 22/01/2017.
 */

public class NetworkService {

    private final String mBaseUrl = "https://5lfoiyb0b3.execute-api.us-west-2.amazonaws.com/prod/mockcredit/";
    private final CreditChecksService mCreditChecksService;

    public NetworkService() {

        OkHttpClient client = new OkHttpClient.Builder().build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();


        ICreditCheckService mICreditCheckService = retrofit.create(ICreditCheckService.class);

        mCreditChecksService = new CreditChecksService(mICreditCheckService);
    }

    public CreditChecksService getCreditChecksService() {
        return mCreditChecksService;
    }
}
