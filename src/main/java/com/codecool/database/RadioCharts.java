package com.codecool.database;

import java.sql.*;

public class RadioCharts <T> {
    private final String password;
    private final String user;
    private final String url;

    public RadioCharts(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public String getMostPlayedSong() {
        String mostPlayedSong = "";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String SQL = "SELECT song, SUM(times_aired) as times_aired FROM music_broadcast GROUP BY song";
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(SQL);

            int mostPlayed = 0;

            while (results.next()) {
                int currentPlayed = results.getInt("times_aired");
                if ((currentPlayed > mostPlayed) || ((currentPlayed == mostPlayed) && mostPlayedSong.equals(""))) {
                    mostPlayed = currentPlayed;
                    mostPlayedSong = results.getString("song");
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return mostPlayedSong;
    }

    public String getMostActiveArtist() {
        String mostPlayedArtist = "";
        int mostPlayedSongCount = 0;

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String SQL = "SELECT artist, COUNT(DISTINCT song) as song_count FROM music_broadcast GROUP BY artist";
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(SQL);
            while (results.next()) {
                int currentSongCount = results.getInt("song_count");
                if ((currentSongCount > mostPlayedSongCount) || ((currentSongCount == mostPlayedSongCount) && mostPlayedArtist.equals(""))) {
                    mostPlayedSongCount = currentSongCount;
                    mostPlayedArtist = results.getString("artist");
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return mostPlayedArtist;
    }
}