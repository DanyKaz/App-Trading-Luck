package com.dam_2.trading_luck;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Random;

public class MainActivity_graph extends AppCompatActivity {

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

        String value = getIntent().getStringExtra("key");

        Random rn = new Random();
        int num = rn.nextInt(2);
        switch (num){
            case 0:
                VideoView videoView = findViewById(R.id.videoView);
                Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.angood);
                videoView.setVideoURI(videoUri);
                videoView.start();

                String finalValue1 = value;
                videoView.setOnCompletionListener(mp -> {
                    Intent intent;
                    if (finalValue1.equals("Buy")) {
                        intent = new Intent(MainActivity_graph.this, MainActivity_profit.class);
                    } else {
                        intent = new Intent(MainActivity_graph.this, MainActivity2.class);
                    }
                    startActivity(intent);
                });

                videoView.setOnErrorListener((mp, what, extra) -> true);
                break;
            case 1:
                VideoView videoView1 = findViewById(R.id.videoView);
                Uri videoUri1 = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.anbad);
                videoView1.setVideoURI(videoUri1);
                videoView1.start();

                String finalValue2 = value;
                videoView1.setOnCompletionListener(mp -> {
                    Intent intent;
                    if (finalValue2.equals("Buy")) {
                        intent = new Intent(MainActivity_graph.this, MainActivity2.class);
                    } else {
                        intent = new Intent(MainActivity_graph.this, MainActivity_profit.class);
                    }
                    startActivity(intent);
                });

                videoView1.setOnErrorListener((mp, what, extra) -> true);
                break;
        }
    }
}
