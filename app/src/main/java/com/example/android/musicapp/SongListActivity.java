package com.example.android.musicapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class SongListActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        final ArrayList<SongList> songs = new ArrayList<>();
        songs.add(new SongList("Title 1", "Artist 1", R.drawable.songicon));
        songs.add(new SongList("Title 2", "Artist 2", R.drawable.songicon));
        songs.add(new SongList("Title 3", "Artist 3", R.drawable.songicon));
        songs.add(new SongList("Title 4", "Artist 4", R.drawable.songicon));
        songs.add(new SongList("Title 5", "Artist 5", R.drawable.songicon));
        songs.add(new SongList("Title 6", "Artist 6", R.drawable.songicon));
        songs.add(new SongList("Title 7", "Artist 7", R.drawable.songicon));
        songs.add(new SongList("Title 8", "Artist 8", R.drawable.songicon));
        songs.add(new SongList("Title 9", "Artist 9", R.drawable.songicon));
        songs.add(new SongList("Title 10", "Artist 10", R.drawable.songicon));
        songs.add(new SongList("Title 11", "Artist 11", R.drawable.songicon));
        songs.add(new SongList("Title 12", "Artist 12", R.drawable.songicon));

        final SongListAdapter adapter = new SongListAdapter(this, songs);

        final ListView listView = findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                SongList song = adapter.getItem(position);
                i.putExtra("song_artist", song.getSongArtist());
                i.putExtra("song_title", song.getSongTitle());
                i.putExtra("icon", song.getSongImage());
                setResult(Activity.RESULT_OK, i);
                finish();
                }
            }
        );

        Button goBack = findViewById(R.id.back);

        goBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent songListIntent = new Intent(SongListActivity.this, MainActivity.class);
                startActivityForResult(songListIntent, 1);
            }
        });
    }
}
