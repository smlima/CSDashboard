package com.slima.csdashboard.core.components.ui;

import com.slima.csdashboard.core.components.BaseComponent;

/**
 * Created by sergio.lima on 21/01/2017.
 */

public abstract class UIPageComponent extends BaseComponent {

    private String mPageTitle;

    // the page need to have at least one component
    private UIBaseComponent mTopComponent;

    public UIPageComponent() {
    }

    public String getPageTitle() {
        return mPageTitle;
    }

    public void setPageTitle(String pageTitle) {
        mPageTitle = pageTitle;
    }

    public UIBaseComponent getTopComponent() {
        return mTopComponent;
    }

    public void setTopComponent(UIBaseComponent topComponent) {
        mTopComponent = topComponent;
    }
}
