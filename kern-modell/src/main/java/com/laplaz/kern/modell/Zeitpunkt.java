package com.laplaz.kern.modell;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ZEITPUNKT")
public class Zeitpunkt {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	String bezeichnung;
	
	Date datum;
	
	@OneToMany(mappedBy="zeitpunkt")
	private Collection<Ereignis> ereignisse = new LinkedHashSet<Ereignis>();
	
	public Zeitpunkt(String bezeichnung, Date datum) {
		this.bezeichnung = bezeichnung;
		this.datum = datum; 
	}
	
	/*
	 * Nur für Hibernate
	 */
	@SuppressWarnings("unused")
	private Zeitpunkt(){}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public Date getDatum() {
		return datum;
	}
	
	/**
	 * @return die Ereignisse
	 */
	public Collection<Ereignis> getEreignisse() {
		return ereignisse;
	}

	/**
	 * @param ereignisse die ereignisse an diesem treffpunkt
	 */
	public void setEreignisse(Collection<Ereignis> ereignisse) {
		this.ereignisse = ereignisse;
	}


}
