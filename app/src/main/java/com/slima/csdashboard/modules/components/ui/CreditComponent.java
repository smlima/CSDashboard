package com.slima.csdashboard.modules.components.ui;

import com.slima.csdashboard.core.components.ComponentTypes;
import com.slima.csdashboard.core.components.ui.UIBaseComponent;

/**
 * Component for getting the Credit Component
 *
 * Created by sergio.lima on 21/01/2017.
 */

public class CreditComponent extends UIBaseComponent {

    @Override
    public String getTitle() {
        return "Credit Component Title";
    }

    @Override
    public ComponentTypes getComponentType() {
        return ComponentTypes.CREDIT_VALUES;
    }
}
