package com.slima.csdashboard.core.components.ui;

import com.slima.csdashboard.core.components.BaseComponent;
import com.slima.csdashboard.core.components.ComponentTypes;

/**
 * Base Component associated with components, ie Fragments that can be added into
 * a UIPageComponent
 * A UIPageComponent should be able to handle one or more components
 *
 *
 * Created by sergio.lima on 21/01/2017.
 */

public abstract class UIBaseComponent extends BaseComponent {

    public abstract String getTitle();
    public abstract ComponentTypes getComponentType();
}
