package com.laplaz.kern.ablauf;

import static org.junit.Assert.assertNotNull;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.laplaz.kern.modell.EreignisRepository;
import com.laplaz.kern.modell.Treffpunkt;
import com.laplaz.kern.modell.Zeitpunkt;

public class ZeitpunktEingrenzenTest {

	@Mock
	EreignisRepository ereignisRepository;
	
	private Ablauf<Zeitpunkt> zeitpunktEingrenzen;
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
		zeitpunktEingrenzen = new ZeitpunktEingrenzen();
		zeitpunktEingrenzen.setEreignisRepository(ereignisRepository);
	}
	@Test
	public void datumParsenTest() throws ParseException {
		String eingabe = "28.12.2012";
		Zeitpunkt zeitpunkt = zeitpunktEingrenzen.pruefen(eingabe);
		assertNotNull("Zeitpunkt enthält kein Datum", zeitpunkt.getDatum());
		
	}

}
