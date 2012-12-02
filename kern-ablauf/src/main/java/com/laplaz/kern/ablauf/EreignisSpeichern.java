package com.laplaz.kern.ablauf;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laplaz.kern.modell.Ereignis;
import com.laplaz.kern.modell.EreignisRepository;
import com.laplaz.kern.modell.Zeitraum;

@Service
public class EreignisSpeichern {
	
	@Autowired
	EreignisRepository ereignisRepository;
	
	public void speichern (Ereignis ereignis) throws Exception {
		ereignisRepository.speichern(ereignis);
	}

}
