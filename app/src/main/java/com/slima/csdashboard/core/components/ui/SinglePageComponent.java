package com.slima.csdashboard.core.components.ui;

/**
 * Created by sergio.lima on 21/01/2017.
 */

public class SinglePageComponent extends UIPageComponent {

    public SinglePageComponent(UIBaseComponent pageComponent) {
        setTopComponent( pageComponent);
        setPageTitle(getTopComponent().getTitle());
    }
}
