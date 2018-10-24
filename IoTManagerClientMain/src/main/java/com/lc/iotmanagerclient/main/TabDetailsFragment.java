package com.lc.iotmanagerclient.main;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;

import com.lc.iotmanagerclient.R;

/**
 * Classe per la gestione del fragment che contiene la vista di dettaglio del sensore
 * Layout di riferimento: "res/layout/details_layout.xml".
 */
public class TabDetailsFragment extends Fragment{

	View rootView;
	LinearLayout ll;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView= inflater.inflate(R.layout.details_layout, container);
		ll=(LinearLayout)rootView.findViewById(R.id.detailsToFill);
		return rootView;
	}

	public void updateView(View v) {
		ll.removeAllViews();
		LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		ll.addView(v, params);
	}
	
	public void resetView(){
		ll.removeAllViews();
		ll.invalidate();
	}

	
	
}
