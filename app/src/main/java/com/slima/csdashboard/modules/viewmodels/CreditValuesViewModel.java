package com.slima.csdashboard.modules.viewmodels;

import android.databinding.Bindable;
import android.graphics.Color;

import com.slima.csdashboard.BR;
import com.slima.csdashboard.R;
import com.slima.csdashboard.core.models.CreditValues;
import com.slima.csdashboard.core.repositories.Callback;
import com.slima.csdashboard.core.repositories.INetworkRepository;
import com.slima.csdashboard.core.services.ResourcesService;
import com.slima.csdashboard.core.viewmodels.components.BaseComponentViewModel;
import com.slima.csdashboard.modules.components.ui.CreditComponent;

import javax.inject.Inject;

/**
 * ViewModel of the CreditValues
 *
 * will interact with the View and the Model. contain all the bindables
 * required to interface with the View (fragment in this case) and contains
 * a reference to the CreditValues retrieved by a call to the network repository
 *
 * Created by sergio.lima on 21/01/2017.
 */

public class CreditValuesViewModel extends BaseComponentViewModel<CreditComponent> {

    private static final String TAG = "CreditValuesViewModel";

    private boolean mLoading;
    private CreditValues mCreditValues;

    INetworkRepository mNetworkRepository;
    ResourcesService mResourcesService;

    @Inject
    public CreditValuesViewModel(INetworkRepository networkRepository, ResourcesService resourcesService) {
        super();
        mNetworkRepository = networkRepository;
        mResourcesService = resourcesService;
    }

    @Override
    public void setBaseComponent(CreditComponent baseComponent) {
        super.setBaseComponent(baseComponent);

        // set values
        setLoading(true);

        mNetworkRepository.fetchCreditValuesAsync(new Callback<CreditValues>() {
            @Override
            public void onSuccess(CreditValues value) {

                updateModel(value);
                setLoading(false);
            }

            @Override
            public void onError(Throwable throwable) {

                // Notification service to display error
                setLoading(false);
            }
        });

    }

   private void updateModel(CreditValues model){
       mCreditValues = model;

       notifyPropertyChanged(BR.minValue);
       notifyPropertyChanged(BR.maxValue);
       notifyPropertyChanged(BR.percentage);
       notifyPropertyChanged(BR.totalScore);
       notifyPropertyChanged(BR.textColor);
       notifyPropertyChanged(BR.creditScore);
   }

    @Bindable
    public int getMaxValue(){
        if (mCreditValues != null){
            return mCreditValues.getCreditReportInfo().getMaxScoreValue();
        }
        return 0;
    }
    @Bindable
    public int getMinValue(){
        if (mCreditValues != null){
            return mCreditValues.getCreditReportInfo().getMinScoreValue();
        }
        return 0;
    }

    @Bindable
    public int getCreditScore(){
        if (mCreditValues != null){
            return mCreditValues.getCreditReportInfo().getScore();
        }
        return 0;
    }

    @Bindable
    public int getPercentage(){
        if (mCreditValues != null){
            // FIXME: possible DivByZero Exception...
            return (getCreditScore() * 100) / (getMaxValue() - getMinValue());
        }
        return 0;
    }

    @Bindable
    public String getTotalScore(){
        return mResourcesService.getString(R.string.out_of, getMaxValue());
    }

    @Bindable
    public int getTextColor(){
        int initialGradient = mResourcesService.getColor(R.color.initialGradient);
        int finalGradient = mResourcesService.getColor(R.color.finalGradient);

        return interpolateColor(initialGradient, finalGradient, getPercentage() / 100F);
    }


    /**
     * retrieved from stackoverflow to calculate the gradient between 2 colors
     *
     */
    private int interpolateColor(int a, int b, float proportion) {

        if (proportion > 1 || proportion < 0) {
            throw new IllegalArgumentException("proportion must be [0 - 1]");
        }
        float[] hsva = new float[3];
        float[] hsvb = new float[3];
        float[] hsv_output = new float[3];

        Color.colorToHSV(a, hsva);
        Color.colorToHSV(b, hsvb);
        for (int i = 0; i < 3; i++) {
            hsv_output[i] = interpolate(hsva[i], hsvb[i], proportion);
        }

        int alpha_a = Color.alpha(a);
        int alpha_b = Color.alpha(b);
        float alpha_output = interpolate(alpha_a, alpha_b, proportion);

        return Color.HSVToColor((int) alpha_output, hsv_output);
    }
    private float interpolate(float a, float b, float proportion) {
        return (a + ((b - a) * proportion));
    }


    @Bindable
    public String getTitle(){
        return getBaseComponent().getTitle();
    }

    @Bindable
    public boolean isLoading() {
        return mLoading;
    }

    public void setLoading(boolean loading) {
        mLoading = loading;
        notifyPropertyChanged(BR.loading);
    }
}
