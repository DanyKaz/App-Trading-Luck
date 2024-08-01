package com.dam_2.trading_luck;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Animation compAnim;

    private ImageView rotImage;
    private ImageButton btn1;
    private ImageButton btn2;
    SharedPreferences settings;
    SharedPreferences.Editor editor;
    private static final String FILE_NAME = "MY_FILE_NAME";
    private static final String CHACKED_SWITCH = "CHACKED_SWITCH";
    private static final String CHACKED_SWITCH2 = "CHACKED_SWITCH2";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        settings = getSharedPreferences(FILE_NAME, MODE_PRIVATE);
        int checkedSwitch = settings.getInt(CHACKED_SWITCH, 0);
        btn1 = findViewById(R.id.imageButton2);
        btn2 = findViewById(R.id.imageButton3);
        if(checkedSwitch == 1){
            btn1.setImageResource(R.drawable.rubuy);
            btn2.setImageResource(R.drawable.rusell);
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });





        compAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);

        rotImage = findViewById(R.id.imageView8);

        rotImage.startAnimation(compAnim);













    }





    public void getSound(){
           int checkedSwitch2 = settings.getInt(CHACKED_SWITCH2, 0);
           if(checkedSwitch2 == 1){
               MediaPlayer mp = MediaPlayer.create(this, R.raw.tap);
               mp.start();

           }
   }





    public void btnBuy(View v){

        String value="Buy";
        Intent i = new Intent(this, MainActivity_graph.class);
        i.putExtra("key",value);
        startActivity(i);
        getSound();
    }
    public void btnSell(View v){

        String value="Sell";
        Intent i = new Intent(this, MainActivity_graph.class);
        i.putExtra("key",value);
        startActivity(i);
        getSound();
    }
    public void btnSet(View v){

        Settings settings = new Settings();
        settings.show(getSupportFragmentManager(), "TAG");
        getSound();

    }


}