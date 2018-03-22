package com.example.admin.tombola;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import java.util.Objects;

public class AscoltatoreActivityMain implements View.OnClickListener {

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
        if (view.getContentDescription() != null && view.getContentDescription().toString().length() >= 7) {
            switch (view.getContentDescription().toString().substring(0, 7)) {
                case "casella":
                    b = BitmapFactory.decodeResource(activity.getResources(),R.drawable.casella_tappata);
                    int numero = Integer.parseInt(view.getContentDescription().toString().substring(7));
                    activity.getCaselle().get(numero).setImageBitmap(b);
                    back = terzultimo_numero;
                    terzultimo_numero = penultimo_numero;
                    penultimo_numero = ultimo_numero;
                    ultimo_numero = numero + 1;
                    if (terzultimo_numero != 0)
                        activity.getTerzultimo().setText(Integer.toString(terzultimo_numero));
                    if (penultimo_numero != 0)
                        activity.getPenultimo().setText(Integer.toString(penultimo_numero));
                    activity.getUltimo().setText(Integer.toString(ultimo_numero));
                    break;
            }
        }
        switch (view.getId()) {
            case R.id.cinquina:
                if (Objects.equals(activity.getCinquina().getContentDescription().toString(), "verde")){
                    b = BitmapFactory.decodeResource(activity.getResources(),R.drawable.cinquina_rossa);
                    activity.getCinquina().setContentDescription("rosso");
                }
                else {
                    b = BitmapFactory.decodeResource(activity.getResources(), R.drawable.cinquina_verde);
                    activity.getCinquina().setContentDescription("verde");
                };
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
                activity.getGiro().setText(Integer.toString(numeroGiro));
                break;
            case R.id.meno:
                numeroGiro = numeroGiro - 1;
                activity.getGiro().setText(Integer.toString(numeroGiro));
                break;
            case R.id.annulla:
                b = BitmapFactory.decodeResource(activity.getResources(),R.drawable.casella);
                activity.getCaselle().get(ultimo_numero-1).setImageBitmap(b);
                ultimo_numero = penultimo_numero;
                penultimo_numero = terzultimo_numero;
                terzultimo_numero = back;
                if (terzultimo_numero != 0)
                    activity.getTerzultimo().setText(Integer.toString(terzultimo_numero));
                else
                    activity.getTerzultimo().setText("");
                if (penultimo_numero != 0)
                    activity.getPenultimo().setText(Integer.toString(penultimo_numero));
                else
                    activity.getPenultimo().setText("");
                if (ultimo_numero != 0)
                    activity.getUltimo().setText(Integer.toString(ultimo_numero));
                else
                    activity.getUltimo().setText("");
                break;
        }
    }
}
