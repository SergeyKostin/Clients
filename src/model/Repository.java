package model;

import java.util.ArrayList;

public interface Repository {
    Track getTrackByName(String name);
    Track findTrackByName(String name);
    ArrayList<Track> scanForTracks(String path);
}
