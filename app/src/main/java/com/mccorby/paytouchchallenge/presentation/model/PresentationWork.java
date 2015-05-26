package com.mccorby.paytouchchallenge.presentation.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by JAC on 18/05/2015.
 */
public class PresentationWork implements Parcelable{
    public enum MediaTypes {
        MOVIE
    }

    private boolean isAdult;
    private String mBackdropUrl;
    private Integer mIdentifier;
    private String mOriginalTitle;
    private long mReleaseDate;
    private String mPosterUrl;
    private float mPopularity;
    private String mTitle;
    private boolean hasVideo;
    private float mVoteAverage;
    private int mVoteCount;
    private MediaTypes mMediaType;

    public PresentationWork() {

    }

    /*=============================
     * GETTERS AND SETTERS
     =============================*/

    public boolean isAdult() {
        return isAdult;
    }

    public void setIsAdult(boolean isAdult) {
        this.isAdult = isAdult;
    }

    public String getBackdropUrl() {
        return mBackdropUrl;
    }

    public void setBackdropUrl(String backdropUrl) {
        mBackdropUrl = backdropUrl;
    }

    public Integer getIdentifier() {
        return mIdentifier;
    }

    public void setIdentifier(Integer identifier) {
        mIdentifier = identifier;
    }

    public String getOriginalTitle() {
        return mOriginalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        mOriginalTitle = originalTitle;
    }

    public long getReleaseDate() {
        return mReleaseDate;
    }

    public void setReleaseDate(long releaseDate) {
        mReleaseDate = releaseDate;
    }

    public String getPosterUrl() {
        return mPosterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        mPosterUrl = posterUrl;
    }

    public float getPopularity() {
        return mPopularity;
    }

    public void setPopularity(float popularity) {
        mPopularity = popularity;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public boolean isHasVideo() {
        return hasVideo;
    }

    public void setHasVideo(boolean hasVideo) {
        this.hasVideo = hasVideo;
    }

    public float getVoteAverage() {
        return mVoteAverage;
    }

    public void setVoteAverage(float voteAverage) {
        mVoteAverage = voteAverage;
    }

    public int getVoteCount() {
        return mVoteCount;
    }

    public void setVoteCount(int voteCount) {
        mVoteCount = voteCount;
    }

    public MediaTypes getMediaType() {
        return mMediaType;
    }

    public void setMediaType(MediaTypes mediaType) {
        mMediaType = mediaType;
    }
    
    /*===========================
     * Parcelable required methods
     */

    public static final Parcelable.Creator<PresentationWork> CREATOR
            = new Parcelable.Creator<PresentationWork>() {
        public PresentationWork createFromParcel(Parcel in) {
            return new PresentationWork(in);
        }

        public PresentationWork[] newArray(int size) {
            return new PresentationWork[size];
        }
    };

    private PresentationWork(Parcel in) {
        mIdentifier = in.readInt();
        mOriginalTitle = in.readString();
        mBackdropUrl = in.readString();
        mReleaseDate = in.readLong();
        mPosterUrl = in.readString();
        mPopularity = in.readFloat();
        mTitle = in.readString();
        hasVideo = in.readInt() > 0 ? true : false;
        mVoteAverage = in.readFloat();
        mVoteCount = in.readInt();
        isAdult = in.readInt() > 0 ? true : false;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mIdentifier);
        dest.writeString(mOriginalTitle);
        dest.writeString(mBackdropUrl);
        dest.writeLong(mReleaseDate);
        dest.writeString(mPosterUrl);
        dest.writeFloat(mPopularity);
        dest.writeString(mTitle);
        dest.writeInt(hasVideo ? 1 : 0);
        dest.writeFloat(mVoteAverage);
        dest.writeInt(mVoteCount);
        dest.writeInt(isAdult ? 1 : 0);
    }

    @Override
    public int describeContents() {
        return 0;
    }

}
