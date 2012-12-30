package com.laplaz.kern.modell;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

public class EreignisTest {

	@Test
	public void test() {
		String bezeichnung = "Dagmars Geburtstag";
		Date beginn = new Date();
		String treffpunktBezeichnung = "treffpunktBezeichnung";
		Zeitpunkt zeitpunkt = new Zeitpunkt(beginn.toString(), beginn);
		Treffpunkt treffpunkt = new Treffpunkt(treffpunktBezeichnung);
		Ereignis ereignis = new Ereignis(bezeichnung, zeitpunkt, treffpunkt);
		assertEquals("Falsche Bezeichnung", bezeichnung, ereignis.getBezeichnung());
		assertEquals("Falscher Zeitpunkt", zeitpunkt, ereignis.getZeitpunkt());
		assertEquals("Falscher Treffpunkt", treffpunkt, ereignis.getTreffpunkt());
	}

}
