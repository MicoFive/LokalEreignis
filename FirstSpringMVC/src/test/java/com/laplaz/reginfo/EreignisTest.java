package com.laplaz.reginfo;

import static org.junit.Assert.*;

import org.junit.Test;

public class EreignisTest {

	@Test
	public void test() {
		String bezeichnung = "Dagmars Geburtstag";
		Ereignis ereignis = new Ereignis(bezeichnung);
		assertEquals("Falsche Bezeichnung", bezeichnung, ereignis.getBezeichnung());
	}

}
