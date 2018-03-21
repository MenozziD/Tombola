package com.example.admin.tombola;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import java.util.Objects;

public class AscoltatoreActivityMain implements View.OnClickListener {

    private ActivityMain activity;

    AscoltatoreActivityMain(ActivityMain activity)
    {
        this.activity= activity;
    }

    @Override
    public void onClick(View view) {
        Bitmap b;
        if (view.getContentDescription().toString().length() > 7) {
            switch (view.getContentDescription().toString().substring(0, 7)) {
                case "casella":
                    b = BitmapFactory.decodeResource(activity.getResources(),R.drawable.casella_tappata);
                    activity.getCaselle().get(Integer.parseInt(view.getContentDescription().toString().substring(7))).setImageBitmap(b);
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
        }
    }
}
