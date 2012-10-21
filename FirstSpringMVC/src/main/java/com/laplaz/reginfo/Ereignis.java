package com.laplaz.reginfo;

public class Ereignis {
	
	String bezeichnung;

	public Ereignis(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}
	
	@Override
	public String toString() {
		String beschreibung = "Ereignis '" + bezeichnung + "'";
		return beschreibung;
	}

}
