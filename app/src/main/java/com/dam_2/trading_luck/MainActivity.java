package com.dam_2.trading_luck;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Animation compAnim;

    private ImageView rotImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        compAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);

        rotImage = findViewById(R.id.imageView8);

        rotImage.startAnimation(compAnim);




    }











    public void btnBuy(View v){
        String value="Buy";
        Intent i = new Intent(this, MainActivity_graph.class);
        i.putExtra("key",value);
        startActivity(i);
    }
    public void btnSell(View v){
        String value="Sell";
        Intent i = new Intent(this, MainActivity_graph.class);
        i.putExtra("key",value);
        startActivity(i);
    }

}