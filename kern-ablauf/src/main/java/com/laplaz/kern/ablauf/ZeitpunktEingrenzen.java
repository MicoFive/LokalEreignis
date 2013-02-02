package com.laplaz.kern.ablauf;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laplaz.kern.modell.EreignisRepository;
import com.laplaz.kern.modell.Treffpunkt;
import com.laplaz.kern.modell.Zeitpunkt;

@Service
public class ZeitpunktEingrenzen implements Ablauf<Zeitpunkt>{

	EreignisRepository ereignisRepository;

	@Autowired
	public void setEreignisRepository(EreignisRepository ereignisRepository) {
		this.ereignisRepository = ereignisRepository;
	}

	public Zeitpunkt pruefen(String eingabe) {
		// "Fr. 28.12.2012 20:30 Uhr"
		String pattern = "dd.MM.yyyy";
		Locale locale = Locale.GERMANY;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, locale);
		Date datum = null;
		try {
			datum = simpleDateFormat.parse(eingabe);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Zeitpunkt zeitpunkt = lesen(eingabe);
		if (null == zeitpunkt) {
			zeitpunkt = new Zeitpunkt(eingabe, datum);
		}
		
		return zeitpunkt;
	}

	public Zeitpunkt lesen(String eingabe) {
		Zeitpunkt zeitpunkt = ereignisRepository.zeitpunktSuchen(eingabe);
		return zeitpunkt;
	}

}
