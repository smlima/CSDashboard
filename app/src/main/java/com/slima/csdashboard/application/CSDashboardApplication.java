package com.slima.csdashboard.application;

import android.app.Application;

import com.slima.csdashboard.core.ioc.AndroidModule;
import com.slima.csdashboard.core.ioc.IoC;

import dagger.ObjectGraph;

/**
 * Created by sergio.lima on 21/01/2017.
 */

public class CSDashboardApplication extends Application {

    private ObjectGraph mObjectGraph;

    @Override
    public void onCreate() {
        super.onCreate();

        init();
    }

    private void init(){

        mObjectGraph = ObjectGraph.create(new AndroidModule(this));

        IoC.initialize(mObjectGraph);
    }
}
