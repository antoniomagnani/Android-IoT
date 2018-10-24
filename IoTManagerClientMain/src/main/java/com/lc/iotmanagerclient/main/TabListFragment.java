package com.lc.iotmanagerclient.main;

import java.util.ArrayList;

import android.app.ListFragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.lc.iotmanagerclient.R;
import com.lc.iotmanagerclient.SCO.SCLO;
import com.lc.iotmanagerclient.SCO.SCLOArrayAdapter;

/**
 * Classe per la gestione del fragment che contiene la lista ordinata per distanza di oggetti SCLO
 * Layout di riferimento: "res/layout/item_in_list.xml".
 */
public class TabListFragment extends ListFragment {

	private ArrayList<SCLO> itemList;
	private SCLOArrayAdapter arrayAdapter;
	private ListView lv;
	private View lastSelected;


	/**
	 * Metodo per collegarsi all'Activity principale
	 */
	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
	}

	/**
	 * Metodo richiamato al completamento dell'evento onCreate dall'Activity principale
	 */
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		itemList = new ArrayList<>();
		arrayAdapter = new SCLOArrayAdapter(getActivity(),
				R.layout.item_in_list, itemList);

		lv = getListView();
		lv.setAdapter(arrayAdapter);

		lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

	}

	/**
	 * Metodo che aggiorna la lista di oggetti SCLO mostrata
	 */
	public void updateFragmentList(ArrayList<SCLO> newItemList) {
		setListShown(false);
		if(newItemList==null) newItemList=new ArrayList<SCLO>();
		this.itemList = newItemList;

		arrayAdapter = new SCLOArrayAdapter(getActivity(),
				R.layout.item_in_list, itemList);
		getListView().setAdapter(arrayAdapter);

		setListShown(true);
	}

	/**
	 * Metodo per gestire l'evento di pressione della riga sulla lista di oggetti SCLO
	 */
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		arrayAdapter.setSelected(position);
		if (lastSelected != null && lastSelected != v)
			( lastSelected.findViewById(R.id.itemSelector)).setBackgroundColor(Color.TRANSPARENT);
		lastSelected = v;
		(v.findViewById(R.id.itemSelector)).setBackgroundResource(R.drawable.selector);
		int currentId = itemList.get(position).getId();
		int currentCat = itemList.get(position).getCategoria();
		((TabMainActivity) getActivity()).onItemSelected(currentId, currentCat, false);
	}

	/**
	 * Elimina la freccia del selettore.
	 */
	public void clearSelection() {
		if (lastSelected != null)
			(lastSelected.findViewById(R.id.itemSelector))
					.setBackgroundColor(Color.TRANSPARENT);
	}

}
