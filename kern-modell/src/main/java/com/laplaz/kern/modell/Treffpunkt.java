package com.laplaz.kern.modell;

import java.util.Collection;
import java.util.LinkedHashSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Lokalität, an der ein Ereignis zu einem bestimmten Zeitpunkt stattfindet.
 * 
 * @author dev
 * 
 */
@Entity
@Table(name = "TREFFPUNKT")
public class Treffpunkt {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	String bezeichnung;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="TREFFPUNKT_ID")
	private Collection<Ereignis> ereignisse = new LinkedHashSet<Ereignis>();
	
	public Treffpunkt(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	public String getBezeichnung() {
		return bezeichnung;
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
