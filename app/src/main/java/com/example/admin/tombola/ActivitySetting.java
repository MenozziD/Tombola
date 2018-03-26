package com.example.admin.tombola;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;


public class ActivitySetting extends AppCompatActivity
{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        AscoltatoreActivitySettings ascoltatore = new AscoltatoreActivitySettings(this);
    }

    @Override
    protected void onResume() {super.onResume();}

    public void myDestroy(){
        super.onDestroy();
    }


}
