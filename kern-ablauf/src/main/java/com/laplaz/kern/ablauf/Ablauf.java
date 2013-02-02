package com.laplaz.kern.ablauf;

import com.laplaz.kern.modell.EreignisRepository;


public interface  Ablauf<T> {

	T lesen(String eingabe);

	void setEreignisRepository(EreignisRepository ereignisRepository);

	T pruefen(String eingabe);

}
