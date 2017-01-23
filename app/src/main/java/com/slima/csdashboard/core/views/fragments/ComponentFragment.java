package com.slima.csdashboard.core.views.fragments;

import com.slima.csdashboard.core.components.ui.UIBaseComponent;
import com.slima.csdashboard.core.viewmodels.components.BaseComponentViewModel;

/**
 * Created by sergio.lima on 21/01/2017.
 */

public class ComponentFragment<T extends BaseComponentViewModel> extends BaseFragment {

    private UIBaseComponent mBaseComponent;

    public void setBaseComponent(UIBaseComponent baseComponent) {
        mBaseComponent = baseComponent;
    }

    T mViewModel;

    public T getViewModel() {
        if(mViewModel == null) {
            mViewModel = getUIComponentViewModel(mBaseComponent);

        }
        return mViewModel;
    }
}
