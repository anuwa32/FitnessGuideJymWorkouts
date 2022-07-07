package com.example.myapplication4;


import androidx.appcompat.app.AppCompatActivity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;
public class Videostream extends AppCompatActivity {

    VideoView videoView;
    MediaController mediaController;
    String url = "https://firebasestorage.googleapis.com/v0/b/jymwork-a4fd1.appspot.com/o/videoplayback.mp4?alt=media&token=14f4b881-4571-4ee3-bb7e-b646cbc79701";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videostream);
        videoView = findViewById(R.id.videoView);
        Uri uri = Uri.parse(url);
        videoView.setVideoURI(uri);
        mediaController = new MediaController(this);
        mediaController.setMediaPlayer(videoView);
        videoView.setMediaController(mediaController);
        videoView.requestFocus();
        videoView.start();
    }
}

