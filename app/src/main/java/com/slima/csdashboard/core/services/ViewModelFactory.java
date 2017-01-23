package com.slima.csdashboard.core.services;

import android.util.Log;

import com.slima.csdashboard.core.components.ComponentTypes;
import com.slima.csdashboard.core.components.ui.UIBaseComponent;
import com.slima.csdashboard.core.ioc.IoC;
import com.slima.csdashboard.core.repositories.INetworkRepository;
import com.slima.csdashboard.core.viewmodels.components.BaseComponentViewModel;
import com.slima.csdashboard.modules.viewmodels.CreditValuesViewModel;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Factory pattern
 * create a VM for the specified component
 *
 * Created by sergio.lima on 21/01/2017.
 */
@Singleton
public class ViewModelFactory {

    private static final String TAG = "ViewModelFactory";

    private Map<ComponentTypes, BaseComponentViewModel> mViewModelMap;

    @Inject
    INetworkRepository mNetworkRepository;
    @Inject
    ResourcesService mResourcesService;

    @Inject
    public ViewModelFactory() {
        IoC.inject(this);
        createMap();
    }

    private void createMap() {
        mViewModelMap = new HashMap<>();

        // empty models.. .ready for cloning and use...
        mViewModelMap.put(ComponentTypes.CREDIT_VALUES, new CreditValuesViewModel(mNetworkRepository, mResourcesService));
    }


    public  <T extends BaseComponentViewModel> T createViewModelForComponent(UIBaseComponent component){

        if (component != null){

            BaseComponentViewModel baseComponentViewModel = mViewModelMap.get(component.getComponentType());
            try {
                BaseComponentViewModel clone = baseComponentViewModel.clone();
                clone.setBaseComponent(component);
                return (T) clone;
            } catch (CloneNotSupportedException e){
                // FIXME: should throw instead...
                Log.e(TAG, "Cannot clone the VM. ", e);
                return null;
            } catch (Exception e){
                // FIXME: should throw instead...
                Log.e(TAG, "Error . ", e);
                return null;
            }

        }

        //FIXME: it would be better to throw an exception at this point. If there's no component there's no point continuing
        return null;
    }
}
