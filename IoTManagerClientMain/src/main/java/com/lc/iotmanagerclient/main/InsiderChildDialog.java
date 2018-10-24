package com.lc.iotmanagerclient.main;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

import com.lc.iotmanagerclient.SCO.SCO;

/**
 * Classe che implementa la view per i sensori semplici collegati a sensori di tipo 'concentratore'
 * Quando si accede ai dettagli di un sensore semplice a partire dalla vista di dettaglio del sensore
 * padre (il concentratore), viene utilizzato questo fragment.
 */
public class InsiderChildDialog extends DialogFragment {

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		SCO oggetto = getArguments().getParcelable("SingleObj");
		builder.setTitle("Dettaglio oggetto "+ oggetto.getIDObj());
		builder.setView(oggetto.createView(getActivity()));
		builder.setPositiveButton("Nascondi", new OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
			}
		});
		return builder.create();
	}
	
}
