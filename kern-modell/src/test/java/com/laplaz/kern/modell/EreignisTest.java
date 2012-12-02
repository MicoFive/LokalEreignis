package com.laplaz.kern.modell;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

public class EreignisTest {

	@Test
	public void test() {
		String bezeichnung = "Dagmars Geburtstag";
		String treffpunktBezeichnung = "treffpunktBezeichnung";
		Zeitraum zeitraum = new Zeitraum(new Date());
		Treffpunkt treffpunkt = new Treffpunkt(treffpunktBezeichnung);
		Ereignis ereignis = new Ereignis(bezeichnung, zeitraum, treffpunkt);
		assertEquals("Falsche Bezeichnung", bezeichnung, ereignis.getBezeichnung());
		assertEquals("Falscher Zeitraum", zeitraum, ereignis.getZeitraum());
		assertEquals("Falscher Treffpunkt", treffpunkt, ereignis.getTreffpunkt());
	}

}
