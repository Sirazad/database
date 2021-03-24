package com.codecool.database;

import com.sun.source.tree.UsesTree;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RadioCharts <T> {
    private final String password;
    private final String user;
    private final String url;

    public RadioCharts(String url, String user, String password) {
        this.url=url;
        this.user = user;
        this.password = password;
    }

    public String getMostPlayedSong() {
        String mostPlayedSong = "";
        List<Song> songs = new ArrayList();

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String SQL = "SELECT song, SUM(times_aired) as times_aired FROM music_broadcast GROUP BY song";
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(SQL);

            int mostPlayed = 0;

            while (results.next()) {
                int currentPlayed = results.getInt("times_aired");
                if ((currentPlayed > mostPlayed) && mostPlayedSong.equals("")) {
                    mostPlayed = currentPlayed;
                    mostPlayedSong = results.getString("song");
                } else if ((currentPlayed > mostPlayed)) {

                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return mostPlayedSong;
    }

    public String getMostActiveArtist(){
        String mostPlayedArtist = "";
        // előadó neve, akinek a legtöbb száma
        return mostPlayedArtist;
    }

}
