package com.example.admin.tombola;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import java.util.Objects;

public class AscoltatoreActivityMain implements View.OnClickListener, DialogInterface.OnClickListener {

    private ActivityMain activity;
    private int numeroGiro;
    private int ultimo_numero;
    private int penultimo_numero;
    private int terzultimo_numero;
    private int back;

    AscoltatoreActivityMain(ActivityMain activity)
    {
        numeroGiro = 1;
        ultimo_numero = 0;
        penultimo_numero = 0;
        terzultimo_numero = 0;
        back = 0;
        this.activity= activity;
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
            case R.id.tombola:
                if (Objects.equals(activity.getTombola().getContentDescription().toString(), "verde")){
                    b = BitmapFactory.decodeResource(activity.getResources(),R.drawable.tombola_rossa);
                    activity.getTombola().setContentDescription("rosso");
                }
                else {
                    b = BitmapFactory.decodeResource(activity.getResources(), R.drawable.tombola_verde);
                    activity.getTombola().setContentDescription("verde");
                }
                activity.getTombola().setImageBitmap(b);
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
                activity.startActivity(setPage);
                break;
            case R.id.reset:
                activity.getDialog().show();
                break;
            case R.id.annulla:
                if (ultimo_numero != 0) {
                    activity.getCaselle().get(ultimo_numero-1).setClickable(true);
                    activity.setButton(activity.getCaselle().get(ultimo_numero - 1), 18, 18, 18, 18, Color.BLACK, Color.WHITE, Color.BLACK);
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
                    activity.setButton(activity.getCaselle().get(numero-1),18, 18, 18, 18, Color.BLACK, Color.BLACK, Color.WHITE);
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
            activity.nascondiLayout();
            ultimo_numero = 0;
            penultimo_numero = 0;
            terzultimo_numero = 0;
            back = 0;
        }
        dialogInterface.dismiss();
    }
}

