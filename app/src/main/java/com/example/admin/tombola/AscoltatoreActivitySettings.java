package com.example.admin.tombola;

import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;
import java.util.ArrayList;

public class AscoltatoreActivitySettings implements View.OnClickListener, SeekBar.OnSeekBarChangeListener{

    private ActivitySetting activity;
    private ArrayList<Integer> colore_casella_libera_testo;
    private ArrayList<Integer> colore_casella_libera_sfondo;
    private ArrayList<Integer> colore_casella_tappata_testo;
    private ArrayList<Integer> colore_casella_tappata_sfondo;
    private ArrayList<Integer> colore_bordo;
    private ArrayList<Integer> mio_colore_casella_libera_testo;
    private ArrayList<Integer> mio_colore_casella_libera_sfondo;
    private ArrayList<Integer> mio_colore_casella_tappata_testo;
    private ArrayList<Integer> mio_colore_casella_tappata_sfondo;
    private ArrayList<Integer> mio_colore_bordo;
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
        boolean casella_libera = false;
        boolean casella_tappata = false;
        boolean bordo_tag = false;
        boolean testo = false;
        boolean sfondo = false;
        this.activity= activity;
        the_view = 0;
        colore_casella_libera_testo = new ArrayList<>(3);
        colore_casella_libera_sfondo = new ArrayList<>(3);
        colore_casella_tappata_testo = new ArrayList<>(3);
        colore_casella_tappata_sfondo = new ArrayList<>(3);
        colore_bordo = new ArrayList<>(3);
        mio_colore_casella_libera_testo = new ArrayList<>(3);
        mio_colore_casella_libera_sfondo = new ArrayList<>(3);
        mio_colore_casella_tappata_testo = new ArrayList<>(3);
        mio_colore_casella_tappata_sfondo = new ArrayList<>(3);
        mio_colore_bordo = new ArrayList<>(3);
        XmlResourceParser xrp = activity.getResources().getXml(R.xml.config);
        try {
            int event = xrp.getEventType();
            while (event != XmlPullParser.END_DOCUMENT)  {
                String name=xrp.getName();
                switch (event){
                    case XmlPullParser.START_TAG:
                        Log.i("START",name);
                        if(name.equals("casella_libera"))
                            casella_libera = true;
                        if(name.equals("casella_tappata"))
                            casella_tappata = true;
                        if(name.equals("bordo"))
                            bordo_tag = true;
                        if(name.equals("testo"))
                            testo = true;
                        if(name.equals("sfondo"))
                            sfondo = true;
                        if (name.equals("color")){
                            if (casella_libera && testo){
                                colore_casella_libera_testo.add(Integer.parseInt(xrp.getAttributeValue(0)));
                                colore_casella_libera_testo.add(Integer.parseInt(xrp.getAttributeValue(1)));
                                colore_casella_libera_testo.add(Integer.parseInt(xrp.getAttributeValue(2)));
                            }
                            if (casella_libera && sfondo){
                                colore_casella_libera_sfondo.add(Integer.parseInt(xrp.getAttributeValue(0)));
                                colore_casella_libera_sfondo.add(Integer.parseInt(xrp.getAttributeValue(1)));
                                colore_casella_libera_sfondo.add(Integer.parseInt(xrp.getAttributeValue(2)));
                            }
                            if (casella_tappata && testo){
                                colore_casella_tappata_testo.add(Integer.parseInt(xrp.getAttributeValue(0)));
                                colore_casella_tappata_testo.add(Integer.parseInt(xrp.getAttributeValue(1)));
                                colore_casella_tappata_testo.add(Integer.parseInt(xrp.getAttributeValue(2)));
                            }
                            if (casella_tappata && sfondo){
                                colore_casella_tappata_sfondo.add(Integer.parseInt(xrp.getAttributeValue(0)));
                                colore_casella_tappata_sfondo.add(Integer.parseInt(xrp.getAttributeValue(1)));
                                colore_casella_tappata_sfondo.add(Integer.parseInt(xrp.getAttributeValue(2)));
                            }
                            if (bordo_tag){
                                colore_bordo.add(Integer.parseInt(xrp.getAttributeValue(0)));
                                colore_bordo.add(Integer.parseInt(xrp.getAttributeValue(1)));
                                colore_bordo.add(Integer.parseInt(xrp.getAttributeValue(2)));
                            }
                        }
                        if (name.equals("my_color")){
                            if (casella_libera && testo) {
                                testo = false;
                                casella_libera = false;
                                mio_colore_casella_libera_testo.add(Integer.parseInt(xrp.getAttributeValue(0)));
                                mio_colore_casella_libera_testo.add(Integer.parseInt(xrp.getAttributeValue(1)));
                                mio_colore_casella_libera_testo.add(Integer.parseInt(xrp.getAttributeValue(2)));
                            }
                            if (casella_libera && sfondo) {
                                sfondo = false;
                                mio_colore_casella_libera_sfondo.add(Integer.parseInt(xrp.getAttributeValue(0)));
                                mio_colore_casella_libera_sfondo.add(Integer.parseInt(xrp.getAttributeValue(1)));
                                mio_colore_casella_libera_sfondo.add(Integer.parseInt(xrp.getAttributeValue(2)));
                            }
                            if (casella_tappata && testo){
                                testo = false;
                                casella_tappata = false;
                                mio_colore_casella_tappata_testo.add(Integer.parseInt(xrp.getAttributeValue(0)));
                                mio_colore_casella_tappata_testo.add(Integer.parseInt(xrp.getAttributeValue(1)));
                                mio_colore_casella_tappata_testo.add(Integer.parseInt(xrp.getAttributeValue(2)));
                            }
                            if (casella_tappata && sfondo) {
                                sfondo = false;
                                mio_colore_casella_tappata_sfondo.add(Integer.parseInt(xrp.getAttributeValue(0)));
                                mio_colore_casella_tappata_sfondo.add(Integer.parseInt(xrp.getAttributeValue(1)));
                                mio_colore_casella_tappata_sfondo.add(Integer.parseInt(xrp.getAttributeValue(2)));}
                            if (bordo_tag) {
                                bordo_tag = false;
                                mio_colore_bordo.add(Integer.parseInt(xrp.getAttributeValue(0)));
                                mio_colore_bordo.add(Integer.parseInt(xrp.getAttributeValue(1)));
                                mio_colore_bordo.add(Integer.parseInt(xrp.getAttributeValue(2)));
                            }
                        }
                        break;
                }
                event = xrp.next();
            }
        } catch (XmlPullParserException | IOException e) {
            e.printStackTrace();
        }
        setColor(colore_casella_libera_sfondo.get(0),colore_casella_libera_sfondo.get(1),colore_casella_libera_sfondo.get(2));
        activity.getMy_color().setBackgroundColor(Color.rgb(mio_colore_casella_libera_sfondo.get(0),mio_colore_casella_libera_sfondo.get(1),mio_colore_casella_libera_sfondo.get(2)));
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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.casella_libera:
                resetButton();
                activity.getSfondo().setVisibility(View.VISIBLE);
                activity.getTesto().setVisibility(View.VISIBLE);
                activity.setButton(activity.getCasella_in_gioco(), 18, 18, 18, 18, Color.WHITE, Color.BLACK, Color.WHITE);
                activity.setButton(activity.getSfondo(), 18, 18, 18, 18, Color.WHITE, Color.BLACK, Color.WHITE);
                activity.setButton(activity.getTesto(), 18, 18, 18, 18, Color.BLACK, Color.WHITE, Color.BLACK);
                setColor(colore_casella_libera_sfondo.get(0),colore_casella_libera_sfondo.get(1),colore_casella_libera_sfondo.get(2));
                activity.getMy_color().setBackgroundColor(Color.rgb(mio_colore_casella_libera_sfondo.get(0),mio_colore_casella_libera_sfondo.get(1),mio_colore_casella_libera_sfondo.get(2)));
                the_view = 0;
                break;
            case R.id.casella_tap:
                resetButton();
                activity.getSfondo().setVisibility(View.VISIBLE);
                activity.getTesto().setVisibility(View.VISIBLE);
                activity.setButton(activity.getCasella_estratta(), 18, 18, 18, 18, Color.WHITE, Color.BLACK, Color.WHITE);
                activity.setButton(activity.getSfondo(), 18, 18, 18, 18, Color.WHITE, Color.BLACK, Color.WHITE);
                activity.setButton(activity.getTesto(), 18, 18, 18, 18, Color.BLACK, Color.WHITE, Color.BLACK);
                setColor(colore_casella_tappata_sfondo.get(0),colore_casella_tappata_sfondo.get(1),colore_casella_tappata_sfondo.get(2));
                activity.getMy_color().setBackgroundColor(Color.rgb(mio_colore_casella_tappata_sfondo.get(0),mio_colore_casella_tappata_sfondo.get(1),mio_colore_casella_tappata_sfondo.get(2)));
                the_view = 2;
                break;
            case R.id.bordo:
                resetButton();
                activity.getSfondo().setVisibility(View.INVISIBLE);
                activity.getTesto().setVisibility(View.INVISIBLE);
                activity.setButton(activity.getBordo(), 18, 18, 18, 18, Color.WHITE, Color.BLACK, Color.WHITE);
                setColor(colore_bordo.get(0),colore_bordo.get(1),colore_bordo.get(2));
                activity.getMy_color().setBackgroundColor(Color.rgb(mio_colore_bordo.get(0),mio_colore_bordo.get(1),mio_colore_bordo.get(2)));
                the_view = 4;
                break;
            case R.id.pausa:
                resetButton();
                activity.getSfondo().setVisibility(View.INVISIBLE);
                activity.getTesto().setVisibility(View.INVISIBLE);
                activity.setButton(activity.getImpostazioni_pausa(), 18, 18, 18, 18, Color.WHITE, Color.BLACK, Color.WHITE);
                the_view = 5;
                break;
            case R.id.sfondo:
                activity.setButton(activity.getSfondo(), 18, 18, 18, 18, Color.WHITE, Color.BLACK, Color.WHITE);
                activity.setButton(activity.getTesto(), 18, 18, 18, 18, Color.BLACK, Color.WHITE, Color.BLACK);
                if (the_view == 1){
                    the_view = 0;
                    setColor(colore_casella_libera_sfondo.get(0),colore_casella_libera_sfondo.get(1),colore_casella_libera_sfondo.get(2));
                    activity.getMy_color().setBackgroundColor(Color.rgb(mio_colore_casella_libera_sfondo.get(0),mio_colore_casella_libera_sfondo.get(1),mio_colore_casella_libera_sfondo.get(2)));
                }
                if (the_view == 3){
                    the_view = 2;
                    setColor(colore_casella_tappata_sfondo.get(0),colore_casella_tappata_sfondo.get(1),colore_casella_tappata_sfondo.get(2));
                    activity.getMy_color().setBackgroundColor(Color.rgb(mio_colore_casella_tappata_sfondo.get(0),mio_colore_casella_tappata_sfondo.get(1),mio_colore_casella_tappata_sfondo.get(2)));
                }
                break;
            case R.id.testo:
                activity.setButton(activity.getTesto(), 18, 18, 18, 18, Color.WHITE, Color.BLACK, Color.WHITE);
                activity.setButton(activity.getSfondo(), 18, 18, 18, 18, Color.BLACK, Color.WHITE, Color.BLACK);
                if (the_view == 0){
                    the_view = 1;
                    setColor(colore_casella_libera_testo.get(0),colore_casella_libera_testo.get(1),colore_casella_libera_testo.get(2));
                    activity.getMy_color().setBackgroundColor(Color.rgb(mio_colore_casella_libera_testo.get(0),mio_colore_casella_libera_testo.get(1),mio_colore_casella_libera_testo.get(2)));
                }
                if (the_view == 2){
                    the_view = 3;
                    setColor(colore_casella_tappata_testo.get(0),colore_casella_tappata_testo.get(1),colore_casella_tappata_testo.get(2));
                    activity.getMy_color().setBackgroundColor(Color.rgb(mio_colore_casella_tappata_testo.get(0),mio_colore_casella_tappata_testo.get(1),mio_colore_casella_tappata_testo.get(2)));
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
                    colore_casella_libera_sfondo.set(0,r);
                    colore_casella_libera_sfondo.set(1,v);
                    colore_casella_libera_sfondo.set(2,b);
                }
                if (the_view == 1){
                    colore_casella_libera_testo.set(0,r);
                    colore_casella_libera_testo.set(1,v);
                    colore_casella_libera_testo.set(2,b);
                }
                if (the_view == 2){
                    colore_casella_tappata_sfondo.set(0,r);
                    colore_casella_tappata_sfondo.set(1,v);
                    colore_casella_tappata_sfondo.set(2,b);
                }
                if (the_view == 3){
                    colore_casella_tappata_testo.set(0,r);
                    colore_casella_tappata_testo.set(1,v);
                    colore_casella_tappata_testo.set(2,b);
                }
                if (the_view == 4){
                    colore_bordo.set(0,r);
                    colore_bordo.set(1,v);
                    colore_bordo.set(2,b);
                }
                break;
            case R.id.salva:
                int rM = Integer.parseInt(activity.getValue_rosso().getText().toString());
                int vM = Integer.parseInt(activity.getValue_verde().getText().toString());
                int bM = Integer.parseInt(activity.getValue_blu().getText().toString());
                activity.getMy_color().setBackgroundColor(Color.rgb(rM,vM,bM));
                if (the_view == 0){
                    mio_colore_casella_libera_sfondo.set(0,rM);
                    mio_colore_casella_libera_sfondo.set(1,vM);
                    mio_colore_casella_libera_sfondo.set(2,bM);
                }
                if (the_view == 1){
                    mio_colore_casella_libera_testo.set(0,rM);
                    mio_colore_casella_libera_testo.set(1,vM);
                    mio_colore_casella_libera_testo.set(2,bM);
                }
                if (the_view == 2){
                    mio_colore_casella_tappata_sfondo.set(0,rM);
                    mio_colore_casella_tappata_sfondo.set(1,vM);
                    mio_colore_casella_tappata_sfondo.set(2,bM);
                }
                if (the_view == 3){
                    mio_colore_casella_tappata_testo.set(0,rM);
                    mio_colore_casella_tappata_testo.set(1,vM);
                    mio_colore_casella_tappata_testo.set(2,bM);
                }
                if (the_view == 4){
                    mio_colore_bordo.set(0,rM);
                    mio_colore_bordo.set(1,vM);
                    mio_colore_bordo.set(2,bM);
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
}
