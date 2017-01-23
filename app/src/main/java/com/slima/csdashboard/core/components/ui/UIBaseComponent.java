package com.slima.csdashboard.core.components.ui;

import com.slima.csdashboard.core.components.BaseComponent;
import com.slima.csdashboard.core.components.ComponentTypes;

/**
 * Created by sergio.lima on 21/01/2017.
 */

public abstract class UIBaseComponent extends BaseComponent {

    public abstract String getTitle();
    public abstract ComponentTypes getComponentType();
}
