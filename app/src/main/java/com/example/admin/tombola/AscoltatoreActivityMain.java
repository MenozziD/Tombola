package com.example.admin.tombola;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;

public class AscoltatoreActivityMain implements View.OnClickListener {

    private ActivityMain activity;

    AscoltatoreActivityMain(ActivityMain activity)
    {
        this.activity= activity;
    }

    @Override
    public void onClick(View view) {
        Bitmap b;
        switch (view.getId()) {
            case R.id.cinquina:
                if (activity.getCinquina().getContentDescription() == "verde"){
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
                if (activity.getDecima().getContentDescription() == "verde"){
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
                if (activity.getTombola().getContentDescription() == "verde"){
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
