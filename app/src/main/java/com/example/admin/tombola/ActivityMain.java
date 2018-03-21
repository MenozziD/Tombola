package com.example.admin.tombola;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;


public class ActivityMain  extends AppCompatActivity {

    private GridLayout tabellone;
    private ArrayList<ImageButton> caselle;
    private ImageButton cinquina;
    private ImageButton decima;
    private ImageButton tombola;

    public ArrayList<ImageButton> getCaselle() { return caselle; }

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
        TypedValue outValue = new TypedValue();
        this.getTheme().resolveAttribute(android.R.attr.selectableItemBackground, outValue, true);
        for (int i = 0;i<90; i++){
            FrameLayout f = new FrameLayout(this);
            ImageButton casella = new ImageButton(this);
            TextView t = new TextView(this);
            f.setLayoutParams(new FrameLayout.LayoutParams(dpToPx(44),dpToPx(31)));
            casella.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            casella.setBackgroundResource(outValue.resourceId);
            casella.setScaleType(ImageView.ScaleType.CENTER_CROP);
            casella.setImageBitmap(b);
            casella.setContentDescription("casella"+Integer.toString(i));
            casella.setOnClickListener(ascoltatore);
            t.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
            t.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
            t.setGravity(Gravity.CENTER);
            t.setClickable(false);
            t.setText(Integer.toString(i+1));
            f.addView(casella);
            f.addView(t);
            tabellone.addView(f);
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

    public int dpToPx(int dp) {
        float density = this.getResources().getDisplayMetrics().density;
        return Math.round((float) dp * density);
    }
}
