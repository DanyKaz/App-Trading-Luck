package com.dam_2.trading_luck;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class Settings extends BottomSheetDialogFragment {
    public Settings() {
    }
    SharedPreferences settings;
    SharedPreferences.Editor editor;
    private static final String FILE_NAME = "MY_FILE_NAME";
    private static final String CHACKED_SWITCH = "CHACKED_SWITCH";




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.settings, container, false);
        settings = getContext().getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        int checkedSwitch = settings.getInt(CHACKED_SWITCH, 0);
        ImageView picLang = (ImageView)view.findViewById(R.id.imageView6);
        ImageView picVol = (ImageView)view.findViewById(R.id.imageView7);
        ImageView picSound = (ImageView)view.findViewById(R.id.imageView10);




        Switch lang = (Switch) view.findViewById(R.id.switch1);
        switch(checkedSwitch){
            case 0:

                picLang.setImageResource(R.drawable.language);
                picVol.setImageResource(R.drawable.sound);
                picSound.setImageResource(R.drawable.volume);
                lang.setChecked(false);
                break;
            case 1:

                picLang.setImageResource(R.drawable.rulan);
                picVol.setImageResource(R.drawable.ruvoice);
                picSound.setImageResource(R.drawable.rusound);
                lang.setChecked(true);
                break;
        }
        lang.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                editor = settings.edit();
                ImageButton btn1 = getActivity().findViewById(R.id.imageButton2);
                ImageButton btn2 = getActivity().findViewById(R.id.imageButton3);
                ImageView picLang = (ImageView)view.findViewById(R.id.imageView6);
                ImageView picVol = (ImageView)view.findViewById(R.id.imageView7);
                ImageView picSound = (ImageView)view.findViewById(R.id.imageView10);





                if (isChecked) {
                    picLang.setImageResource(R.drawable.rulan);
                    picVol.setImageResource(R.drawable.ruvoice);
                    picSound.setImageResource(R.drawable.rusound);

                    btn1.setImageResource(R.drawable.rubuy);
                    btn2.setImageResource(R.drawable.rusell);
                    editor.putInt(CHACKED_SWITCH, 1);


                }else{
                    picLang.setImageResource(R.drawable.language);
                    picVol.setImageResource(R.drawable.sound);
                    picSound.setImageResource(R.drawable.volume);



                    btn1.setImageResource(R.drawable.buy);
                    btn2.setImageResource(R.drawable.sell);
                    editor.putInt(CHACKED_SWITCH, 0);

                }
                editor.commit();

            }
        });

        return view;

    }







}
