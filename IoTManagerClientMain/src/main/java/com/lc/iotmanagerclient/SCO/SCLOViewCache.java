package com.lc.iotmanagerclient.SCO;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lc.iotmanagerclient.R;

/**
 * Classe ausiliaria per popolare la listview. Fornisce alcuni metodi per risalire alle view
 * di dettaglio della singola riga della list view in base alla vista parent.
 */
public class SCLOViewCache {

        private View baseView;
        private TextView itemName;
        private TextView itemDist;
        private ImageView itemIcon;
        private ImageView arrowForSelected;
        
        /**
         * Costruttore
         * @param baseView La view passata in input
         */
        SCLOViewCache(View baseView ) {
                this.baseView = baseView;
        }

        /**
         * Ritorna la vista relativa al nome dell'oggetto
         */
        public TextView getItemName () {
                if ( itemName == null ) {
                	itemName = ( TextView ) baseView.findViewById( R.id.itemName );
                }
                return itemName;
        }
        
        /**
         * Ritorna la vista relativa alla distanza dell'oggetto
         */
        public TextView getItemDist () {
            if ( itemDist == null ) {
            	itemDist = ( TextView ) baseView.findViewById( R.id.itemDistance );
            }
            return itemDist;
    }

        /**
         * Ritorna la vista relativa all'icona dell'oggetto
         */
        public ImageView getItemIcon () {
                if ( itemIcon == null ) {
                	itemIcon = ( ImageView ) baseView.findViewById( R.id.itemIcon );
                }
                return itemIcon;
        }
        
        /**
         * Ritorna la vista relativa alla imageview per la selezione dell'oggetto
         */
        public ImageView getArrowForSelected() {
                if ( arrowForSelected == null ) {
                	arrowForSelected = ( ImageView ) baseView.findViewById( R.id.itemSelector );
                }
                return arrowForSelected;
        }
}