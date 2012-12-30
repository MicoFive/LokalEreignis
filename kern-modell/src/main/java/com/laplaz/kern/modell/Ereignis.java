package com.laplaz.kern.modell;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	@JoinColumn(name="ZEITPUNKT_ID", nullable=false)
	Zeitpunkt zeitpunkt;

	@ManyToOne
	@JoinColumn(name="TREFFPUNKT_ID", nullable=false)
	Treffpunkt treffpunkt;

	public Ereignis(String bezeichnung, Zeitpunkt zeitpunkt,
			Treffpunkt treffpunkt) {
		this.bezeichnung = bezeichnung;
		this.zeitpunkt = zeitpunkt;
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

	public Zeitpunkt getZeitpunkt() {
		return zeitpunkt;
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
