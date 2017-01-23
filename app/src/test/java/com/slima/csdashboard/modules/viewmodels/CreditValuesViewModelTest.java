package com.slima.csdashboard.modules.viewmodels;

import com.slima.csdashboard.core.models.CreditReportInfo;
import com.slima.csdashboard.core.models.CreditValues;
import com.slima.csdashboard.core.repositories.Callback;
import com.slima.csdashboard.core.repositories.INetworkRepository;
import com.slima.csdashboard.core.repositories.implementation.network.NetworkService;
import com.slima.csdashboard.core.repositories.implementation.network.methodservices.CreditChecksService;
import com.slima.csdashboard.core.services.ResourcesService;
import com.slima.csdashboard.modules.components.ui.CreditComponent;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * simple test to test the CreditValuesViewModel
 *
 * Created by sergio.lima on 23/01/2017.
 */
public class CreditValuesViewModelTest {

    private INetworkRepository mNetworkRepository;
    private CreditValuesViewModel mCreditValuesViewModel;
    private CreditComponent mCreditComponent;

    @Before
    public void setUp() throws Exception {
        NetworkService networkService = mock(NetworkService.class);

        CreditChecksService creditChecksService = mock(CreditChecksService.class);
        CreditValues value = mock(CreditValues.class);

        CreditReportInfo creditReportInfo = mock(CreditReportInfo.class);

        when(networkService.getCreditChecksService()).thenReturn(creditChecksService);
        when(creditChecksService.getCreditCheck()).thenReturn(value);

        when(value.getCreditReportInfo()).thenReturn(creditReportInfo);

        when(creditReportInfo.getMaxScoreValue()).thenReturn(500);
        when(creditReportInfo.getMinScoreValue()).thenReturn(0);
        when(creditReportInfo.getPercentageCreditUsed()).thenReturn(45);

        mNetworkRepository = mock(INetworkRepository.class);

        ResourcesService resourcesService = mock(ResourcesService.class);

        mCreditComponent = new CreditComponent();
        mCreditValuesViewModel = new CreditValuesViewModel(mNetworkRepository, resourcesService);
    }

    @Test
    public void setBaseComponent() throws Exception {

        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {

                Callback o = (Callback) invocation.getArguments()[0];

                Assert.assertTrue(mCreditValuesViewModel.isLoading());

                CreditValues value = new CreditValues();
                o.onSuccess(value);

                return null;
            }
        }).when(mNetworkRepository).fetchCreditValuesAsync(any(Callback.class));


        mCreditValuesViewModel.setBaseComponent(mCreditComponent);


        Assert.assertFalse(mCreditValuesViewModel.isLoading());

    }

}