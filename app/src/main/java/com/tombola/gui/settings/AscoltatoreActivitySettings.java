package com.tombola.gui.settings;

import android.graphics.Color;
import android.view.View;
import android.widget.SeekBar;
import com.tombola.tool.ManageXml;
import com.tombola.R;
import java.io.File;
import java.io.FileNotFoundException;
import static android.content.Context.MODE_PRIVATE;

public class AscoltatoreActivitySettings implements View.OnClickListener, SeekBar.OnSeekBarChangeListener{

    private ActivitySetting activity;
    private ManageXml manageXml;
    /*
        0 -> Casella libera sfondo
        1 -> Casella libera testo
        2 -> Casella tappata sfondo
        3 -> Casella tappata testo
        4 -> bordo
        5 -> impostazioni pausa
    */
    private int the_view;

    AscoltatoreActivitySettings(ActivitySetting activity)
    {
        manageXml = new ManageXml();
        this.activity= activity;
        the_view = 0;
        File f = new File(activity.getFilesDir(), "config.xml");
        if (f.exists()) {
            try {
                manageXml.setIst(activity.openFileInput("config.xml"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            manageXml.readXml(true);
        }
        else{
            manageXml.setXrp(activity.getResources().getXml(R.xml.config));
            manageXml.readXml(false);
        }
        setColor(manageXml.getColore_casella_libera_sfondo().get(0),manageXml.getColore_casella_libera_sfondo().get(1),manageXml.getColore_casella_libera_sfondo().get(2));
        activity.getMy_color().setBackgroundColor(Color.rgb(manageXml.getMio_colore_casella_libera_sfondo().get(0),manageXml.getMio_colore_casella_libera_sfondo().get(1),manageXml.getMio_colore_casella_libera_sfondo().get(2)));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.casella_libera:
                resetButton();
                activity.modificaLayout(1.5f, 1.5f, 1.5f, 3);
                activity.getSfondo().setVisibility(View.VISIBLE);
                activity.getTesto().setVisibility(View.VISIBLE);
                activity.setButton(activity.getCasella_in_gioco(), 18, 18, 18, 18, Color.WHITE, Color.BLACK, Color.WHITE);
                activity.setButton(activity.getSfondo(), 18, 18, 18, 18, Color.WHITE, Color.BLACK, Color.WHITE);
                activity.setButton(activity.getTesto(), 18, 18, 18, 18, Color.BLACK, Color.WHITE, Color.BLACK);
                setColor(manageXml.getColore_casella_libera_sfondo().get(0),manageXml.getColore_casella_libera_sfondo().get(1),manageXml.getColore_casella_libera_sfondo().get(2));
                activity.getMy_color().setBackgroundColor(Color.rgb(manageXml.getMio_colore_casella_libera_sfondo().get(0),manageXml.getMio_colore_casella_libera_sfondo().get(1),manageXml.getMio_colore_casella_libera_sfondo().get(2)));
                the_view = 0;
                break;
            case R.id.casella_tap:
                resetButton();
                activity.modificaLayout(1.5f, 1.5f, 1.5f, 3);
                activity.getSfondo().setVisibility(View.VISIBLE);
                activity.getTesto().setVisibility(View.VISIBLE);
                activity.setButton(activity.getCasella_estratta(), 18, 18, 18, 18, Color.WHITE, Color.BLACK, Color.WHITE);
                activity.setButton(activity.getSfondo(), 18, 18, 18, 18, Color.WHITE, Color.BLACK, Color.WHITE);
                activity.setButton(activity.getTesto(), 18, 18, 18, 18, Color.BLACK, Color.WHITE, Color.BLACK);
                setColor(manageXml.getColore_casella_tappata_sfondo().get(0),manageXml.getColore_casella_tappata_sfondo().get(1),manageXml.getColore_casella_tappata_sfondo().get(2));
                activity.getMy_color().setBackgroundColor(Color.rgb(manageXml.getMio_colore_casella_tappata_sfondo().get(0),manageXml.getMio_colore_casella_tappata_sfondo().get(1),manageXml.getMio_colore_casella_tappata_sfondo().get(2)));
                the_view = 2;
                break;
            case R.id.bordo:
                resetButton();
                activity.modificaLayout(1.5f, 1.5f, 1.5f, 3);
                activity.getSfondo().setVisibility(View.INVISIBLE);
                activity.getTesto().setVisibility(View.INVISIBLE);
                activity.setButton(activity.getBordo(), 18, 18, 18, 18, Color.WHITE, Color.BLACK, Color.WHITE);
                setColor(manageXml.getColore_bordo().get(0),manageXml.getColore_bordo().get(1),manageXml.getColore_bordo().get(2));
                activity.getMy_color().setBackgroundColor(Color.rgb(manageXml.getMio_colore_bordo().get(0),manageXml.getMio_colore_bordo().get(1),manageXml.getMio_colore_bordo().get(2)));
                the_view = 4;
                break;
            case R.id.pausa:
                resetButton();
                activity.getSfondo().setVisibility(View.INVISIBLE);
                activity.getTesto().setVisibility(View.INVISIBLE);
                activity.modificaLayout(0,0,0,0);
                activity.setButton(activity.getImpostazioni_pausa(), 18, 18, 18, 18, Color.WHITE, Color.BLACK, Color.WHITE);
                the_view = 5;
                break;
            case R.id.sfondo:
                activity.setButton(activity.getSfondo(), 18, 18, 18, 18, Color.WHITE, Color.BLACK, Color.WHITE);
                activity.setButton(activity.getTesto(), 18, 18, 18, 18, Color.BLACK, Color.WHITE, Color.BLACK);
                if (the_view == 1){
                    the_view = 0;
                    setColor(manageXml.getColore_casella_libera_sfondo().get(0),manageXml.getColore_casella_libera_sfondo().get(1),manageXml.getColore_casella_libera_sfondo().get(2));
                    activity.getMy_color().setBackgroundColor(Color.rgb(manageXml.getMio_colore_casella_libera_sfondo().get(0),manageXml.getMio_colore_casella_libera_sfondo().get(1),manageXml.getMio_colore_casella_libera_sfondo().get(2)));
                }
                if (the_view == 3){
                    the_view = 2;
                    setColor(manageXml.getColore_casella_tappata_sfondo().get(0),manageXml.getColore_casella_tappata_sfondo().get(1),manageXml.getColore_casella_tappata_sfondo().get(2));
                    activity.getMy_color().setBackgroundColor(Color.rgb(manageXml.getMio_colore_casella_tappata_sfondo().get(0),manageXml.getMio_colore_casella_tappata_sfondo().get(1),manageXml.getMio_colore_casella_tappata_sfondo().get(2)));
                }
                break;
            case R.id.testo:
                activity.setButton(activity.getTesto(), 18, 18, 18, 18, Color.WHITE, Color.BLACK, Color.WHITE);
                activity.setButton(activity.getSfondo(), 18, 18, 18, 18, Color.BLACK, Color.WHITE, Color.BLACK);
                if (the_view == 0){
                    the_view = 1;
                    setColor(manageXml.getColore_casella_libera_testo().get(0),manageXml.getColore_casella_libera_testo().get(1),manageXml.getColore_casella_libera_testo().get(2));
                    activity.getMy_color().setBackgroundColor(Color.rgb(manageXml.getMio_colore_casella_libera_testo().get(0),manageXml.getMio_colore_casella_libera_testo().get(1),manageXml.getMio_colore_casella_libera_testo().get(2)));
                }
                if (the_view == 2){
                    the_view = 3;
                    setColor(manageXml.getColore_casella_tappata_testo().get(0),manageXml.getColore_casella_tappata_testo().get(1),manageXml.getColore_casella_tappata_testo().get(2));
                    activity.getMy_color().setBackgroundColor(Color.rgb(manageXml.getMio_colore_casella_tappata_testo().get(0),manageXml.getMio_colore_casella_tappata_testo().get(1),manageXml.getMio_colore_casella_tappata_testo().get(2)));
                }
                break;
            case R.id.orange:
                setColor(255,140,0);
                break;
            case R.id.azure:
                setColor(135,206,235);
                break;
            case R.id.green:
                setColor(34,139,34);
                break;
            case R.id.gray:
                setColor(211,211,211);
                break;
            case R.id.red:
                setColor(220,20,60);
                break;
            case R.id.yellow:
                setColor(255,215,0);
                break;
            case R.id.my_color:
                setColor(255,215,0);
                break;
            case R.id.imposta:
                int r = Integer.parseInt(activity.getValue_rosso().getText().toString());
                int v = Integer.parseInt(activity.getValue_verde().getText().toString());
                int b = Integer.parseInt(activity.getValue_blu().getText().toString());
                if (the_view == 0){
                    manageXml.getColore_casella_libera_sfondo().set(0,r);
                    manageXml.getColore_casella_libera_sfondo().set(1,v);
                    manageXml.getColore_casella_libera_sfondo().set(2,b);
                }
                if (the_view == 1){
                    manageXml.getColore_casella_libera_testo().set(0,r);
                    manageXml.getColore_casella_libera_testo().set(1,v);
                    manageXml.getColore_casella_libera_testo().set(2,b);
                }
                if (the_view == 2){
                    manageXml.getColore_casella_tappata_sfondo().set(0,r);
                    manageXml.getColore_casella_tappata_sfondo().set(1,v);
                    manageXml.getColore_casella_tappata_sfondo().set(2,b);
                }
                if (the_view == 3){
                    manageXml.getColore_casella_tappata_testo().set(0,r);
                    manageXml.getColore_casella_tappata_testo().set(1,v);
                    manageXml.getColore_casella_tappata_testo().set(2,b);
                }
                if (the_view == 4){
                    manageXml.getColore_bordo().set(0,r);
                    manageXml.getColore_bordo().set(1,v);
                    manageXml.getColore_bordo().set(2,b);
                }
                try {
                    manageXml.setOst(activity.openFileOutput("config.xml", MODE_PRIVATE));
                    manageXml.writeXml(manageXml.getColore_casella_libera_sfondo(), manageXml.getMio_colore_casella_libera_sfondo(), manageXml.getColore_casella_libera_testo(),
                            manageXml.getMio_colore_casella_libera_testo(), manageXml.getColore_casella_tappata_sfondo(), manageXml.getMio_colore_casella_tappata_sfondo(),
                            manageXml.getColore_casella_tappata_testo(), manageXml.getMio_colore_casella_tappata_testo(), manageXml.getColore_bordo(), manageXml.getMio_colore_bordo());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.salva:
                int rM = Integer.parseInt(activity.getValue_rosso().getText().toString());
                int vM = Integer.parseInt(activity.getValue_verde().getText().toString());
                int bM = Integer.parseInt(activity.getValue_blu().getText().toString());
                activity.getMy_color().setBackgroundColor(Color.rgb(rM,vM,bM));
                if (the_view == 0){
                    manageXml.getMio_colore_casella_libera_sfondo().set(0,rM);
                    manageXml.getMio_colore_casella_libera_sfondo().set(1,vM);
                    manageXml.getMio_colore_casella_libera_sfondo().set(2,bM);
                }
                if (the_view == 1){
                    manageXml.getMio_colore_casella_libera_testo().set(0,rM);
                    manageXml.getMio_colore_casella_libera_testo().set(1,vM);
                    manageXml.getMio_colore_casella_libera_testo().set(2,bM);
                }
                if (the_view == 2){
                    manageXml.getMio_colore_casella_tappata_sfondo().set(0,rM);
                    manageXml.getMio_colore_casella_tappata_sfondo().set(1,vM);
                    manageXml.getMio_colore_casella_tappata_sfondo().set(2,bM);
                }
                if (the_view == 3){
                    manageXml.getMio_colore_casella_tappata_testo().set(0,rM);
                    manageXml.getMio_colore_casella_tappata_testo().set(1,vM);
                    manageXml.getMio_colore_casella_tappata_testo().set(2,bM);
                }
                if (the_view == 4){
                    manageXml.getMio_colore_bordo().set(0,rM);
                    manageXml.getMio_colore_bordo().set(1,vM);
                    manageXml.getMio_colore_bordo().set(2,bM);
                }
                try {
                    manageXml.setOst(activity.openFileOutput("config.xml", MODE_PRIVATE));
                    manageXml.writeXml(manageXml.getColore_casella_libera_sfondo(), manageXml.getMio_colore_casella_libera_sfondo(), manageXml.getColore_casella_libera_testo(),
                            manageXml.getMio_colore_casella_libera_testo(), manageXml.getColore_casella_tappata_sfondo(), manageXml.getMio_colore_casella_tappata_sfondo(),
                            manageXml.getColore_casella_tappata_testo(), manageXml.getMio_colore_casella_tappata_testo(), manageXml.getColore_bordo(), manageXml.getMio_colore_bordo());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        switch (seekBar.getId()) {
            case R.id.rosso:
                activity.getValue_rosso().setText(String.format("%s",i));
                break;
            case R.id.verde:
                activity.getValue_verde().setText(String.format("%s",i));
                break;
            case R.id.blu:
                activity.getValue_blu().setText(String.format("%s",i));
                break;
        }
        activity.getRun_color().setBackgroundColor(Color.rgb(Integer.parseInt(activity.getValue_rosso().getText().toString()),Integer.parseInt(activity.getValue_verde().getText().toString()),Integer.parseInt(activity.getValue_blu().getText().toString())));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    private void resetButton(){
        activity.setButton(activity.getCasella_in_gioco(), 18, 18, 18, 18, Color.BLACK, Color.WHITE, Color.BLACK);
        activity.setButton(activity.getCasella_estratta(), 18, 18, 18, 18, Color.BLACK, Color.WHITE, Color.BLACK);
        activity.setButton(activity.getBordo(), 18, 18, 18, 18, Color.BLACK, Color.WHITE, Color.BLACK);
        activity.setButton(activity.getImpostazioni_pausa(), 18, 18, 18, 18, Color.BLACK, Color.WHITE, Color.BLACK);
    }

    private void setColor(int red, int green, int blu){
        activity.getRosso().setProgress(red);
        activity.getVerde().setProgress(green);
        activity.getBlu().setProgress(blu);
        activity.getValue_rosso().setText(String.format("%s",red));
        activity.getValue_verde().setText(String.format("%s",green));
        activity.getValue_blu().setText(String.format("%s",blu));
        activity.getRun_color().setBackgroundColor(Color.rgb(Integer.parseInt(activity.getValue_rosso().getText().toString()),Integer.parseInt(activity.getValue_verde().getText().toString()),Integer.parseInt(activity.getValue_blu().getText().toString())));
    }
}
