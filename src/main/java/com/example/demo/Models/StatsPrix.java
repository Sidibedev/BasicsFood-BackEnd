/*
 * Basics
 */
package com.example.demo.Models;

public class StatsPrix {

	private String prix;
	private long total;
	public String getPrix() {
		return this.prix;
	}
	public void setPrix(String prix) {
		this.prix = prix;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public StatsPrix(String prix, long total) {
		super();
		this.prix = prix;
		this.total = total;
	}
	
	
}
