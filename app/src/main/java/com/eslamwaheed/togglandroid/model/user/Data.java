package com.eslamwaheed.togglandroid.model.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Data implements Serializable {

    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("api_token")
    @Expose
    private String api_token;
    @SerializedName("default_wid")
    @Expose
    private long default_wid;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("fullname")
    @Expose
    private String fullname;
    @SerializedName("jquery_timeofday_format")
    @Expose
    private String jquery_timeofday_format;
    @SerializedName("jquery_date_format")
    @Expose
    private String jquery_date_format;
    @SerializedName("timeofday_format")
    @Expose
    private String timeofday_format;
    @SerializedName("date_format")
    @Expose
    private String date_format;
    @SerializedName("store_start_and_stop_time")
    @Expose
    private boolean store_start_and_stop_time;
    @SerializedName("beginning_of_week")
    @Expose
    private long beginning_of_week;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("image_url")
    @Expose
    private String image_url;
    @SerializedName("sidebar_piechart")
    @Expose
    private boolean sidebar_piechart;
    @SerializedName("at")
    @Expose
    private String at;
    @SerializedName("created_at")
    @Expose
    private String created_at;
    @SerializedName("retention")
    @Expose
    private long retention;
    @SerializedName("record_timeline")
    @Expose
    private boolean record_timeline;
    @SerializedName("render_timeline")
    @Expose
    private boolean render_timeline;
    @SerializedName("timeline_enabled")
    @Expose
    private boolean timeline_enabled;
    @SerializedName("timeline_experiment")
    @Expose
    private boolean timeline_experiment;
    @SerializedName("new_blog_post")
    @Expose
    private New_blog_post new_blog_post;
    @SerializedName("should_upgrade")
    @Expose
    private boolean should_upgrade;
    @SerializedName("achievements_enabled")
    @Expose
    private boolean achievements_enabled;
    @SerializedName("timezone")
    @Expose
    private String timezone;
    @SerializedName("openid_enabled")
    @Expose
    private boolean openid_enabled;
    @SerializedName("send_product_emails")
    @Expose
    private boolean send_product_emails;
    @SerializedName("send_weekly_report")
    @Expose
    private boolean send_weekly_report;
    @SerializedName("send_timer_notifications")
    @Expose
    private boolean send_timer_notifications;
    @SerializedName("last_blog_entry")
    @Expose
    private String last_blog_entry;
    @SerializedName("invitation")
    @Expose
    private Invitation invitation;
    @SerializedName("workspaces")
    @Expose
    private List<Workspace> workspaces = null;
    @SerializedName("duration_format")
    @Expose
    private String duration_format;
    @SerializedName("obm")
    @Expose
    private Obm obm;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getApi_token() {
        return api_token;
    }

    public void setApi_token(String api_token) {
        this.api_token = api_token;
    }

    public long getDefault_wid() {
        return default_wid;
    }

    public void setDefault_wid(long default_wid) {
        this.default_wid = default_wid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getJquery_timeofday_format() {
        return jquery_timeofday_format;
    }

    public void setJquery_timeofday_format(String jquery_timeofday_format) {
        this.jquery_timeofday_format = jquery_timeofday_format;
    }

    public String getJquery_date_format() {
        return jquery_date_format;
    }

    public void setJquery_date_format(String jquery_date_format) {
        this.jquery_date_format = jquery_date_format;
    }

    public String getTimeofday_format() {
        return timeofday_format;
    }

    public void setTimeofday_format(String timeofday_format) {
        this.timeofday_format = timeofday_format;
    }

    public String getDate_format() {
        return date_format;
    }

    public void setDate_format(String date_format) {
        this.date_format = date_format;
    }

    public boolean isStore_start_and_stop_time() {
        return store_start_and_stop_time;
    }

    public void setStore_start_and_stop_time(boolean store_start_and_stop_time) {
        this.store_start_and_stop_time = store_start_and_stop_time;
    }

    public long getBeginning_of_week() {
        return beginning_of_week;
    }

    public void setBeginning_of_week(long beginning_of_week) {
        this.beginning_of_week = beginning_of_week;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public boolean isSidebar_piechart() {
        return sidebar_piechart;
    }

    public void setSidebar_piechart(boolean sidebar_piechart) {
        this.sidebar_piechart = sidebar_piechart;
    }

    public String getAt() {
        return at;
    }

    public void setAt(String at) {
        this.at = at;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public long getRetention() {
        return retention;
    }

    public void setRetention(long retention) {
        this.retention = retention;
    }

    public boolean isRecord_timeline() {
        return record_timeline;
    }

    public void setRecord_timeline(boolean record_timeline) {
        this.record_timeline = record_timeline;
    }

    public boolean isRender_timeline() {
        return render_timeline;
    }

    public void setRender_timeline(boolean render_timeline) {
        this.render_timeline = render_timeline;
    }

    public boolean isTimeline_enabled() {
        return timeline_enabled;
    }

    public void setTimeline_enabled(boolean timeline_enabled) {
        this.timeline_enabled = timeline_enabled;
    }

    public boolean isTimeline_experiment() {
        return timeline_experiment;
    }

    public void setTimeline_experiment(boolean timeline_experiment) {
        this.timeline_experiment = timeline_experiment;
    }

    public New_blog_post getNew_blog_post() {
        return new_blog_post;
    }

    public void setNew_blog_post(New_blog_post new_blog_post) {
        this.new_blog_post = new_blog_post;
    }

    public boolean isShould_upgrade() {
        return should_upgrade;
    }

    public void setShould_upgrade(boolean should_upgrade) {
        this.should_upgrade = should_upgrade;
    }

    public boolean isAchievements_enabled() {
        return achievements_enabled;
    }

    public void setAchievements_enabled(boolean achievements_enabled) {
        this.achievements_enabled = achievements_enabled;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public boolean isOpenid_enabled() {
        return openid_enabled;
    }

    public void setOpenid_enabled(boolean openid_enabled) {
        this.openid_enabled = openid_enabled;
    }

    public boolean isSend_product_emails() {
        return send_product_emails;
    }

    public void setSend_product_emails(boolean send_product_emails) {
        this.send_product_emails = send_product_emails;
    }

    public boolean isSend_weekly_report() {
        return send_weekly_report;
    }

    public void setSend_weekly_report(boolean send_weekly_report) {
        this.send_weekly_report = send_weekly_report;
    }

    public boolean isSend_timer_notifications() {
        return send_timer_notifications;
    }

    public void setSend_timer_notifications(boolean send_timer_notifications) {
        this.send_timer_notifications = send_timer_notifications;
    }

    public String getLast_blog_entry() {
        return last_blog_entry;
    }

    public void setLast_blog_entry(String last_blog_entry) {
        this.last_blog_entry = last_blog_entry;
    }

    public Invitation getInvitation() {
        return invitation;
    }

    public void setInvitation(Invitation invitation) {
        this.invitation = invitation;
    }

    public List<Workspace> getWorkspaces() {
        return workspaces;
    }

    public void setWorkspaces(List<Workspace> workspaces) {
        this.workspaces = workspaces;
    }

    public String getDuration_format() {
        return duration_format;
    }

    public void setDuration_format(String duration_format) {
        this.duration_format = duration_format;
    }

    public Obm getObm() {
        return obm;
    }

    public void setObm(Obm obm) {
        this.obm = obm;
    }

}
