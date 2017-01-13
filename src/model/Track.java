package model;

import java.io.Serializable;

public class Track implements Serializable {
    private final String NAME_OF_TRACK = "Unknown";
    private final String ALBUM = "Unknown";
    private final String BAND = "Unknown";
    private final String DURATION = "Unknown";
    private final String GENRE = "Unknown";
    private String nameOfTrack;
    private String album;
    private String band;
    private String duration;
    private String genre;

    public Track() {
        this.nameOfTrack = this.NAME_OF_TRACK;
        this.album = this.ALBUM;
        this.band = this.BAND;
        this.duration = this.DURATION;
        this.genre = this.GENRE;
    }

    public Track(String nameOfTrack, String album, String band, String duration,String genre) {
        this.nameOfTrack = nameOfTrack;
        this.album = album;
        this.band = band;
        this.duration = duration;
        this.genre = genre;
    }

    public String getName() {
        return this.nameOfTrack;
    }

    public String getAlbum() {
        return this.album;
    }

    public String getBand() {
        return this.band;
    }

    public String getDuration() {
        return this.duration;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setName(String nameOfTrack) {
        this.nameOfTrack = nameOfTrack;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}

