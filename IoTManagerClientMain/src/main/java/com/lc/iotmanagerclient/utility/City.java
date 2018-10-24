package com.lc.iotmanagerclient.utility;

import android.os.Parcel;
import android.os.Parcelable;



/**
 * Oggetto città conforme alla tabella atlante del server (model)
 */
public class City implements Parcelable {
	
	private int id;
	private String nome;
	private String nazione;
	private int gmt;
	private double longitudine;
	private double latitudine;
	
	/**
	 * Costruttore
	 * @param id id sul database della città
	 * @param nome nome da stampare a video
	 * @param nazione nazione della città
	 * @param lng longitudine della città
	 * @param lat latitudine della città
	 * @param gmt impostazione fuso orario della città
	 */
	public City(int id, String nome, String nazione, double lng, double lat, int gmt){
		this.id = id;
		this.nome = nome;
		this.nazione = nazione;
		this.longitudine = lng;
		this.latitudine = lat;
		this.gmt = gmt;
		
	}

	/**
	 * GETTER, SETTER
	 */
	        
	public int getId(){
		return this.id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public double getLongitudine(){
		return this.longitudine;
	}
	
	public void setLongitudine(double lng){
		this.longitudine = lng;
	}
	
	public double getLatitudine(){
		return this.latitudine;
	}
	
	public void setLatitudine(double lat){
		this.latitudine = lat;
	}

	public String getNazione() {
		return nazione;
	}

	public void setNazione(String nazione) {
		this.nazione = nazione;
	}

	public int getGmt() {
		return gmt;
	}

	public void setGmt(int gmt) {
		this.gmt = gmt;
	}

	/**
	 * FINE GETTER, SETTER
	 */


	/**
	 * Se il nome è troppo lungo ritorna solo i primi caratteri
	 */
	public String formattaNome(){
		if(this.nome.length()<30) return this.nome;
		else return this.nome.substring(0, 22)+"...";
	}

	/**
	 * SEGUE CODICE PER L'IMPLEMENTAZIONE DELL'INTERFACCIA PARCELABLE
	 */

	public City(Parcel in) {
		readFromParcel(in);
	}

	public int describeContents() {
		return 0;
	}

	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(id);
		dest.writeString(nome);
		dest.writeString(nazione);
		dest.writeDouble(longitudine);
		dest.writeDouble(latitudine);
		dest.writeInt(gmt);
	}

	private void readFromParcel(Parcel in) {
		id = in.readInt();
		nome = in.readString();
		nazione = in.readString();
		longitudine = in.readDouble();
		latitudine = in.readDouble();
		gmt = in.readInt();
	}

	public static final Parcelable.Creator<City> CREATOR =
			new Parcelable.Creator<City>() {
				public City createFromParcel(Parcel in) {
					return new City(in);
				}

				public City[] newArray(int size) {
					return new City[size];
				}
	};

	/**
	 * FINE CODICE PER L'IMPLEMENTAZIONE DELL'INTERFACCIA PARCELABLE
	 */


}
