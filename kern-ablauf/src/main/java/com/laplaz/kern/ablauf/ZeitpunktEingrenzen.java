package com.laplaz.kern.ablauf;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Service;

import com.laplaz.kern.modell.Zeitraum;

@Service
public class ZeitpunktEingrenzen {

	public Zeitraum pruefen(String eingabe) throws ParseException {
		// "Fr. 28.12.2012 20:30 Uhr"
		String pattern = "EE. dd.MM.yyyy HH:mm 'Uhr'";
		Locale locale = Locale.GERMANY;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, locale);
		Date datum = simpleDateFormat.parse(eingabe);
		Zeitraum zeitpunkt = new Zeitraum(datum);
		return zeitpunkt;
	}

}
