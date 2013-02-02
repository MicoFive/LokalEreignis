package com.laplaz.kern.ablauf;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laplaz.kern.modell.Ereignis;
import com.laplaz.kern.modell.EreignisRepository;

@Service
public class EreignisseSuchen {

	private static final Logger logger = LoggerFactory
			.getLogger(EreignisseSuchen.class);

	EreignisRepository ereignisRepository;

	@Autowired
	public void setEreignisRepository(EreignisRepository ereignisRepository) {
		this.ereignisRepository = ereignisRepository;
	}

	/**
	 * Periodenweise aktuelle Ereignisse aus der Datenbank laden
	 * 
	 * @return Liste von Ereignissen mit Zeitpunkten und Treffpunkten
	 */
	public List<Ereignis> beginnen() {
		List<Ereignis> ereignisse = ereignisRepository.alleEreignisseSuchen();
		if (null != ereignisse) {
			logger.debug(ereignisse.size() + " Ereignisse geladen");
		} else {
			logger.debug("Keine Ereignisse geladen");
		}
		return ereignisse;
	}

}
