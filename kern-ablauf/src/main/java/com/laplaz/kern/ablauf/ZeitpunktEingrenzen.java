package com.laplaz.kern.ablauf;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.laplaz.kern.modell.Zeitpunkt;

public class ZeitpunktEingrenzen {

	public Zeitpunkt pruefen(String eingabe) throws ParseException {
		// "Fr. 28.12.2012 20:30 Uhr"
		String pattern = "EE. dd.MM.yyyy HH:mm 'Uhr'";
		Locale locale = Locale.GERMANY;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, locale);
		Date datum = simpleDateFormat.parse(eingabe);
		Zeitpunkt zeitpunkt = new Zeitpunkt(datum);
		return zeitpunkt;
	}

}
