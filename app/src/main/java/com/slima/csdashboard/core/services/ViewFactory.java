package com.slima.csdashboard.core.services;

import com.slima.csdashboard.core.components.ComponentTypes;
import com.slima.csdashboard.core.components.ui.UIBaseComponent;
import com.slima.csdashboard.core.views.fragments.BaseFragment;
import com.slima.csdashboard.modules.views.fragment.CreditValuesFragment;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by sergio.lima on 21/01/2017.
 */
public class ViewFactory {

    @Inject
    public ViewFactory() {
        createMap();
    }

    private void createMap() {

        mFragmentMap.put(ComponentTypes.CREDIT_VALUES, new CreditValuesFragment());

    }

    Map<ComponentTypes, BaseFragment> mFragmentMap = new HashMap<>();

    public BaseFragment getFragmentForComponent(UIBaseComponent baseComponent){

        BaseFragment baseFragment = mFragmentMap.get(baseComponent.getComponentType());
        baseFragment.setBaseComponent(baseComponent);
        return baseFragment;

    }
}
