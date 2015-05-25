package com.mccorby.paytouchchallenge.datasource.api.entities;

import com.google.gson.annotations.SerializedName;
import com.mccorby.paytouchchallenge.domain.entities.Work;

import java.util.List;

/**
 * Created by JAC on 18/05/2015.
 */
public class ApiActor {

    @SerializedName("identifier")
    public Integer mIdentifier;
    @SerializedName("name")
    private String mName;
    @SerializedName("profile_path")
    private String mProfileImageUrl;
    @SerializedName("location")
    private String mLocation;
    @SerializedName("description")
    private String mDescription;
    @SerializedName("adult")
    private boolean isAdult;
    @SerializedName("known_for")
    private List<ApiWork> mKnownFor;

    public Integer getIdentifier() {
        return mIdentifier;
    }

    public void setIdentifier(Integer identifier) {
        mIdentifier = identifier;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getProfileImageUrl() {
        return mProfileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        mProfileImageUrl = profileImageUrl;
    }

    public String getLocation() {
        return mLocation;
    }

    public void setLocation(String location) {
        mLocation = location;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public boolean isAdult() {
        return isAdult;
    }

    public void setIsAdult(boolean isAdult) {
        this.isAdult = isAdult;
    }

    public List<ApiWork> getKnownFor() {
        return mKnownFor;
    }

    public void setKnownFor(List<ApiWork> knownFor) {
        mKnownFor = knownFor;
    }

    @Override
    public String toString() {
        return "ApiActor{" +
                "mIdentifier=" + mIdentifier +
                ", mName='" + mName + '\'' +
                ", mProfileImageUrl='" + mProfileImageUrl + '\'' +
                ", mLocation='" + mLocation + '\'' +
                ", mDescription='" + mDescription + '\'' +
                ", isAdult=" + isAdult +
                ", mKnownFor=" + mKnownFor +
                '}';
    }
}
