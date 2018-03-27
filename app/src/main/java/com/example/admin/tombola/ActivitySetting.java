package com.example.admin.tombola;


import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;


public class ActivitySetting extends AppCompatActivity
{
    private Button my_color;
    private Button run_color;
    private Button casella_in_gioco;
    private Button casella_estratta;
    private Button bordo;
    private Button impostazioni_pausa;
    private Button sfondo;
    private Button testo;
    private Button salva;
    private Button imposta;
    private SeekBar rosso;
    private SeekBar verde;
    private SeekBar blu;
    private TextView value_rosso;
    private TextView value_verde;
    private TextView value_blu;

    public SeekBar getRosso() {
        return rosso;
    }

    public SeekBar getVerde() {
        return verde;
    }

    public SeekBar getBlu() {
        return blu;
    }

    public Button getMy_color() {
        return my_color;
    }

    public Button getRun_color() {
        return run_color;
    }

    public Button getCasella_in_gioco() {
        return casella_in_gioco;
    }

    public Button getCasella_estratta() {
        return casella_estratta;
    }

    public Button getBordo() {
        return bordo;
    }

    public Button getImpostazioni_pausa() {
        return impostazioni_pausa;
    }

    public Button getSfondo() {
        return sfondo;
    }

    public Button getTesto() {
        return testo;
    }

    public TextView getValue_rosso() {
        return value_rosso;
    }

    public TextView getValue_verde() {
        return value_verde;
    }

    public TextView getValue_blu() {
        return value_blu;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Button orange = (Button) findViewById(R.id.orange);
        Button azure = (Button) findViewById(R.id.azure);
        Button green = (Button) findViewById(R.id.green);
        Button gray = (Button) findViewById(R.id.gray);
        Button red = (Button) findViewById(R.id.red);
        Button yellow = (Button) findViewById(R.id.yellow);
        imposta = (Button) findViewById(R.id.imposta);
        salva = (Button) findViewById(R.id.salva);
        my_color = (Button) findViewById(R.id.my_color);
        run_color= (Button) findViewById(R.id.run_color);
        casella_in_gioco= (Button) findViewById(R.id.casella_libera);
        casella_estratta = (Button) findViewById(R.id.casella_tap);
        bordo = (Button) findViewById(R.id.bordo);
        impostazioni_pausa = (Button) findViewById(R.id.pausa);
        sfondo = (Button) findViewById(R.id.sfondo);
        testo = (Button) findViewById(R.id.testo);
        rosso = (SeekBar) findViewById(R.id.rosso);
        verde = (SeekBar) findViewById(R.id.verde);
        blu = (SeekBar) findViewById(R.id.blu);
        value_rosso = (TextView) findViewById(R.id.value_rosso);
        value_verde = (TextView) findViewById(R.id.value_verde);
        value_blu = (TextView) findViewById(R.id.value_blu);
        AscoltatoreActivitySettings ascoltatore = new AscoltatoreActivitySettings(this);
        imposta.setOnClickListener(ascoltatore);
        salva.setOnClickListener(ascoltatore);
        orange.setOnClickListener(ascoltatore);
        azure.setOnClickListener(ascoltatore);
        green.setOnClickListener(ascoltatore);
        gray.setOnClickListener(ascoltatore);
        red.setOnClickListener(ascoltatore);
        yellow.setOnClickListener(ascoltatore);
        my_color.setOnClickListener(ascoltatore);
        casella_estratta.setOnClickListener(ascoltatore);
        casella_in_gioco.setOnClickListener(ascoltatore);
        bordo.setOnClickListener(ascoltatore);
        impostazioni_pausa.setOnClickListener(ascoltatore);
        sfondo.setOnClickListener(ascoltatore);
        testo.setOnClickListener(ascoltatore);
        rosso.setOnSeekBarChangeListener(ascoltatore);
        verde.setOnSeekBarChangeListener(ascoltatore);
        blu.setOnSeekBarChangeListener(ascoltatore);
    }

    @Override
    protected void onResume() {super.onResume();}

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        setButton(casella_estratta, 18, 18, 18, 18, Color.BLACK, Color.WHITE, Color.BLACK);
        setButton(casella_in_gioco, 18, 18, 18, 18, Color.WHITE, Color.BLACK, Color.WHITE);
        setButton(bordo, 18, 18, 18, 18, Color.BLACK, Color.WHITE, Color.BLACK);
        setButton(impostazioni_pausa, 18, 18, 18, 18, Color.BLACK, Color.WHITE, Color.BLACK);
        setButton(sfondo, 18, 18, 18, 18, Color.WHITE, Color.BLACK, Color.WHITE);
        setButton(testo, 18, 18, 18, 18, Color.BLACK, Color.WHITE, Color.BLACK);
        setButton(imposta, 60, 9, 60, 9, Color.BLACK, Color.WHITE, Color.BLACK);
        setButton(salva, 9, 9, 9, 9, Color.BLACK, Color.WHITE, Color.BLACK);
    }

    public void setButton(Button casella, float l, float t, float r, float b, int colore_bordo, int colore_sfondo, int colore_testo){
        LayerDrawable layerDrawable = (LayerDrawable) ContextCompat.getDrawable(this, R.drawable.casella);
        layerDrawable.setLayerInset(1, Math.round(casella.getWidth()/l), Math.round(casella.getHeight()/t), Math.round(casella.getWidth()/r),Math.round(casella.getHeight()/b));
        GradientDrawable bordo = (GradientDrawable)layerDrawable.findDrawableByLayerId(R.id.bordo);
        bordo.setColor(colore_bordo);
        GradientDrawable sfondo = (GradientDrawable)layerDrawable.findDrawableByLayerId(R.id.sfondo);
        sfondo.setColor(colore_sfondo);
        casella.setBackground(layerDrawable);
        casella.setTextSize((casella.getWidth()/16f)/2.65f);
        casella.setTextColor(colore_testo);
    }
}
