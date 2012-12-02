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
		Zeitraum zeitpunkt = new Zeitraum(beginn.toString(), beginn);
		Treffpunkt treffpunkt = new Treffpunkt(treffpunktBezeichnung);
		Session session = sessionFactory.getCurrentSession();
		Ereignis ereignis = new Ereignis(bezeichnung, zeitpunkt, treffpunkt);
		zeitpunkt.getEreignisse().add(ereignis);
		treffpunkt.getEreignisse().add(ereignis);
		session.save(zeitpunkt);
		session.save(treffpunkt);
		session.save(ereignis);
		session.flush();
		assertNotNull(ereignis.getId());
	}

}
