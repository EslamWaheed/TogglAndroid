package com.eslamwaheed.togglandroid.model.timer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TimerResponse implements Serializable {

    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("guid")
    @Expose
    private String guid;
    @SerializedName("wid")
    @Expose
    private long wid;
    @SerializedName("billable")
    @Expose
    private boolean billable;
    @SerializedName("start")
    @Expose
    private String start;
    @SerializedName("stop")
    @Expose
    private String stop;
    @SerializedName("duration")
    @Expose
    private long duration;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("duronly")
    @Expose
    private boolean duronly;
    @SerializedName("at")
    @Expose
    private String at;
    @SerializedName("uid")
    @Expose
    private long uid;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public long getWid() {
        return wid;
    }

    public void setWid(long wid) {
        this.wid = wid;
    }

    public boolean isBillable() {
        return billable;
    }

    public void setBillable(boolean billable) {
        this.billable = billable;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getStop() {
        return stop;
    }

    public void setStop(String stop) {
        this.stop = stop;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDuronly() {
        return duronly;
    }

    public void setDuronly(boolean duronly) {
        this.duronly = duronly;
    }

    public String getAt() {
        return at;
    }

    public void setAt(String at) {
        this.at = at;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getStartFormated() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date date = null;
        try {
            date = sdf.parse(start);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sdf.format(date);
//        Date date = new Date();
//        try {
//            date = new SimpleDateFormat("MM/dd/yyyy").parse(start);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        return date.toString();
    }
}
