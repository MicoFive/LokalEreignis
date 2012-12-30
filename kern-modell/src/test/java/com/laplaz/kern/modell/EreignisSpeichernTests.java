package com.laplaz.kern.modell;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class EreignisSpeichernTests {
 
	@Autowired
	private SessionFactory sessionFactory;

	@Test
	@Transactional
	@Rollback(false)
	public void testSaveOrderWithItems() throws Exception {
		String bezeichnung = "Tanz in den Mai";
		String treffpunktBezeichnung = "treffpunktBezeichnung";
		Date beginn = new Date();
		
		Session session = sessionFactory.getCurrentSession();
		
		Zeitpunkt zeitpunkt = new Zeitpunkt(beginn.toString(), beginn);
		
		session.save(zeitpunkt);
		
		Treffpunkt treffpunkt = new Treffpunkt(treffpunktBezeichnung);
		
		session.save(treffpunkt);
		
		Ereignis ereignis = new Ereignis(bezeichnung, zeitpunkt, treffpunkt);
		zeitpunkt.getEreignisse().add(ereignis);
		treffpunkt.getEreignisse().add(ereignis);

		
		session.save(ereignis);
		session.flush();
		assertNotNull(ereignis.getId());
	}

}
