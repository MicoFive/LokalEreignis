package com.laplaz.kern.modell;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class EreignisRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public void speichern(Ereignis ereignis) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Zeitpunkt zeitpunkt = ereignis.getZeitpunkt();
		session.save(zeitpunkt);
		Treffpunkt treffpunkt = ereignis.getTreffpunkt();
		session.save(treffpunkt);
		session.save(ereignis);
		session.flush();
	}

	/**
	 * Unsortiert alle Ereignisse mit Zeitpunkt und Treffpunkt laden
	 * 
	 * @return Liste aller Ereignisse
	 */
	@Transactional
	public List<Ereignis> suchen() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Ereignis> ereignisse = session.createCriteria(Ereignis.class)
				.list();
		return ereignisse;
	}

}
