package com.mccorby.paytouchchallenge.presentation.model;

import java.util.List;

/**
 * Created by JAC on 18/05/2015.
 */
public class PresentationActor implements Parcelable {

    private Integer mIdentifier;
    private String mName;
    private String mProfileImageUrl;
    private String mLocation;
    private String mDescription;
    private boolean isAdult;
    private float mPopularity;

    private List<PresentationWork> mKnownFor;

    /*=============================
     * GETTERS AND SETTERS
     =============================*/


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

    public List<PresentationWork> getKnownFor() {
        return mKnownFor;
    }

    public void setKnownFor(List<PresentationWork> knownFor) {
        mKnownFor = knownFor;
    }

    public float getPopularity() {
        return mPopularity;
    }

    public void setPopularity(float popularity) {
        mPopularity = popularity;
    }
}
