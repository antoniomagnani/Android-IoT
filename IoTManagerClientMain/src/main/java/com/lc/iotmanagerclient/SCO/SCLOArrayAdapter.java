package com.lc.iotmanagerclient.SCO;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lc.iotmanagerclient.R;

/**
 * ArrayAdapter personalizzato per riempire dinamicamente la list view della Main Activity
 * al ricevimento di una lista di SCLO. In particolare viene ridefinito il metodo getView
 */
public class SCLOArrayAdapter extends
		ArrayAdapter<SCLO> {

	private int listRowLayout;
	private LayoutInflater inflater;
	private int selected;

	/**
	 * Costruttore
	 * 
	 * @param context L'activity chiamante
	 * @param textViewResourceId La view relativa
	 * @param itemList La lista di SCLO da trattare
	 */
	public SCLOArrayAdapter(Context context,
					 int textViewResourceId, ArrayList<SCLO> itemList) {
		super(context, textViewResourceId, itemList);

		this.listRowLayout = textViewResourceId;
		this.inflater = LayoutInflater.from(context);
		selected = -1;
	}

	/**
	 * Riempie la riga in questione con il giusto nome, distanza e icona dell'oggetto
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		SCLO item = getItem(position);
		SCLOViewCache itemCache;

		if (convertView == null) {
			convertView = inflater.inflate(listRowLayout, null);
			itemCache = new SCLOViewCache(convertView);
			convertView.setTag(itemCache);
		} else {
			itemCache = (SCLOViewCache) convertView.getTag();
		}
		
		ImageView itemIcon = itemCache.getItemIcon();
		itemIcon.setBackgroundResource(item.getIcon());
		if (!SCO.getStatus(item.getCategoria(), item.getStato())) itemIcon.setImageResource(R.drawable.ic_error_status);
		else  itemIcon.setImageBitmap(null);
		
		if(selected != -1){
			if(position == selected) itemCache.getArrowForSelected().setBackgroundResource(R.drawable.selector);
			else itemCache.getArrowForSelected().setBackgroundColor(Color.TRANSPARENT);
		}
		
		TextView itemName = itemCache.getItemName();
		itemName.setText(item.formattaNome());

		TextView itemDist = itemCache.getItemDist();
		itemDist.setText(item.getDistanza());

		return convertView;
	}

	/**
	 * GETTER, SETTER
	 */

	public int getSelected() {
		return selected;
	}

	public void setSelected(int selected) {
		this.selected = selected;
	}

	/**
	 * FINE GETTER, SETTER
	 */
}
