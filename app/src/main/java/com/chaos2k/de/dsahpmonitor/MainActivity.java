package com.chaos2k.de.dsahpmonitor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.LoginException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public int maxLE = 0;
    public int maxAE = 0;
    public int aktuelleLE = 0;
    public int aktuelleAE = 0;
    public int schmerz = 0;
    public int offsetSchmerz = 0;
    public List<ImageView> schmerzPunkte = new ArrayList<>();

    TextView AEWert;
    TextView LEWert;

    Button AEplus1;
    Button AEplus5;
    Button AEminus1;
    Button AEminus5;
    Button LEplus1;
    Button LEplus5;
    Button LEminus1;
    Button LEminus5;
    Button SchmerzMinus;
    Button SchmerzPlus;
    ImageView schmerzStufe1;
    ImageView schmerzStufe2;
    ImageView schmerzStufe3;
    TextView resetSchmerz;
    TextView Lebensenergie;
    TextView Astralenergie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AEWert = (TextView) findViewById(R.id.AEWert);
        LEWert = (TextView) findViewById(R.id.LEWert);
        Astralenergie = (TextView) findViewById(R.id.Astralenergie);
        Lebensenergie = (TextView) findViewById(R.id.Lebensenergie);

        schmerzStufe1 = (ImageView) findViewById(R.id.Stufe1Checked);
        schmerzStufe2 = (ImageView) findViewById(R.id.Stufe2Checked);
        schmerzStufe3 = (ImageView) findViewById(R.id.Stufe3Checked);
        AEplus1 = (Button) findViewById(R.id.AEplus1But);
        AEplus5 = (Button) findViewById(R.id.AEplus5But);
        AEminus1 = (Button) findViewById(R.id.AEminus1But);
        AEminus5 = (Button) findViewById(R.id.AEminus5But);
        LEplus1 = (Button) findViewById(R.id.LEplus1But);
        LEplus5 = (Button) findViewById(R.id.LEplus5But);
        LEminus1 = (Button) findViewById(R.id.LEminus1But);
        LEminus5 = (Button) findViewById(R.id.LEminus5But);
        SchmerzMinus = (Button) findViewById(R.id.SchmerzMinus);
        SchmerzPlus = (Button) findViewById(R.id.SchmerzPlus);
        resetSchmerz = (TextView) findViewById(R.id.SchmerzText);
        schmerzPunkte.add(schmerzStufe1);
        schmerzPunkte.add(schmerzStufe2);
        schmerzPunkte.add(schmerzStufe3);

        AEplus1.setOnClickListener(this);
        AEplus1.setOnLongClickListener(
                new View.OnLongClickListener(){
                    @Override
                    public boolean onLongClick(View view){
                        maxAE = maxAE++;
                        aktuelleAE = aktuelleAE++;
                        AEWert.setText(String.format("%02d",aktuelleAE));
                        return true;
                    }
                }
        );
        AEplus5.setOnClickListener(this);
        AEplus5.setOnLongClickListener(
                new View.OnLongClickListener(){
                    @Override
                    public boolean onLongClick(View view){
                        maxAE = maxAE+5;
                        aktuelleAE = aktuelleAE+5;
                        AEWert.setText(String.format("%02d",aktuelleAE));
                        return true;
                    }
                }
        );
        AEminus1.setOnClickListener(this);
        AEminus1.setOnLongClickListener(
                new View.OnLongClickListener(){
                    @Override
                    public boolean onLongClick(View view){
                        maxAE = maxAE--;
                        aktuelleAE = aktuelleAE--;
                        AEWert.setText(String.format("%02d",aktuelleAE));
                        return true;
                    }
                }
        );
        AEminus5.setOnClickListener(this);
        AEminus5.setOnLongClickListener(
                new View.OnLongClickListener(){
                    @Override
                    public boolean onLongClick(View view){
                        maxAE = maxAE-5;
                        aktuelleAE = aktuelleAE-5;
                        AEWert.setText(String.format("%02d",aktuelleAE));
                        return true;
                    }
                }
        );
        LEplus1.setOnClickListener(this);
        LEplus1.setOnLongClickListener(
                new View.OnLongClickListener(){
                    @Override
                    public boolean onLongClick(View view){
                        maxLE = maxLE++;
                        aktuelleLE = aktuelleLE++;
                        LEWert.setText(String.format("%02d",aktuelleLE));
                        return true;
                    }
                }
        );
        LEplus5.setOnClickListener(this);
        LEplus5.setOnLongClickListener(
                new View.OnLongClickListener(){
                    @Override
                    public boolean onLongClick(View view){
                        maxLE = maxLE+5;
                        aktuelleLE = aktuelleLE+5;
                        LEWert.setText(String.format("%02d",aktuelleLE));
                        return true;
                    }
                }
        );
        LEminus1.setOnClickListener(this);
        LEminus1.setOnLongClickListener(
                new View.OnLongClickListener(){
                    @Override
                    public boolean onLongClick(View view){
                        maxLE = maxLE--;
                        aktuelleLE = aktuelleLE--;
                        LEWert.setText(String.format("%02d",aktuelleLE));
                        return true;
                    }
                }
        );
        LEminus5.setOnClickListener(this);
        LEminus5.setOnLongClickListener(
                new View.OnLongClickListener(){
                    @Override
                    public boolean onLongClick(View view){
                        maxLE = maxLE-5;
                        aktuelleLE = aktuelleLE-5;
                        LEWert.setText(String.format("%02d",aktuelleLE));
                        return true;
                    }
                }
        );
        SchmerzMinus.setOnClickListener(this);
        SchmerzPlus.setOnClickListener(this);

        resetSchmerz.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    offsetSchmerz = 0;
                    schmerzHandler(offsetSchmerz);
                    }
                }
        );

        Lebensenergie.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        setHPDiag setHP = new setHPDiag();
                        setHP.show(getSupportFragmentManager(),"123");
                    }
                }
            );

        Astralenergie.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        setAEDiag setAE = new setAEDiag();
                        setAE.show(getSupportFragmentManager(),"123");
                    }
                }
            );
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View view) {
        aELEwerteAendern(view);
    }

    public void schmerzHandler(int schmerzOffset){
        int tempSchmerz = schmerz;
        if ((float) aktuelleLE / maxLE > 0.75) {
            tempSchmerz=0+schmerzOffset;
        }
        if ((float) aktuelleLE / maxLE <= 0.75 && (float) aktuelleLE / maxLE > 0.50) {
            tempSchmerz=1+schmerzOffset;
        }
        if ((float) aktuelleLE / maxLE <= 0.50 && (float) aktuelleLE / maxLE > 0.25) {
            tempSchmerz=2+schmerzOffset;
        }
        if ((float) aktuelleLE / maxLE <= 0.25) {
            tempSchmerz=3+schmerzOffset;
        }
//        tempSchmerz = tempSchmerz+schmerzOffset;
        if (tempSchmerz < 0){ tempSchmerz = 0; };
        if (tempSchmerz > 3){ tempSchmerz = 3; };
        if (tempSchmerz != schmerz){
            schmerzPunkte.get(0).setVisibility(View.INVISIBLE);
            schmerzPunkte.get(1).setVisibility(View.INVISIBLE);
            schmerzPunkte.get(2).setVisibility(View.INVISIBLE);
            int i = 0;
            while (i < 4) {
                if (i < tempSchmerz) {
                    schmerzPunkte.get(i).setVisibility(View.VISIBLE);
                }
                i++;
            }
            schmerz = tempSchmerz;
        }
    }

    public void aELEwerteAendern(View view) {
        switch (view.getId()) {
            case R.id.SchmerzMinus:
                offsetSchmerz--;
                if (offsetSchmerz <= -3){offsetSchmerz = -3;};
                break;
            case R.id.SchmerzPlus:
                offsetSchmerz++;
                if (offsetSchmerz >= 3){offsetSchmerz = 3;};
                break;
            case R.id.AEminus1But:
                aktuelleAE--;
                if (aktuelleAE <= 0) {
                    aktuelleAE = 0;
                }
                AEWert.setText(String.format("%02d", aktuelleAE));
                break;
            case R.id.AEminus5But:
                aktuelleAE = aktuelleAE - 5;
                if (aktuelleAE <= 0) {
                    aktuelleAE = 0;
                }
                AEWert.setText(String.format("%02d", aktuelleAE));
                break;
            case R.id.LEminus1But:
                aktuelleLE--;
                if (aktuelleLE <= 0) {
                    aktuelleLE = 0;
                }
                LEWert.setText(String.format("%02d", aktuelleLE));
                break;
            case R.id.LEminus5But:
                aktuelleLE = aktuelleLE - 5;
                if (aktuelleLE <= 0) {
                    aktuelleLE = 0;
                }
                LEWert.setText(String.format("%02d", aktuelleLE));
                break;
            case R.id.AEplus1But:
                aktuelleAE++;
                if (aktuelleAE >= maxAE) {
                    aktuelleAE = maxAE;
                }
                AEWert.setText(String.format("%02d", aktuelleAE));
                break;
            case R.id.AEplus5But:
                aktuelleAE = aktuelleAE + 5;
                if (aktuelleAE >= maxAE) {
                    aktuelleAE = maxAE;
                }
                AEWert.setText(String.format("%02d", aktuelleAE));
                break;
            case R.id.LEplus1But:
                aktuelleLE++;
                if (aktuelleLE >= maxLE) {
                    aktuelleLE = maxLE;
                }
                LEWert.setText(String.format("%02d", aktuelleLE));
                break;
            case R.id.LEplus5But:
                aktuelleLE = aktuelleLE + 5;
                if (aktuelleLE >= maxLE) {
                    aktuelleLE = maxLE;
                }
                LEWert.setText(String.format("%02d", aktuelleLE));
                break;
        }
        schmerzHandler(offsetSchmerz);
    }
}
