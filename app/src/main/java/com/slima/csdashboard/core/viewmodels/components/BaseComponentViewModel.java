package com.slima.csdashboard.core.viewmodels.components;

import com.slima.csdashboard.core.components.BaseComponent;
import com.slima.csdashboard.core.ioc.IoC;
import com.slima.csdashboard.core.viewmodels.BaseViewModel;

/**
 * Base viewmodel for a specific component
 *
 * Created by sergio.lima on 21/01/2017.
 */

public class BaseComponentViewModel<T extends BaseComponent> extends BaseViewModel{

    private T mBaseComponent;

    public BaseComponentViewModel() {
        IoC.inject(this);
    }

    public void setBaseComponent(T baseComponent) {
        mBaseComponent = baseComponent;
    }

    protected  T getBaseComponent(){
        return mBaseComponent;
    }

    @Override
    public BaseComponentViewModel clone() throws CloneNotSupportedException {
        return (BaseComponentViewModel) super.clone();
    }
}
