package com.tombola.gui.main;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import com.tombola.gui.settings.ActivitySetting;
import com.tombola.R;
import java.util.Objects;

import static java.lang.Thread.sleep;

public class AscoltatoreActivityMain implements View.OnClickListener, DialogInterface.OnClickListener {

    private ActivityMain activity;
    private int numeroGiro;
    private int ultimo_numero;
    private int penultimo_numero;
    private int terzultimo_numero;
    private int back;
    private int tempo;
    private float defaultSize;
    private boolean firstReset;

    AscoltatoreActivityMain(ActivityMain activity)
    {
        numeroGiro = 1;
        ultimo_numero = 0;
        penultimo_numero = 0;
        terzultimo_numero = 0;
        back = 0;
        this.activity= activity;
        firstReset = true;
    }

    @Override
    public void onClick(View view) {
        Bitmap b;
        switch (view.getId()) {
            case R.id.cinquina:
                if (Objects.equals(activity.getCinquina().getContentDescription().toString(), "verde")){
                    b = BitmapFactory.decodeResource(activity.getResources(),R.drawable.cinquina_rossa);
                    activity.getCinquina().setContentDescription("rosso");
                }
                else {
                    b = BitmapFactory.decodeResource(activity.getResources(), R.drawable.cinquina_verde);
                    activity.getCinquina().setContentDescription("verde");
                }
                activity.getCinquina().setImageBitmap(b);
                break;
            case R.id.decima:
                MediaPlayer audio;
                audio = MediaPlayer.create(activity, R.raw.uno);
                audio.start();
                if (Objects.equals(activity.getDecima().getContentDescription().toString(), "verde")){
                    b = BitmapFactory.decodeResource(activity.getResources(),R.drawable.decima_rossa);
                    activity.getDecima().setContentDescription("rosso");
                }
                else {
                    b = BitmapFactory.decodeResource(activity.getResources(), R.drawable.decima_verde);
                    activity.getDecima().setContentDescription("verde");
                }
                activity.getDecima().setImageBitmap(b);
                break;
            case R.id.piu:
                numeroGiro = numeroGiro + 1;
                activity.getGiro().setText(String.format("%s",numeroGiro));
                break;
            case R.id.meno:
                numeroGiro = numeroGiro - 1;
                activity.getGiro().setText(String.format("%s",numeroGiro));
                break;
            case R.id.set:
                Intent setPage = new Intent(activity,ActivitySetting.class);
                setPage.putExtra("page", "libera");
                activity.startActivity(setPage);
                break;
            case R.id.reset:
                activity.getDialog().show();
                break;
            case R.id.annulla:
                if (ultimo_numero != 0) {
                    activity.getCaselle().get(ultimo_numero-1).setClickable(true);
                    activity.getManageButton().setButton(activity.getCaselle().get(ultimo_numero - 1),activity.getManageButton().preparaBordi(ultimo_numero), activity.getManageButton().preparaPadding(1),activity.getManageXml().getColore_bordo(), activity.getManageXml().getColore_casella_libera_sfondo(), activity.getManageXml().getColore_casella_libera_testo(),activity.getResources().getInteger(R.integer.testo_medio));
                    activity.getCaselle().get(ultimo_numero-1).setContentDescription("libera");
                    ultimo_numero = penultimo_numero;
                    penultimo_numero = terzultimo_numero;
                    terzultimo_numero = back;
                    back=0;
                    if (terzultimo_numero != 0)
                        activity.getTerzultimo().setText(String.format("%s",terzultimo_numero));
                    else
                        activity.getTerzultimo().setText("");
                    if (penultimo_numero != 0)
                        activity.getPenultimo().setText(String.format("%s",penultimo_numero));
                    else
                        activity.getPenultimo().setText("");
                    if (ultimo_numero != 0)
                        activity.getUltimo().setText(String.format("%s",ultimo_numero));
                    else
                        activity.getUltimo().setText("");
                }
                break;

            default:
                Button casella = (Button) view;
                if (casella.getText()!= null) {
                    int numero = Integer.parseInt(casella.getText().toString());
                    activity.getCaselle().get(numero-1).setClickable(false);
                    activity.getManageButton().setButton(activity.getCaselle().get(numero-1),activity.getManageButton().preparaBordi(numero), activity.getManageButton().preparaPadding(1),activity.getManageXml().getColore_bordo(), activity.getManageXml().getColore_casella_tappata_sfondo(), activity.getManageXml().getColore_casella_tappata_testo(),activity.getResources().getInteger(R.integer.testo_medio));
                    activity.getCaselle().get(numero-1).setContentDescription("tappata");
                    back = terzultimo_numero;
                    terzultimo_numero = penultimo_numero;
                    penultimo_numero = ultimo_numero;
                    ultimo_numero = numero;
                    if (terzultimo_numero != 0)
                        activity.getTerzultimo().setText(String.format("%s",terzultimo_numero));
                    if (penultimo_numero != 0)
                        activity.getPenultimo().setText(String.format("%s",penultimo_numero));
                    activity.getUltimo().setText(String.format("%s",ultimo_numero));
                }
                break;
        }
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -1) {
            activity.resetGrafica();
            activity.nascondiLayout(0,0,1);
            tempo = activity.getManageXml().getTempo();
            int tempoTotal = activity.getManageXml().getTempo();
            ultimo_numero = 0;
            penultimo_numero = 0;
            terzultimo_numero = 0;
            back = 0;
            activity.getTesto_tempo().setText(String.format(activity.getResources().getString(R.string.messaggio_tempo), tempo));
            if (firstReset){
                defaultSize = activity.getTesto_tempo().getHeight();
                activity.getTesto_tempo().setTextSize(defaultSize*4f);
                if (tempoTotal>=10)
                    activity.getTesto_tempo().setTextSize(defaultSize*3f);
                if (tempoTotal>=100)
                    activity.getTesto_tempo().setTextSize(defaultSize*2f);
                firstReset = false;
            }
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    activity.nascondiLayout(0.3f,0.7f,0);
                }
            }, tempoTotal*1000);
            for (int j=1; j<tempoTotal; j++) {
                Handler handler1 = new Handler();
                handler1.postDelayed(new Runnable() {
                    public void run() {
                        tempo = tempo-1;
                        activity.getTesto_tempo().setTextSize(defaultSize*4f);
                        if (tempo>=10)
                            activity.getTesto_tempo().setTextSize(defaultSize*3f);
                        if (tempo>=100)
                            activity.getTesto_tempo().setTextSize(defaultSize*1.8f);
                        activity.getTesto_tempo().setText(String.format(activity.getResources().getString(R.string.messaggio_tempo), tempo));
                    }
                }, j*1000);
            }
        }
        dialogInterface.dismiss();
    }
}

