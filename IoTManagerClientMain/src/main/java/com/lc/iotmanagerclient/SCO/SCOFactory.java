package com.lc.iotmanagerclient.SCO;

import org.json.JSONArray;

/**
 * Classe fabbrica di oggetti SCO: a seconda della categoria ritorna l'oggetto opportuno
 */
public class SCOFactory{
	
	public SCOFactory(){
		
	}
	
	/**
	 * Metodo che esegue il mapping Categoria->oggetto
	 * @param idCategoria il codice univoco che identifica la tipologia di sensore sul framework
	 * @param parsed_json stringa parsata restituita dal back-end, da utilizzare per istanziare l'oggetto
	 */
	public SCO getSCO(int idCategoria, JSONArray parsed_json){
		
		switch(idCategoria){
		case 1:
			return new SCOTc(parsed_json);
		case 2:
			return new SCOArLu(parsed_json);
		case 3:
			return new SCOLamp(parsed_json);
		case 6:
			return new SCOUdooWhst(parsed_json);
		default:
			return new SCODefault(parsed_json);
		}
		
	}

}