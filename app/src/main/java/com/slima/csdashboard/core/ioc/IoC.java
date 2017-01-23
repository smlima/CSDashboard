package com.slima.csdashboard.core.ioc;

import dagger.ObjectGraph;

/**
 * Inversion of Control object for dagger
 * inject the modules and allow getter the modules required
 *
 * Created by sergio.lima on 21/01/2017.
 */

public class IoC {
    private static ObjectGraph sGraph;

    public static void initialize(ObjectGraph graph) {
        sGraph = graph;
    }

    public static <T> T get(Class<T> objectClass) {
        return sGraph.get(objectClass);
    }

    public static  <T> T inject(T toInject) {
        if(sGraph != null) {
            return sGraph.inject(toInject);
        }

        return toInject;
    }
}
