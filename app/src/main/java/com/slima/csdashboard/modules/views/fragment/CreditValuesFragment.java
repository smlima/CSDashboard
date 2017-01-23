package com.slima.csdashboard.modules.views.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.slima.csdashboard.R;
import com.slima.csdashboard.core.views.fragments.ComponentFragment;
import com.slima.csdashboard.databinding.CreditFragmentBinding;
import com.slima.csdashboard.modules.viewmodels.CreditValuesViewModel;

/**
 * Created by sergio.lima on 21/01/2017.
 */

public class CreditValuesFragment extends ComponentFragment<CreditValuesViewModel> {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        CreditFragmentBinding inflate = DataBindingUtil.inflate(inflater, R.layout.credit_fragment, container, false);
        inflate.setVm(getViewModel());
        return inflate.getRoot();
    }
}
