package com.example.admin.tombola;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.Button;

import java.util.Objects;

public class AscoltatoreActivitySettings implements View.OnClickListener {

    private ActivitySetting activity;

    AscoltatoreActivitySettings(ActivitySetting activity)
    {
        this.activity= activity;
    }

    private void resetButton(){
        activity.setButton(activity.getCasella_in_gioco(), 18, 18, 18, 18, Color.BLACK, Color.WHITE, Color.BLACK);
        activity.setButton(activity.getCasella_estratta(), 18, 18, 18, 18, Color.BLACK, Color.WHITE, Color.BLACK);
        activity.setButton(activity.getBordo(), 18, 18, 18, 18, Color.BLACK, Color.WHITE, Color.BLACK);
        activity.setButton(activity.getImpostazioni_pausa(), 18, 18, 18, 18, Color.BLACK, Color.WHITE, Color.BLACK);
    }

    private void setColor(int green, int red, int blu, int id){
        activity.getVerde().setProgress(green);
        activity.getRosso().setProgress(red);
        activity.getBlu().setProgress(blu);
        activity.getValue_verde().setText(String.format("%s",green));
        activity.getValue_rosso().setText(String.format("%s",red));
        activity.getValue_blu().setText(String.format("%s",blu));
        activity.getRun_color().setBackgroundColor(activity.getResources().getColor(id));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.casella_libera:
                resetButton();
                activity.getSfondo().setVisibility(View.VISIBLE);
                activity.getTesto().setVisibility(View.VISIBLE);
                activity.setButton(activity.getCasella_in_gioco(), 18, 18, 18, 18, Color.WHITE, Color.BLACK, Color.WHITE);
                break;
            case R.id.casella_tap:
                resetButton();
                activity.getSfondo().setVisibility(View.VISIBLE);
                activity.getTesto().setVisibility(View.VISIBLE);
                activity.setButton(activity.getCasella_estratta(), 18, 18, 18, 18, Color.WHITE, Color.BLACK, Color.WHITE);
                break;
            case R.id.bordo:
                resetButton();
                activity.getSfondo().setVisibility(View.INVISIBLE);
                activity.getTesto().setVisibility(View.INVISIBLE);
                activity.setButton(activity.getBordo(), 18, 18, 18, 18, Color.WHITE, Color.BLACK, Color.WHITE);
                break;
            case R.id.pausa:
                resetButton();
                activity.getSfondo().setVisibility(View.INVISIBLE);
                activity.getTesto().setVisibility(View.INVISIBLE);
                activity.setButton(activity.getImpostazioni_pausa(), 18, 18, 18, 18, Color.WHITE, Color.BLACK, Color.WHITE);
                break;
            case R.id.sfondo:
                activity.setButton(activity.getSfondo(), 18, 18, 18, 18, Color.WHITE, Color.BLACK, Color.WHITE);
                activity.setButton(activity.getTesto(), 18, 18, 18, 18, Color.BLACK, Color.WHITE, Color.BLACK);
                break;
            case R.id.testo:
                activity.setButton(activity.getTesto(), 18, 18, 18, 18, Color.WHITE, Color.BLACK, Color.WHITE);
                activity.setButton(activity.getSfondo(), 18, 18, 18, 18, Color.BLACK, Color.WHITE, Color.BLACK);
                break;
            case R.id.orange:
                setColor(255,140,0, R.color.dark_orange);
                break;
            case R.id.azure:
                setColor(0,191,255, R.color.skyblue);
                break;
            case R.id.green:
                setColor(34,139,34, R.color.forestgreen);
                break;
            case R.id.gray:
                setColor(211,211,211, R.color.lightgray);
                break;
            case R.id.red:
                setColor(220,20,60, R.color.crimson);
                break;
            case R.id.yellow:
                setColor(255,215,0, R.color.gold);
                break;
            case R.id.imposta:
                break;
            case R.id.salva:
                break;
        }
    }
}
