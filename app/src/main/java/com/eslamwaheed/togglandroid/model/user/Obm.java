
package com.eslamwaheed.togglandroid.model.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Obm implements Serializable {

    @SerializedName("included")
    @Expose
    private boolean included;
    @SerializedName("nr")
    @Expose
    private long nr;
    @SerializedName("actions")
    @Expose
    private String actions;

    public boolean isIncluded() {
        return included;
    }

    public void setIncluded(boolean included) {
        this.included = included;
    }

    public long getNr() {
        return nr;
    }

    public void setNr(long nr) {
        this.nr = nr;
    }

    public String getActions() {
        return actions;
    }

    public void setActions(String actions) {
        this.actions = actions;
    }

}
