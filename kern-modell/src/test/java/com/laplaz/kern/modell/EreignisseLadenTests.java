package com.laplaz.kern.modell;

import static org.junit.Assert.assertNotNull;

import java.util.List;

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
public class EreignisseLadenTests {
 
	@Autowired
	private SessionFactory sessionFactory;

	@Test
	@Transactional
	@Rollback(false)
	public void testEreignisseMitDetailsLaden() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<Ereignis> ereignisse = session.createCriteria(Ereignis.class).list();
		assertNotNull(ereignisse);
	}

}
