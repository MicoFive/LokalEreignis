package com.laplaz.kern.ablauf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laplaz.kern.modell.EreignisRepository;
import com.laplaz.kern.modell.Treffpunkt;

@Service
public class TreffpunktZuordnen implements Ablauf<Treffpunkt> {

	EreignisRepository ereignisRepository;

	@Autowired
	public void setEreignisRepository(EreignisRepository ereignisRepository) {
		this.ereignisRepository = ereignisRepository;
	}

	public Treffpunkt lesen(String eingabe) {
		Treffpunkt treffpunkt = ereignisRepository.treffpunktSuchen(eingabe);
		if (null == treffpunkt) {
			treffpunkt = new Treffpunkt(eingabe);
		}
		return treffpunkt;
	}

}
