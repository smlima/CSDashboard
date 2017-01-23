package com.slima.csdashboard.core.views.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.slima.csdashboard.R;
import com.slima.csdashboard.core.ioc.IoC;
import com.slima.csdashboard.core.viewmodels.pages.PageViewModel;

import javax.inject.Inject;

/**
 * Created by sergio.lima on 21/01/2017.
 */

public class BaseActivity extends AppCompatActivity {

    /** Model of the Page itself */
    @Inject
    public PageViewModel mPageViewModel;

    public PageViewModel getViewModel(){
        if(mPageViewModel == null) {
            mPageViewModel = IoC.get(PageViewModel.class);
        }
        return mPageViewModel;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        IoC.inject(this);
    }

    /**
     * Setup common activity stuff
     *
     * @param savedInstanceState
     * @param root
     */
    protected void setupActivity(Bundle savedInstanceState, View root){

        if (savedInstanceState == null){
            // initial setup

            setSupportActionBar((Toolbar) root.findViewById(R.id.toolbar_actionBar));

            getSupportActionBar().setDisplayShowTitleEnabled(false);
            //getSupportActionBar().setTitle(mPageViewModel.getTitle());

        }
    }
}
