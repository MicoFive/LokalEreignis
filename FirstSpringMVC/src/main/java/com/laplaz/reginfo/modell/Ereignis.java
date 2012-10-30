package com.laplaz.reginfo.modell;


public class Ereignis {
	
	String bezeichnung;
	Zeitpunkt zeitpunkt;
	Treffpunkt treffpunkt;

	public Ereignis(String bezeichnung, Zeitpunkt zeitpunkt, Treffpunkt treffpunkt) {
		this.bezeichnung = bezeichnung;
		this.zeitpunkt = zeitpunkt;
		this.treffpunkt = treffpunkt;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public Zeitpunkt getZeitpunkt() {
		return zeitpunkt;
	}
	

	public Treffpunkt getTreffpunkt() {
		return treffpunkt;
	}

	@Override
	public String toString() {
		String beschreibung = "Ereignis '" + bezeichnung + "'";
		return beschreibung;
	}

}
