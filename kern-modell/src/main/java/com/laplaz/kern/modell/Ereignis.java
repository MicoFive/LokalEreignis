package com.laplaz.kern.modell;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EREIGNIS")
public class Ereignis {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	String bezeichnung;

	@ManyToOne
	Zeitraum zeitraum;

	@ManyToOne
	Treffpunkt treffpunkt;

	public Ereignis(String bezeichnung, Zeitraum zeitraum,
			Treffpunkt treffpunkt) {
		this.bezeichnung = bezeichnung;
		this.zeitraum = zeitraum;
		this.treffpunkt = treffpunkt;
	}
	
	/*
	 * Nur für Hibernate
	 */
	@SuppressWarnings("unused")
	private Ereignis(){}

	public Long getId() {
		return id;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public Zeitraum getZeitraum() {
		return zeitraum;
	}

	public Treffpunkt getTreffpunkt() {
		return treffpunkt;
	}

	@Override
	public String toString() {
		String beschreibung = "Ereignis '" + bezeichnung + "'";
		return beschreibung;
	}

}
