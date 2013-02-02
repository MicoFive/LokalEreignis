package com.laplaz.kern.ablauf;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.laplaz.kern.modell.EreignisRepository;
import com.laplaz.kern.modell.Treffpunkt;

public class TreffpunktZuordnenTest {
	
	@Mock
	EreignisRepository ereignisRepository;
	
	private Ablauf<Treffpunkt> ortZuordnen;
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
		ortZuordnen = new TreffpunktZuordnen();
		ortZuordnen.setEreignisRepository(ereignisRepository);
	}

	/**
	 * Basierend auf dem Eingabetext soll entweder ein vorhandener Treffpunkt
	 * zugeordnet oder ein neuer Treffpunkt angelegt werden.
	 */
	@Test
	public void test() {
		String eingabe = "Kiki Sol";
		when(ereignisRepository.treffpunktSuchen(eingabe)).thenReturn(null);
		
		Treffpunkt treffpunkt = ortZuordnen.lesen(eingabe);
		assertNotNull("Treffpunkt ist null", treffpunkt);
	}

}
