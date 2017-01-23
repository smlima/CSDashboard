package com.slima.csdashboard.core.viewmodels.pages;

import com.slima.csdashboard.core.components.ui.UIPageComponent;
import com.slima.csdashboard.core.viewmodels.BaseViewModel;

import javax.inject.Inject;

/**
 * Page view model
 * this is simpler because its not required more logic
 *
 * Created by sergio.lima on 21/01/2017.
 */

public class PageViewModel extends BaseViewModel {

    private String mTitle;

    private UIPageComponent mPageComponent;

    @Inject
    public PageViewModel() {
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public UIPageComponent getPageComponent() {
        return mPageComponent;
    }

    public void setPageComponent(UIPageComponent pageComponent) {
        mPageComponent = pageComponent;
    }
}
