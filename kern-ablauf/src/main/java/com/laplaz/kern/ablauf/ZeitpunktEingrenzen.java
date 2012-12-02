package com.laplaz.kern.ablauf;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Service;

import com.laplaz.kern.modell.Zeitraum;

@Service
public class ZeitpunktEingrenzen {

	public Zeitraum pruefen(String eingabe) {
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
		Zeitraum zeitpunkt = new Zeitraum(eingabe, datum);
		return zeitpunkt;
	}

}
