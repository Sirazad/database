package com.codecool.database;

public class RadioCharts {
    private final String password;
    private final String user;
    private final String url;

    public RadioCharts(String url, String user, String password) {
        this.url=url;
        this.user = user;
        this.password = password;
    }

    public String getMostPlayedSong(){
        String mostPlayedSong = "";
        // cím, név
        return mostPlayedSong;
    }

    public String getMostActiveArtist(){
        String mostPlayedArtist = "";
        // előadó neve, akinek a legtöbb száma
        return mostPlayedArtist;
    }

}
