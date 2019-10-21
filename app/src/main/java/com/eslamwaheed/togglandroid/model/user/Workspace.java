
package com.eslamwaheed.togglandroid.model.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Workspace implements Serializable {

    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("profile")
    @Expose
    private long profile;
    @SerializedName("premium")
    @Expose
    private boolean premium;
    @SerializedName("admin")
    @Expose
    private boolean admin;
    @SerializedName("default_hourly_rate")
    @Expose
    private long default_hourly_rate;
    @SerializedName("default_currency")
    @Expose
    private String default_currency;
    @SerializedName("only_admins_may_create_projects")
    @Expose
    private boolean only_admins_may_create_projects;
    @SerializedName("only_admins_see_billable_rates")
    @Expose
    private boolean only_admins_see_billable_rates;
    @SerializedName("only_admins_see_team_dashboard")
    @Expose
    private boolean only_admins_see_team_dashboard;
    @SerializedName("projects_billable_by_default")
    @Expose
    private boolean projects_billable_by_default;
    @SerializedName("rounding")
    @Expose
    private long rounding;
    @SerializedName("rounding_minutes")
    @Expose
    private long rounding_minutes;
    @SerializedName("api_token")
    @Expose
    private String api_token;
    @SerializedName("at")
    @Expose
    private String at;
    @SerializedName("ical_enabled")
    @Expose
    private boolean ical_enabled;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getProfile() {
        return profile;
    }

    public void setProfile(long profile) {
        this.profile = profile;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public long getDefault_hourly_rate() {
        return default_hourly_rate;
    }

    public void setDefault_hourly_rate(long default_hourly_rate) {
        this.default_hourly_rate = default_hourly_rate;
    }

    public String getDefault_currency() {
        return default_currency;
    }

    public void setDefault_currency(String default_currency) {
        this.default_currency = default_currency;
    }

    public boolean isOnly_admins_may_create_projects() {
        return only_admins_may_create_projects;
    }

    public void setOnly_admins_may_create_projects(boolean only_admins_may_create_projects) {
        this.only_admins_may_create_projects = only_admins_may_create_projects;
    }

    public boolean isOnly_admins_see_billable_rates() {
        return only_admins_see_billable_rates;
    }

    public void setOnly_admins_see_billable_rates(boolean only_admins_see_billable_rates) {
        this.only_admins_see_billable_rates = only_admins_see_billable_rates;
    }

    public boolean isOnly_admins_see_team_dashboard() {
        return only_admins_see_team_dashboard;
    }

    public void setOnly_admins_see_team_dashboard(boolean only_admins_see_team_dashboard) {
        this.only_admins_see_team_dashboard = only_admins_see_team_dashboard;
    }

    public boolean isProjects_billable_by_default() {
        return projects_billable_by_default;
    }

    public void setProjects_billable_by_default(boolean projects_billable_by_default) {
        this.projects_billable_by_default = projects_billable_by_default;
    }

    public long getRounding() {
        return rounding;
    }

    public void setRounding(long rounding) {
        this.rounding = rounding;
    }

    public long getRounding_minutes() {
        return rounding_minutes;
    }

    public void setRounding_minutes(long rounding_minutes) {
        this.rounding_minutes = rounding_minutes;
    }

    public String getApi_token() {
        return api_token;
    }

    public void setApi_token(String api_token) {
        this.api_token = api_token;
    }

    public String getAt() {
        return at;
    }

    public void setAt(String at) {
        this.at = at;
    }

    public boolean isIcal_enabled() {
        return ical_enabled;
    }

    public void setIcal_enabled(boolean ical_enabled) {
        this.ical_enabled = ical_enabled;
    }

}
