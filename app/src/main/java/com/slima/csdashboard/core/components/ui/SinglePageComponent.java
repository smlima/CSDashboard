package com.slima.csdashboard.core.components.ui;

/**
 * A simple implementation of the UIPageComponent
 * to draw a single component (which in the View perspective is a Fragment)
 *
 * Created by sergio.lima on 21/01/2017.
 */

public class SinglePageComponent extends UIPageComponent {

    public SinglePageComponent(UIBaseComponent pageComponent) {
        setTopComponent( pageComponent);
        setPageTitle(getTopComponent().getTitle());
    }
}
