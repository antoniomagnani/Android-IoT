package com.lc.iotmanagerclient.utility;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Marker;

import com.lc.iotmanagerclient.SCO.SCO;

/**
 * Classe che gestisce i set di marker sulla mappa
 * Ogni istanza gestisce un solo tipo di icona
 */
public class SCMarkerGroup{
	
	/**
	 * Lista di oggetti Marker, ognuno contiene un'icona da disegnare sulla mappa
	 */
	private ArrayList<Marker> mOverlays = new ArrayList<Marker>();
	Drawable mIcon;
	Context mContext;
	int CAT;

	/**
	 * Costruttore
	 * @param icon L'icona da disegnare
	 * @param context Activity chiamante
	 * @param cat L'id di categoria o sottosistema relativo all'icona
	 */
	public SCMarkerGroup(Drawable icon, Context context, int cat){
		this.mIcon = icon;
		this.mContext = context;
		this.CAT = cat;
	}

	/**
	 * Ritorna l'oggetto i-esimo della lista
	 */
	protected Marker getItem(int i) {
	  return mOverlays.get(i);
	}

	/**
	 * Ritorna le dimensioni della lista
	 */
	public int size(){
		return mOverlays.size();
	}


	/**
	 * Ritorna la versione bitmap descriptor della drawable relativa all'icona del gruppo di marker
	 */
	public BitmapDescriptor getBitmapDescriptor() {
		BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(SCO.getIcon(this.CAT));
		return icon;
	}

	/**
	 * Aggiunge un oggetto alla lista
	 */
	public void addMarker(Marker overlay){
	    mOverlays.add(overlay);
	}
	
	/**
	 * Esegue un cleanup della lista e cancella i marker relativi dalla mappa
	 */
	public void clear() {
		for (Marker m:mOverlays) {
			m.remove();
		}
		mOverlays.clear();
    }

}
