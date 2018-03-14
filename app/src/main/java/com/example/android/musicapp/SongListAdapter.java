package com.example.android.musicapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongListAdapter extends ArrayAdapter<SongList>  {

    public SongListAdapter(Context context, ArrayList<SongList> songs) {
        super(context, 0, songs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        SongList currentSong = getItem(position);

        TextView songTitle = listItemView.findViewById(R.id.song_name);
        songTitle.setText(currentSong.getSongTitle());

        TextView songArtist = listItemView.findViewById(R.id.song_artist);
        songArtist.setText(currentSong.getSongArtist());

        ImageView iconView = listItemView.findViewById(R.id.song_icon);
        iconView.setImageResource(currentSong.getSongImage());

        return listItemView;
    }
}
