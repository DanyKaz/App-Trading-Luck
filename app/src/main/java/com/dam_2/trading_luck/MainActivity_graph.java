package com.dam_2.trading_luck;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.net.Uri;
import android.widget.VideoView;
import android.media.MediaPlayer;
import android.widget.MediaController;

import java.util.Random;

public class MainActivity_graph extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_graph);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Random rn = new Random();
        int num = rn.nextInt(2);
        switch (num){
            case 0:
                VideoView videoView = findViewById(R.id.videoView);

                Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.angood);
                videoView.setVideoURI(videoUri);

                MediaController mediaController = new MediaController(this);
                videoView.setMediaController(mediaController);
                mediaController.setAnchorView(videoView);

                videoView.start();

                videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        // Действие после завершения воспроизведения
                    }
                });

                videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                    @Override
                    public boolean onError(MediaPlayer mp, int what, int extra) {
                        return true;
                    }
                });
                break;
            case 1:
                VideoView videoView1 = findViewById(R.id.videoView);

                Uri videoUri1 = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.anbad);
                videoView1.setVideoURI(videoUri1);

                MediaController mediaController1 = new MediaController(this);
                videoView1.setMediaController(mediaController1);
                mediaController1.setAnchorView(videoView1);

                videoView1.start();

                videoView1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        // Действие после завершения воспроизведения
                    }
                });

                videoView1.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                    @Override
                    public boolean onError(MediaPlayer mp, int what, int extra) {
                        return true;
                    }
                });
                break;

        }

    }


}
