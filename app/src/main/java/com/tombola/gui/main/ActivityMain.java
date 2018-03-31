package com.tombola.gui.main;

import android.app.AlertDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import com.tombola.tool.ManageXml;
import com.tombola.R;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;

public class ActivityMain  extends AppCompatActivity {

    private boolean start = false;
    private ArrayList<Button> caselle;
    private ImageButton cinquina;
    private ImageButton decima;
    private ImageButton tombola;
    private Button ultimo;
    private Button penultimo;
    private Button terzultimo;
    private Button giro;
    private TableLayout layoutTabellone;
    private LinearLayout layoutComandi;
    private FrameLayout layoutLogo;
    private AlertDialog dialog;
    private ManageXml manageXml;
    private ArrayList<Integer> white;
    private ArrayList<Integer> black;
    private TextView testo_tempo;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        white = new ArrayList<>(3);
        black = new ArrayList<>(3);
        white.add(255);
        white.add(255);
        white.add(255);
        black.add(0);
        black.add(0);
        black.add(0);
        start = true;
        layoutTabellone=(TableLayout) findViewById(R.id.LTabellone);
        layoutComandi=(LinearLayout) findViewById(R.id.LComandi);
        layoutLogo=(FrameLayout) findViewById(R.id.logo);
        ultimo = (Button) findViewById(R.id.casella_ultimo_numero);
        penultimo = (Button) findViewById(R.id.casella_penultimo_numero);
        terzultimo = (Button) findViewById(R.id.casella_terzultimo_numero);
        giro = (Button) findViewById(R.id.casella_giro);
        ImageButton piu = (ImageButton) findViewById(R.id.piu);
        ImageButton meno = (ImageButton) findViewById(R.id.meno);
        ImageButton annulla = (ImageButton) findViewById(R.id.annulla);
        ImageButton impostazioni = (ImageButton) findViewById(R.id.set);
        ImageButton reset = (ImageButton) findViewById(R.id.reset);
        cinquina =(ImageButton)findViewById(R.id.cinquina);
        decima =(ImageButton)findViewById(R.id.decima);
        tombola =(ImageButton)findViewById(R.id.tombola);
        testo_tempo = (TextView) findViewById(R.id.testo_tempo);
        caselle = new ArrayList<>(90);
        AscoltatoreActivityMain ascoltatore = new AscoltatoreActivityMain(this);
        caselle.add((Button) findViewById(R.id.casella0));
        caselle.add((Button) findViewById(R.id.casella1));
        caselle.add((Button) findViewById(R.id.casella2));
        caselle.add((Button) findViewById(R.id.casella3));
        caselle.add((Button) findViewById(R.id.casella4));
        caselle.add((Button) findViewById(R.id.casella5));
        caselle.add((Button) findViewById(R.id.casella6));
        caselle.add((Button) findViewById(R.id.casella7));
        caselle.add((Button) findViewById(R.id.casella8));
        caselle.add((Button) findViewById(R.id.casella9));
        caselle.add((Button) findViewById(R.id.casella10));
        caselle.add((Button) findViewById(R.id.casella11));
        caselle.add((Button) findViewById(R.id.casella12));
        caselle.add((Button) findViewById(R.id.casella13));
        caselle.add((Button) findViewById(R.id.casella14));
        caselle.add((Button) findViewById(R.id.casella15));
        caselle.add((Button) findViewById(R.id.casella16));
        caselle.add((Button) findViewById(R.id.casella17));
        caselle.add((Button) findViewById(R.id.casella18));
        caselle.add((Button) findViewById(R.id.casella19));
        caselle.add((Button) findViewById(R.id.casella20));
        caselle.add((Button) findViewById(R.id.casella21));
        caselle.add((Button) findViewById(R.id.casella22));
        caselle.add((Button) findViewById(R.id.casella23));
        caselle.add((Button) findViewById(R.id.casella24));
        caselle.add((Button) findViewById(R.id.casella25));
        caselle.add((Button) findViewById(R.id.casella26));
        caselle.add((Button) findViewById(R.id.casella27));
        caselle.add((Button) findViewById(R.id.casella28));
        caselle.add((Button) findViewById(R.id.casella29));
        caselle.add((Button) findViewById(R.id.casella30));
        caselle.add((Button) findViewById(R.id.casella31));
        caselle.add((Button) findViewById(R.id.casella32));
        caselle.add((Button) findViewById(R.id.casella33));
        caselle.add((Button) findViewById(R.id.casella34));
        caselle.add((Button) findViewById(R.id.casella35));
        caselle.add((Button) findViewById(R.id.casella36));
        caselle.add((Button) findViewById(R.id.casella37));
        caselle.add((Button) findViewById(R.id.casella38));
        caselle.add((Button) findViewById(R.id.casella39));
        caselle.add((Button) findViewById(R.id.casella40));
        caselle.add((Button) findViewById(R.id.casella41));
        caselle.add((Button) findViewById(R.id.casella42));
        caselle.add((Button) findViewById(R.id.casella43));
        caselle.add((Button) findViewById(R.id.casella44));
        caselle.add((Button) findViewById(R.id.casella45));
        caselle.add((Button) findViewById(R.id.casella46));
        caselle.add((Button) findViewById(R.id.casella47));
        caselle.add((Button) findViewById(R.id.casella48));
        caselle.add((Button) findViewById(R.id.casella49));
        caselle.add((Button) findViewById(R.id.casella50));
        caselle.add((Button) findViewById(R.id.casella51));
        caselle.add((Button) findViewById(R.id.casella52));
        caselle.add((Button) findViewById(R.id.casella53));
        caselle.add((Button) findViewById(R.id.casella54));
        caselle.add((Button) findViewById(R.id.casella55));
        caselle.add((Button) findViewById(R.id.casella56));
        caselle.add((Button) findViewById(R.id.casella57));
        caselle.add((Button) findViewById(R.id.casella58));
        caselle.add((Button) findViewById(R.id.casella59));
        caselle.add((Button) findViewById(R.id.casella60));
        caselle.add((Button) findViewById(R.id.casella61));
        caselle.add((Button) findViewById(R.id.casella62));
        caselle.add((Button) findViewById(R.id.casella63));
        caselle.add((Button) findViewById(R.id.casella64));
        caselle.add((Button) findViewById(R.id.casella65));
        caselle.add((Button) findViewById(R.id.casella66));
        caselle.add((Button) findViewById(R.id.casella67));
        caselle.add((Button) findViewById(R.id.casella68));
        caselle.add((Button) findViewById(R.id.casella69));
        caselle.add((Button) findViewById(R.id.casella70));
        caselle.add((Button) findViewById(R.id.casella71));
        caselle.add((Button) findViewById(R.id.casella72));
        caselle.add((Button) findViewById(R.id.casella73));
        caselle.add((Button) findViewById(R.id.casella74));
        caselle.add((Button) findViewById(R.id.casella75));
        caselle.add((Button) findViewById(R.id.casella76));
        caselle.add((Button) findViewById(R.id.casella77));
        caselle.add((Button) findViewById(R.id.casella78));
        caselle.add((Button) findViewById(R.id.casella79));
        caselle.add((Button) findViewById(R.id.casella80));
        caselle.add((Button) findViewById(R.id.casella81));
        caselle.add((Button) findViewById(R.id.casella82));
        caselle.add((Button) findViewById(R.id.casella83));
        caselle.add((Button) findViewById(R.id.casella84));
        caselle.add((Button) findViewById(R.id.casella85));
        caselle.add((Button) findViewById(R.id.casella86));
        caselle.add((Button) findViewById(R.id.casella87));
        caselle.add((Button) findViewById(R.id.casella88));
        caselle.add((Button) findViewById(R.id.casella89));
        for (int i =0;i<caselle.size();i++){
            caselle.get(i).setOnClickListener(ascoltatore);
            caselle.get(i).setText(String.format("%s",i+1));
        }
        cinquina.setOnClickListener(ascoltatore);
        decima.setOnClickListener(ascoltatore);
        tombola.setOnClickListener(ascoltatore);
        piu.setOnClickListener(ascoltatore);
        meno.setOnClickListener(ascoltatore);
        annulla.setOnClickListener(ascoltatore);
        impostazioni.setOnClickListener(ascoltatore);
        reset.setOnClickListener(ascoltatore);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("Reset Tabellone");
        builder.setMessage("Sei sicuro di voler resettare il tabellone?");
        builder.setPositiveButton("Si", ascoltatore);
        builder.setNegativeButton(android.R.string.cancel, ascoltatore);
        dialog = builder.create();
    }

    @Override
    protected void onResume() {
        super.onResume();
        manageXml = new ManageXml();
        File f = new File(getFilesDir(), "config.xml");
        if (f.exists()) {
            try {
                manageXml.setIst(openFileInput("config.xml"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            manageXml.readXml(true);
        }
        else{
            manageXml.setXrp(getResources().getXml(R.xml.config));
            manageXml.readXml(false);
        }
        updatetabellone();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (start) {
            start=false;
            resetGrafica();
        }
    }

    public void nascondiLayout(float wC, float wT, float wL)
    {
        layoutComandi.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, wC));
        layoutTabellone.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, wT));
        layoutLogo.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, wL));
    }

    public void resetGrafica() {
        TypedValue outValue = new TypedValue();
        getResources().getValue(R.dimen.testo_grande, outValue, true);
        setButton(giro, preparaBordi(100), preparaPadding(3), black, white, black,outValue.getFloat());
        setButton(ultimo, preparaBordi(101), preparaPadding(2),black, white, black,outValue.getFloat());
        setButton(penultimo, preparaBordi(102), preparaPadding(2),black, white, black,outValue.getFloat());
        setButton(terzultimo, preparaBordi(103), preparaPadding(2),black, white, black,outValue.getFloat());
        ultimo.setText("");
        penultimo.setText("");
        terzultimo.setText("");
        Bitmap b = BitmapFactory.decodeResource(getResources(), R.drawable.cinquina_verde);
        cinquina.setContentDescription("verde");
        cinquina.setImageBitmap(b);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.decima_verde);
        decima.setContentDescription("verde");
        decima.setImageBitmap(b);
        b = BitmapFactory.decodeResource(getResources(), R.drawable.tombola_verde);
        tombola.setContentDescription("verde");
        tombola.setImageBitmap(b);
        layoutTabellone.setPadding(layoutTabellone.getWidth()/getResources().getInteger(R.integer.padding_minuscolo),layoutTabellone.getHeight()/getResources().getInteger(R.integer.padding_minuscolo),layoutTabellone.getWidth()/getResources().getInteger(R.integer.padding_minuscolo),layoutTabellone.getHeight()/getResources().getInteger(R.integer.padding_minuscolo));
        for (int i = 0; i < caselle.size(); i++) {
            caselle.get(i).setContentDescription("libera");
            caselle.get(i).setClickable(true);
        }
        updatetabellone();
    }
    //left, top, rigth, bottom
    public void setButton(Button casella, ArrayList<Integer> bordi, ArrayList<Integer> padding, ArrayList<Integer> colore_bordo, ArrayList<Integer> colore_sfondo, ArrayList<Integer> colore_testo, float textSize){
        LayerDrawable layerDrawable = (LayerDrawable) ContextCompat.getDrawable(this, R.drawable.casella);
        layerDrawable.setLayerInset(1, casella.getWidth()/bordi.get(0), casella.getHeight()/bordi.get(1), casella.getWidth()/bordi.get(2),casella.getHeight()/bordi.get(3));
        GradientDrawable bordo = (GradientDrawable)layerDrawable.findDrawableByLayerId(R.id.bordo);
        bordo.setColor(Color.rgb(colore_bordo.get(0),colore_bordo.get(1),colore_bordo.get(2)));
        GradientDrawable sfondo = (GradientDrawable)layerDrawable.findDrawableByLayerId(R.id.sfondo);
        sfondo.setColor(Color.rgb(colore_sfondo.get(0),colore_sfondo.get(1),colore_sfondo.get(2)));
        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) casella.getLayoutParams();
        lp.setMargins(casella.getWidth() / padding.get(0), casella.getHeight() / padding.get(1), casella.getWidth() / padding.get(2), casella.getHeight() / padding.get(3));
        casella.setLayoutParams(lp);
        casella.setBackground(layerDrawable);
        casella.setTextSize((casella.getHeight()-casella.getHeight() / padding.get(1))/textSize);
        casella.setTextColor(Color.rgb(colore_testo.get(0),colore_testo.get(1),colore_testo.get(2)));
    }

    public void updatetabellone(){

        for (int i = 0; i < caselle.size(); i++){
            if (Objects.equals(caselle.get(i).getContentDescription().toString(), "libera"))
                setButton(caselle.get(i), preparaBordi(i+1), preparaPadding(1), manageXml.getColore_bordo(), manageXml.getColore_casella_libera_sfondo(), manageXml.getColore_casella_libera_testo(),getResources().getInteger(R.integer.testo_medio));
            if (Objects.equals(caselle.get(i).getContentDescription().toString(), "tappata"))
                setButton(caselle.get(i), preparaBordi(i+1),preparaPadding(1), manageXml.getColore_bordo(), manageXml.getColore_casella_tappata_sfondo(), manageXml.getColore_casella_tappata_testo(),getResources().getInteger(R.integer.testo_medio));
        }
    }

    //left, top, rigth, bottom
    public ArrayList<Integer> preparaBordi(int numero_casella){
        ArrayList<Integer> bordi = new ArrayList<>(4);
        if (numero_casella <= 90) {
            //LEFT
            if (numero_casella == 1 || (numero_casella - 1) % 10 == 0)
                bordi.add(getResources().getInteger(R.integer.bordo_grande));
            else {
                if (numero_casella % 10 == 6)
                    bordi.add(getResources().getInteger(R.integer.bordo_medio));
                else
                    bordi.add(0, getResources().getInteger(R.integer.bordo_piccolo));
            }
            //TOP
            if (numero_casella >= 1 && numero_casella <= 10)
                bordi.add(getResources().getInteger(R.integer.bordo_grande));
            else {
                if ((numero_casella >= 31 && numero_casella <= 40) || (numero_casella >= 61 && numero_casella <= 70))
                    bordi.add(getResources().getInteger(R.integer.bordo_medio));
                else
                    bordi.add(getResources().getInteger(R.integer.bordo_piccolo));
            }
            //RIGTH
            if (numero_casella % 10 == 0)
                bordi.add(getResources().getInteger(R.integer.bordo_grande));
            else {
                if (numero_casella % 10 == 5)
                    bordi.add(getResources().getInteger(R.integer.bordo_medio));
                else
                    bordi.add(getResources().getInteger(R.integer.bordo_piccolo));
            }
            //BOTTOM
            if (numero_casella >= 81 && numero_casella <= 90)
                bordi.add(getResources().getInteger(R.integer.bordo_grande));
            else {
                if ((numero_casella >= 21 && numero_casella <= 30) || (numero_casella >= 51 && numero_casella <= 60))
                    bordi.add(getResources().getInteger(R.integer.bordo_medio));
                else
                    bordi.add(getResources().getInteger(R.integer.bordo_piccolo));
            }
        }
        else {
            //GIRO
            if (numero_casella == 100) {
                bordi.add(getResources().getInteger(R.integer.bordo_medio)); //left
                bordi.add(getResources().getInteger(R.integer.bordo_medio)); //left
                bordi.add(getResources().getInteger(R.integer.bordo_medio)); //left
                bordi.add(getResources().getInteger(R.integer.bordo_medio)); //left
            }

            //ULTIMO ESTRATTO
            if (numero_casella == 101) {
                bordi.add(getResources().getInteger(R.integer.bordo_medio)); //left
                bordi.add(getResources().getInteger(R.integer.bordo_medio)); //left
                bordi.add(getResources().getInteger(R.integer.bordo_medio)); //left
                bordi.add(getResources().getInteger(R.integer.bordo_medio)); //left
            }
            //PENULTIMO ESTRATTO
            if (numero_casella == 102 || numero_casella == 103) {
                bordi.add(getResources().getInteger(R.integer.bordo_medio)); //left
                bordi.add(getResources().getInteger(R.integer.bordo_medio)); //left
                bordi.add(getResources().getInteger(R.integer.bordo_medio)); //left
                bordi.add(getResources().getInteger(R.integer.bordo_medio)); //left
            }
        }
        return bordi;
    }

    public ArrayList<Integer> preparaPadding(int tipologia){
        ArrayList<Integer> padding = new ArrayList<>(4);
        if (tipologia == 1){
            padding.add(getResources().getInteger(R.integer.padding_nullo));
            padding.add(getResources().getInteger(R.integer.padding_nullo));
            padding.add(getResources().getInteger(R.integer.padding_nullo));
            padding.add(getResources().getInteger(R.integer.padding_nullo));
        }
        if (tipologia == 2){
            padding.add(getResources().getInteger(R.integer.padding_piccolo));
            padding.add(getResources().getInteger(R.integer.padding_piccolo));
            padding.add(getResources().getInteger(R.integer.padding_piccolo));
            padding.add(getResources().getInteger(R.integer.padding_piccolo));
        }
        if (tipologia == 3){
            padding.add(getResources().getInteger(R.integer.padding_medio));
            padding.add(getResources().getInteger(R.integer.padding_piccolo));
            padding.add(getResources().getInteger(R.integer.padding_medio));
            padding.add(getResources().getInteger(R.integer.padding_nullo));
        }
        return padding;
    }

    public TextView getTesto_tempo() {
        return testo_tempo;
    }

    public ManageXml getManageXml() {
        return manageXml;
    }

    public AlertDialog getDialog() { return dialog; }

    public TextView getUltimo() { return ultimo;}

    public TextView getPenultimo() { return penultimo; }

    public TextView getTerzultimo() { return terzultimo; }

    public TextView getGiro() { return giro; }

    public ArrayList<Button> getCaselle() { return caselle; }

    public ImageButton getCinquina() {
        return cinquina;
    }

    public ImageButton getDecima() {
        return decima;
    }

    public ImageButton getTombola() {
        return tombola;
    }
}
