/*
 * Basics
 */
package com.example.demo.Models;
import com.example.demo.Models.*;
public class StatsType {
	

	private TypePlat typeplat;

	private long total;

	public StatsType(TypePlat typeplat, long total) {
		
		this.typeplat = typeplat;
		this.total = total;
	}

	public TypePlat getTypeplat() {
		return typeplat;
	}

	public void setTypeplat(TypePlat typeplat) {
		this.typeplat = typeplat;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}
	
	

}
