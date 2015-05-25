package com.mccorby.paytouchchallenge.domain.entities;

import java.util.List;

/**
 * A POJO representing an actor in the domain of this system.
 */
public class Actor {
    private Integer mIdentifier;
    private String mName;
    private String mProfileImageUrl;
    private String mLocation;
    private String mDescription;
    private boolean isAdult;

    private List<Work> mKnownFor;


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

    public List<Work> getKnownFor() {
        return mKnownFor;
    }

    public void setKnownFor(List<Work> knownFor) {
        mKnownFor = knownFor;
    }
}
