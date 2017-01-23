package com.slima.csdashboard.core.views.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import com.slima.csdashboard.R;
import com.slima.csdashboard.core.components.ui.SinglePageComponent;
import com.slima.csdashboard.core.components.ui.UIPageComponent;
import com.slima.csdashboard.core.services.ResourcesService;
import com.slima.csdashboard.core.services.ViewFactory;
import com.slima.csdashboard.core.views.fragments.BaseFragment;
import com.slima.csdashboard.databinding.ActivityFragmentHostBinding;
import com.slima.csdashboard.modules.components.ui.CreditComponent;

import javax.inject.Inject;

/**
 * Created by sergio.lima on 21/01/2017.
 */
public class FragmentHostActivity extends BaseActivity {

    @Inject
    ResourcesService mResourcesService;

    @Inject
    ViewFactory mViewFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityFragmentHostBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_fragment_host);
        binding.setVm(getViewModel());
        final View root = binding.getRoot();

        initialSettingsDoneHereForSimplicity();
        setupActivity(savedInstanceState, root);
        replaceFragment();

    }

    void replaceFragment(){

        UIPageComponent pageComponent = getViewModel().getPageComponent();
        BaseFragment fragmentForComponent = mViewFactory.getFragmentForComponent(pageComponent.getTopComponent());
        getSupportFragmentManager().beginTransaction().replace(R.id.layout_fragment_host_main, fragmentForComponent).commit();
    }

    /**
     * FIXME: ...
     *
     * For the sake of simplicity the initialization of the page and respective
     * component was made here on this activity. But it should be done outside
     * because this activity (VIEW on MVVM) has/should not have any insight on the data(MODEL)
     * to be rendered.
     *
     */
    void initialSettingsDoneHereForSimplicity(){

        getViewModel().setTitle(mResourcesService.getString(R.string.dashboard_label));

        CreditComponent creditComponent = new CreditComponent();
        SinglePageComponent pageComponent = new SinglePageComponent(creditComponent);
        getViewModel().setPageComponent(pageComponent);

    }
}
