package com.laplaz.kern.ablauf;

import static org.junit.Assert.assertNotNull;

import java.text.ParseException;

import org.junit.Test;

import com.laplaz.kern.modell.Zeitpunkt;

public class ZeitpunktEingrenzenTest {

	
	@Test
	public void datumParsenTest() throws ParseException {
		String eingabe = "Fr. 28.12.2012 20:30 Uhr";
		ZeitpunktEingrenzen zeitpunktEingrenzen = new ZeitpunktEingrenzen();
		Zeitpunkt zeitpunkt = zeitpunktEingrenzen.pruefen(eingabe);
		assertNotNull("Zeitpunkt enthält kein Datum", zeitpunkt.getDatum());
		
	}

}
