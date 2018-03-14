package com.example.android.musicapp;

public class SongList {

    private String mSongTitle;
    private String mSongArtist;
    private int mSongImage;

    public SongList(String songTitle, String songArtist, int songImage) {
        mSongTitle = songTitle;
        mSongArtist = songArtist;
        mSongImage = songImage;
    }

    public String getSongTitle() {
        return mSongTitle;
    }

    public String getSongArtist() {
        return mSongArtist;
    }

    public int getSongImage() {
        return mSongImage;
    }

}
