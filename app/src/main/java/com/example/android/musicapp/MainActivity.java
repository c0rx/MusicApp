package com.example.android.musicapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView top = findViewById(R.id.top);
        top.setImageResource(R.drawable.music);

        ImageView previous = findViewById(R.id.previous);
        previous.setImageResource(android.R.drawable.ic_media_previous);

        ImageView play = findViewById(R.id.play);
        play.setImageResource(android.R.drawable.ic_media_play);

        ImageView right = findViewById(R.id.right);
        right.setImageResource(android.R.drawable.ic_media_next);

        Button songList = findViewById(R.id.button);

        songList.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent songListIntent = new Intent(MainActivity.this, SongListActivity.class);
                startActivityForResult(songListIntent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent i) {

        if (requestCode == 1) {
            if(resultCode == RESULT_OK){
                TextView pos = findViewById(R.id.song_name);
                String artist = i.getStringExtra("song_artist");
                String title = i.getStringExtra("song_title");
                int icon = i.getIntExtra("icon", 0);
                pos.setText("Now playing: " + title + " by " + artist);

                Drawable img = ContextCompat.getDrawable(this, icon);
                img.setBounds(0, 0, 150, 150);
                pos.setCompoundDrawables(img, null, null, null);

            }
            if (resultCode == Activity.RESULT_CANCELED) {

                TextView pos2 = findViewById(R.id.song_name);
                pos2.setText("Error - not found");

                }
            }
        }
    }
