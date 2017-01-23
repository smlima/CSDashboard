package com.slima.csdashboard.application;

import android.app.Application;

import com.slima.csdashboard.core.ioc.AndroidModule;
import com.slima.csdashboard.core.ioc.IoC;

import dagger.ObjectGraph;

/**
 * Simple Application
 * will initialize the Inversion of Control object to allow access of the
 * modules anywhere throughout the app, and allow for injection
 *
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
