package io.everybodybloops.bloop.bloop;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import io.everybodybloops.bloop.bloop.MediaPlayerController;

import io.everybodybloops.bloop.bloop.MediaPlayerController;

public class Connected extends AppCompatActivity {
    String soundurl = "http://everybody-bloops.herokuapp.com/sound/bloop.mp3";
    MediaPlayer mp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connected);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.bloop);
        //final MediaPlayerController mpc = new MediaPlayerController(getApplicationContext());
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Button playbutton = (Button) findViewById(R.id.playButton);
        playbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(mp);
            }
        });
    }


    public void playSound(MediaPlayer mp){
        mp.start();
    }
    //figure out why the application crashes when you try and release the mediaplayer.
    protected void onPause(){
        this.mp.release();
        this.mp = null;
    }

    protected void onDestroy(){
        this.mp.release();
        this.mp = null;
    }
}
