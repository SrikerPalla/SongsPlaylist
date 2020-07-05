package com.sriker;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private ArrayList<Song> songsList;

    public Album(String name) {
        this.name = name;
        this.songsList = new ArrayList<Song>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Song> getSongsList() {
        return songsList;
    }

    public boolean addSong(String songTitle, double duration){
        if(findSong(songTitle) == null){
            Song newSong = new Song(songTitle, duration);
            this.songsList.add(newSong);
            return true;
        }
        System.out.println(songTitle + " song is already added to the album ");
        return false;
    }

    public Song findSong(String songTitle){
        for(int i=0; i<this.songsList.size(); i++){
            Song song = this.songsList.get(i);
            if(song.getTitle().equals(songTitle)){
                return song;
            }
        }
        return null;
    }

    public boolean addToPlayList(String songTitle, LinkedList<Song> playList){
        if(findSong(songTitle) != null){
            Song song = findSong(songTitle);
            playList.add(song);
            return true;
        }
        System.out.println(songTitle + " is not found so cannot be added to the playist ");
        return false;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList){
        int index = trackNumber - 1;
        if(index>=0 && index<=this.songsList.size()){
            playList.add(this.songsList.get(index));
            return true;
        }
        System.out.println(trackNumber + " is not found so cannot be added to the playist ");
        return false;
    }
}
