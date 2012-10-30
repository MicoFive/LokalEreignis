package com.laplaz.reginfo.modell;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.laplaz.reginfo.modell.Treffpunkt;
import com.laplaz.reginfo.modell.Zeitpunkt;

public class EreignisTest {

	@Test
	public void test() {
		String bezeichnung = "Dagmars Geburtstag";
		Zeitpunkt zeitpunkt = new Zeitpunkt();
		Treffpunkt treffpunkt = new Treffpunkt();
		Ereignis ereignis = new Ereignis(bezeichnung, zeitpunkt, treffpunkt);
		assertEquals("Falsche Bezeichnung", bezeichnung, ereignis.getBezeichnung());
		assertEquals("Falscher Zeitpunkt", zeitpunkt, ereignis.getZeitpunkt());
		assertEquals("Falscher Treffpunkt", treffpunkt, ereignis.getTreffpunkt());
	}

}
