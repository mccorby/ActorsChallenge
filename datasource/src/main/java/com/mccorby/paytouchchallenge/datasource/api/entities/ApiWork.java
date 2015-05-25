package com.mccorby.paytouchchallenge.datasource.api.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by JAC on 18/05/2015.
 */
public class ApiWork {

    @SerializedName("adult")
    private boolean isAdult;
    @SerializedName("backdrop_path")
    private String mBackdropUrl;
    @SerializedName("id")
    private Integer mIdentifier;
    @SerializedName("origintal_title")
    private String mOriginalTitle;
    @SerializedName("release_date")
    private long mReleaseDate;
    @SerializedName("poster_path")
    private String mPosterUrl;
    @SerializedName("popularity")
    private float mPopularity;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("video")
    private boolean hasVideo;
    @SerializedName("vote_average")
    private float mVoteAverage;
    @SerializedName("vote_count")
    private int mVoteCount;
    @SerializedName("media_type")
    private String mMediaType;

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

    public String getMediaType() {
        return mMediaType;
    }

    public void setMediaType(String mediaType) {
        mMediaType = mediaType;
    }
}
