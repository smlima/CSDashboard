package com.slima.csdashboard.core.services;

import android.content.Context;

import javax.inject.Inject;

/**
 * Created by sergio.lima on 21/01/2017.
 */
public class ResourcesService {

    private final Context mContext;

    @Inject
    public ResourcesService(Context context) {
        mContext = context;
    }

    public String getString(int resourceId){
        return mContext.getResources().getString(resourceId);
    }

    public String getString(int resourceId, Object ...args){
        return mContext.getResources().getString(resourceId, args);
    }

    public int getColor(int id){
        return mContext.getResources().getColor(id);
    }
}
