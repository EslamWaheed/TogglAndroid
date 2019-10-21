
package com.eslamwaheed.togglandroid.model.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserResponse implements Serializable {

    @SerializedName("since")
    @Expose
    private long since;
    @SerializedName("data")
    @Expose
    private Data data;

    public long getSince() {
        return since;
    }

    public void setSince(long since) {
        this.since = since;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}
