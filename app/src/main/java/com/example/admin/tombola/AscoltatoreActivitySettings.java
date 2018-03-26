package com.example.admin.tombola;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;

import java.util.Objects;

public class AscoltatoreActivitySettings implements View.OnClickListener {

    private ActivitySetting activity;

    AscoltatoreActivitySettings(ActivitySetting activity)
    {
        this.activity= activity;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

        }
    }
}
