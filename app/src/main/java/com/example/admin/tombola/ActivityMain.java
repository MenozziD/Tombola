package com.example.admin.tombola;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.GridLayout;
import android.widget.ImageButton;
import java.util.ArrayList;
import com.example.admin.tombola.R;


public class ActivityMain  extends AppCompatActivity {

    private GridLayout tabellone;
    private ArrayList<ImageButton> caselle;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabellone=(GridLayout)findViewById(R.id.tabellone);
        caselle = new ArrayList<>(90);
        Bitmap b = BitmapFactory.decodeResource(this.getResources(),R.drawable.casella);
        Log.i("WIDTH", Integer.toString(b.getWidth()));
        for (int i = 0;i<90; i++){
            ImageButton casella = new ImageButton(this);
            casella.setImageBitmap(b);
            tabellone.addView(casella);
            caselle.add(casella);
        }

    }

    @Override
    protected void onResume()
    {
        super.onResume();
    }


}
