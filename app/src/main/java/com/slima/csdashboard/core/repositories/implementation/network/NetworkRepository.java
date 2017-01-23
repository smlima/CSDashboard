package com.slima.csdashboard.core.repositories.implementation.network;

import com.slima.csdashboard.core.models.CreditValues;
import com.slima.csdashboard.core.repositories.Callback;
import com.slima.csdashboard.core.repositories.CallbackAsyncTask;
import com.slima.csdashboard.core.repositories.INetworkRepository;

/**
 * implementation of the networkRepository interface
 *
 * Created by sergio.lima on 21/01/2017.
 */

public class NetworkRepository implements INetworkRepository {

    /**
     * netowrk service object
     */
    private final NetworkService mNetworkService;

    public NetworkRepository(NetworkService networkService) {
        mNetworkService = networkService;
    }

    @Override
    public void fetchCreditValuesAsync(final Callback<CreditValues> callback){

        CallbackAsyncTask<Object, Object, CreditValues> task = new CallbackAsyncTask<Object, Object, CreditValues>(callback) {

            @Override
            protected CreditValues doStuff(Object... params) throws Exception{

                // sync method
                CreditValues creditCheck = mNetworkService.getCreditChecksService().getCreditCheck();

                return creditCheck;
            }

        };

        task.executeOnThreadPool();
    }


}
