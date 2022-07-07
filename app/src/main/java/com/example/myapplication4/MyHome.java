package com.example.myapplication4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MyHome extends AppCompatActivity {

    private Button btn1;   //Assign variables for buttons
    private Button btn2;
    private Button btn3;
    private Button btn_play;
    VideoView videoView;
    MediaController mediaController;
    String video = "https://firebasestorage.googleapis.com/v0/b/jymwork-a4fd1.appspot.com/o/videoplayback.mp4?alt=media&token=14f4b881-4571-4ee3-bb7e-b646cbc79701";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_home);

        //redirect to the MyHomeChest page

        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openMyHomeChest();
            }
        });

        //redirect th the MyHomeArms page

        btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openMyHomeArms();
            }
        });


        //redirect the the MyHomeLegs page

        btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openMyHomeLegs();

            }
        });

        btn_play = findViewById(R.id.btn_play);
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MyHome.this, Videostream.class));
            }
        });

    }

    public void openMyHomeChest() {
        Intent intent = new Intent(this, MyHomeChest.class);   //redirect to the MyHomeChest page
        startActivity(intent);
    }

    public void openMyHomeArms() {

        Intent intent = new Intent(this, MyHomeArms.class);   //redirect to the MyHomeChest page
        startActivity(intent);
    }

    public void openMyHomeLegs() {

        Intent intent = new Intent(this, MyHomeLegs.class);   //redirect to the MyHomeLegs page
        startActivity(intent);

    }


    public void videoplay(View view) {


        class Videostream extends AppCompatActivity {
            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_videostream);
                videoView = findViewById(R.id.videoView);
                Uri uri = Uri.parse(video);
                videoView.setVideoURI(uri);
                mediaController = new MediaController(this);
                mediaController.setMediaPlayer(videoView);
                videoView.setMediaController(mediaController);
                videoView.requestFocus();
                videoView.start();
            }


        }
    }
}