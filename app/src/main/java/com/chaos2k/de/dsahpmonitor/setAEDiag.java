package com.chaos2k.de.dsahpmonitor;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;



public class setAEDiag extends DialogFragment{
    EditText ae;
    int inputAE;
    @Override
    public Dialog onCreateDialog (Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("Astralpunkte");
        final LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.setdiag, null);
        ae = dialogView.findViewById(R.id.healthPoints);
        builder.setView(dialogView).setMessage("Astralpunkte");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id){
                MainActivity callingActivity = (MainActivity) getActivity();
                inputAE = Integer.parseInt(ae.getText().toString());
                callingActivity.maxAE = inputAE;
                callingActivity.aktuelleAE = inputAE;
                callingActivity.AEWert.setText(String.format("%02d",inputAE));
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id){
                dismiss();
            }
        });
        return builder.create();
    }
}