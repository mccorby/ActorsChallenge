package com.mccorby.paytouchchallenge.presentation.model;

/**
 * Created by JAC on 18/05/2015.
 */
public class PresentationWork {
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

}
