package com.laplaz.kern.ablauf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laplaz.kern.modell.Ereignis;
import com.laplaz.kern.modell.EreignisRepository;

@Service
public class EreignisseSuchen {
	
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
		List<Ereignis> ereignisse = ereignisRepository.suchen();
		return ereignisse;
	}

}
