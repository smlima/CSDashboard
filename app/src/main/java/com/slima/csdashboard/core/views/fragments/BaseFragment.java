package com.slima.csdashboard.core.views.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.slima.csdashboard.core.components.ui.UIBaseComponent;
import com.slima.csdashboard.core.ioc.IoC;
import com.slima.csdashboard.core.services.ViewModelFactory;
import com.slima.csdashboard.core.viewmodels.components.BaseComponentViewModel;

import javax.inject.Inject;

/**
 * Base Fragment logic
 * ie get the componenent VM from the respective component
 *
 * Created by sergio.lima on 21/01/2017.
 */

public class BaseFragment extends android.support.v4.app.Fragment {


    private UIBaseComponent mBaseComponent;

    /**
     * set the component to the correct fragment
     * @param baseComponent
     */
    public void setBaseComponent(UIBaseComponent baseComponent) {
        mBaseComponent = baseComponent;
    }

    @Inject
    ViewModelFactory mViewModelFactory;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        IoC.inject(this);
    }

    protected <T extends BaseComponentViewModel> T getUIComponentViewModel(UIBaseComponent component){
        return mViewModelFactory.createViewModelForComponent(component);
    }

}
