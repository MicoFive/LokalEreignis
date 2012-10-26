package com.laplaz.reginfo;

import org.hibernate.validator.constraints.NotEmpty;


public class FormBean {
	
	@NotEmpty
	private String name;

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("properties name=");
        if (name != null) {
        	sb.append("'").append(name).append("', ");
        } else {
        	sb.append(name).append(", ");
        }
        return sb.toString();
    }
}
