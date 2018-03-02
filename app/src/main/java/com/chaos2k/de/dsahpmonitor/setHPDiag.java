package com.chaos2k.de.dsahpmonitor;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;


public class setHPDiag extends DialogFragment{
    EditText hp;
    int inputHP;
    @Override
    public Dialog onCreateDialog (Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Lebenspunkte");
        final LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.setdiag, null);
        hp = dialogView.findViewById(R.id.healthPoints);
        builder.setView(dialogView).setMessage("Lebenspunkte");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id){
                MainActivity callingActivity = (MainActivity) getActivity();
                inputHP = Integer.parseInt(hp.getText().toString());
                callingActivity.maxLE = inputHP;
                callingActivity.aktuelleLE = inputHP;
                callingActivity.LEWert.setText(String.format("%02d",inputHP));
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id){
                dismiss();
            }
        });
//        final EditText healthPoints = (EditText) dialogView.findViewById(R.id.healtPoints);
        return builder.create();
    }
}