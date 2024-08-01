package com.dam_2.trading_luck;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    SharedPreferences settings;
    SharedPreferences.Editor editor;
    private static final String FILE_NAME = "MY_FILE_NAME";
    private static final String CHACKED_SWITCH = "CHACKED_SWITCH";
    private static final String CHACKED_SWITCH2 = "CHACKED_SWITCH2";
    private ImageView btn1;
    private ImageButton btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        settings = getSharedPreferences(FILE_NAME, MODE_PRIVATE);
        int checkedSwitch = settings.getInt(CHACKED_SWITCH, 0);
        btn1 = findViewById(R.id.imageView);
        btn2 = findViewById(R.id.imageButton);
        switch (checkedSwitch){
            case 0:
                btn1.setImageResource(R.drawable.red_loss);
                btn2.setImageResource(R.drawable.but5);
                break;
            case 1:
                btn1.setImageResource(R.drawable.ruloss);
                btn2.setImageResource(R.drawable.ruback);
                break;
        }
        int checkedSwitch2 = settings.getInt(CHACKED_SWITCH2, 0);
        if(checkedSwitch2 == 1){
            MediaPlayer mp = MediaPlayer.create(this, R.raw.bad);
            mp.start();

        }

    }
    public void btnBack(View v){
        int checkedSwitch2 = settings.getInt(CHACKED_SWITCH2, 0);
        if(checkedSwitch2 == 1){
            MediaPlayer mp = MediaPlayer.create(this, R.raw.tap);
            mp.start();

        }
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);


    }

}