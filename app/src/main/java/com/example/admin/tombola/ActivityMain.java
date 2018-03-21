package com.example.admin.tombola;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import java.util.ArrayList;


public class ActivityMain  extends AppCompatActivity {

    private GridLayout tabellone;
    private ArrayList<ImageButton> caselle;
    private ImageButton cinquina;
    private ImageButton decima;
    private ImageButton tombola;

    public ImageButton getCinquina() {
        return cinquina;
    }

    public ImageButton getDecima() {
        return decima;
    }

    public ImageButton getTombola() {
        return tombola;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabellone=(GridLayout)findViewById(R.id.tabellone);
        cinquina =(ImageButton)findViewById(R.id.cinquina);
        decima =(ImageButton)findViewById(R.id.decima);
        tombola =(ImageButton)findViewById(R.id.tombola);
        caselle = new ArrayList<>(90);
        AscoltatoreActivityMain ascoltatore = new AscoltatoreActivityMain(this);
        Bitmap b = BitmapFactory.decodeResource(this.getResources(),R.drawable.casella);
        for (int i = 0;i<90; i++){
            ImageButton casella = new ImageButton(this);
            casella.setImageBitmap(b);
            casella.setScaleType(ImageView.ScaleType.FIT_CENTER);
            tabellone.addView(casella);
            caselle.add(casella);
        }
        cinquina.setOnClickListener(ascoltatore);
        decima.setOnClickListener(ascoltatore);
        tombola.setOnClickListener(ascoltatore);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
    }


}
