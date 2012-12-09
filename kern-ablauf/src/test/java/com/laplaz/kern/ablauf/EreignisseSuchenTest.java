package com.laplaz.kern.ablauf;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.laplaz.kern.modell.Ereignis;
import com.laplaz.kern.modell.EreignisRepository;

public class EreignisseSuchenTest {
	
	@Mock
	EreignisRepository ereignisRepository;
	
	@Before 
	public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

	@Test
	public void ereignisseSuchenTest() {
		 
		EreignisseSuchen ereignisseSuchen = new EreignisseSuchen();
		ereignisseSuchen.setEreignisRepository(ereignisRepository);
		List<Ereignis> ereignisse = ereignisseSuchen.beginnen();
		assertNotNull("Zeitpunkt enthält kein Datum", ereignisse);
		
	}

}
