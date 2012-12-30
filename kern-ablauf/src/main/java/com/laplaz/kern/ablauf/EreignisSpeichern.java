package com.laplaz.kern.ablauf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laplaz.kern.modell.Ereignis;
import com.laplaz.kern.modell.EreignisRepository;

@Service
public class EreignisSpeichern {
	
	@Autowired
	EreignisRepository ereignisRepository;
	
	public void speichern (Ereignis ereignis) throws Exception {
		ereignisRepository.speichern(ereignis);
	}

}
