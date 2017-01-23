package com.slima.csdashboard.core.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.slima.csdashboard.core.models.base.BaseModel;

/**
 * CoachingSummary data model
 * Created by sergio.lima on 21/01/2017.
 */
public class CoachingSummary extends BaseModel{

    @SerializedName("activeTodo")
    @Expose
    public Boolean activeTodo;
    @SerializedName("activeChat")
    @Expose
    public Boolean activeChat;
    @SerializedName("numberOfTodoItems")
    @Expose
    public Integer numberOfTodoItems;
    @SerializedName("numberOfCompletedTodoItems")
    @Expose
    public Integer numberOfCompletedTodoItems;
    @SerializedName("selected")
    @Expose
    public Boolean selected;
}
