package com.slima.csdashboard.core.ioc;

/**
 * Inversion of Controll patern
 * provide all the modules required.
 *
 * Created by sergio.lima on 21/01/2017.
 */

import android.content.Context;

import com.slima.csdashboard.core.repositories.INetworkRepository;
import com.slima.csdashboard.core.repositories.implementation.network.NetworkRepository;
import com.slima.csdashboard.core.repositories.implementation.network.NetworkService;
import com.slima.csdashboard.core.services.ResourcesService;
import com.slima.csdashboard.core.services.ViewModelFactory;
import com.slima.csdashboard.core.viewmodels.pages.PageViewModel;
import com.slima.csdashboard.core.views.activities.BaseActivity;
import com.slima.csdashboard.core.views.activities.FragmentHostActivity;
import com.slima.csdashboard.core.views.fragments.BaseFragment;
import com.slima.csdashboard.modules.viewmodels.CreditValuesViewModel;
import com.slima.csdashboard.modules.views.fragment.CreditValuesFragment;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(injects = {
        //Activities
        BaseActivity.class,
        FragmentHostActivity.class,

        //Fragments
        BaseFragment.class,
        CreditValuesFragment.class,

        //ViewModels
        PageViewModel.class,
        CreditValuesViewModel.class,

        //Other
        ResourcesService.class,
        INetworkRepository.class,
        ViewModelFactory.class

})
public class AndroidModule {

    private Context mAppContext;

    public AndroidModule(Context appContext) {
        mAppContext = appContext;
    }

    @Provides
    @Singleton
    ResourcesService provideResourceService(){
        return new ResourcesService(mAppContext);
    }

    @Provides
    @Singleton
    INetworkRepository provideGeneralRepository(){
        return new NetworkRepository(new NetworkService());
    }

    @Provides
    Context provideContext(){
        return mAppContext;
    }
}
