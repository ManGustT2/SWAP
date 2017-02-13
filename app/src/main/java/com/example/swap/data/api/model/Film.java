package com.example.swap.data.api.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Администратор on 14.12.2016.
 */
public class Film{


    private @SerializedName("title") String title;
    private @SerializedName("episode_id") int episodeid;
    private @SerializedName("opening_crawl") String opening_crawl;
    private @SerializedName("release_date") String release_date;

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getOpening_crawl() {
        return opening_crawl;
    }

    public void setOpening_crawl(String opening_crawl) {
        this.opening_crawl = opening_crawl;
    }

    public int getEpisode_id() {
        return episodeid;
    }

    public void setEpisode_id(int episode_id) {
        this.episodeid = episode_id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

}
