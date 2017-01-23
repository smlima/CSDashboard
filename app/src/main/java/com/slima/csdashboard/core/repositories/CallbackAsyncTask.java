package com.slima.csdashboard.core.repositories;

import android.os.AsyncTask;
import android.util.Log;

import java.util.concurrent.Executors;

/**
 * Created by sergio.lima on 21/01/2017.
 */

public abstract class CallbackAsyncTask<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> {

    private static final String TAG = "CallbackAsyncTask";

    private final Callback<Result> mCallback;

    public CallbackAsyncTask(Callback<Result> callback) {
        mCallback = callback;
    }

    @Override
    protected Result doInBackground(Params... params) {

        try{
            return doStuff(params);
        } catch (Exception e){
            Log.e(TAG, "Error on doStuff() ", e);
            if (mCallback != null){
                mCallback.onError(e);
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(Result result) {
        if (mCallback != null) {
            mCallback.onSuccess(result);
        } else {
            Log.e(TAG, "The callback is Null");
        }
    }

    protected abstract Result doStuff(Params... params) throws Exception;

    public void executeOnThreadPool() {
        super.executeOnExecutor(Executors.newCachedThreadPool());
    }
}
