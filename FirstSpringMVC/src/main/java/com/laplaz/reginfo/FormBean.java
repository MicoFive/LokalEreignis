package com.laplaz.reginfo;

import org.hibernate.validator.constraints.NotEmpty;


public class FormBean {
	
	@NotEmpty
	private String bezeichnung;
	
	private String zeitpunkt;
	
	private String treffpunkt;

    public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public String getZeitpunkt() {
		return zeitpunkt;
	}

	public void setZeitpunkt(String zeitpunkt) {
		this.zeitpunkt = zeitpunkt;
	}

	public String getTreffpunkt() {
		return treffpunkt;
	}

	public void setTreffpunkt(String treffpunkt) {
		this.treffpunkt = treffpunkt;
	}

	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("properties name=");
        if (bezeichnung != null) {
        	sb.append("'").append(bezeichnung).append("', ");
        } else {
        	sb.append(bezeichnung).append(", ");
        }
        sb.append("zeitpunkt=");
        if (zeitpunkt != null) {
        	sb.append("'").append(zeitpunkt).append("', ");
        } else {
        	sb.append(zeitpunkt).append(", ");
        }
        sb.append("treffpunkt=");
        if (treffpunkt != null) {
        	sb.append("'").append(treffpunkt).append("', ");
        } else {
        	sb.append(treffpunkt).append(", ");
        }

        return sb.toString();
    }
}
