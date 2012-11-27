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
@Table(name = "ZEITRAUM")
public class Zeitraum {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="ZEITRAUM_ID")
	private Collection<Ereignis> ereignisse = new LinkedHashSet<Ereignis>();
	
	Date datum;
	
	public Zeitraum(Date datum) {
		this.datum = datum; 
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
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
	public void setItems(Collection<Ereignis> ereignisse) {
		this.ereignisse = ereignisse;
	}

	public Date getDatum() {
		return datum;
	}

}
