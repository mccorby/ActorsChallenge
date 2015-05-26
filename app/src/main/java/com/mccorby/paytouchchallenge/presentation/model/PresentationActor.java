package com.mccorby.paytouchchallenge.presentation.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
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

    public PresentationActor(){

    }



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

    @Override
    public String toString() {
        return "PresentationActor{" +
                "mIdentifier=" + mIdentifier +
                ", mName='" + mName + '\'' +
                ", mProfileImageUrl='" + mProfileImageUrl + '\'' +
                ", mLocation='" + mLocation + '\'' +
                ", mDescription='" + mDescription + '\'' +
                ", isAdult=" + isAdult +
                ", mPopularity=" + mPopularity +
                ", mKnownFor=" + mKnownFor +
                '}';
    }

    /*===========================
    Parcelable required methods
     */

    public static final Parcelable.Creator<PresentationActor> CREATOR
            = new Parcelable.Creator<PresentationActor>() {
        public PresentationActor createFromParcel(Parcel in) {
            return new PresentationActor(in);
        }

        public PresentationActor[] newArray(int size) {
            return new PresentationActor[size];
        }
    };

    private PresentationActor(Parcel in) {
        mIdentifier = in.readInt();
        mName = in.readString();
        mProfileImageUrl = in.readString();
        mLocation = in.readString();
        mDescription = in.readString();
        isAdult = in.readInt() > 0 ? true : false;
        mPopularity = in.readFloat();
        mKnownFor = new ArrayList<>();
        in.readList(mKnownFor, PresentationActor.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mIdentifier);
        dest.writeString(mName);
        dest.writeString(mProfileImageUrl);
        dest.writeString(mLocation);
        dest.writeString(mDescription);
        dest.writeInt(isAdult ? 1 : 0);
        dest.writeFloat(mPopularity);
        dest.writeList(mKnownFor);
    }

    @Override
    public int describeContents() {
        return 0;
    }


}
