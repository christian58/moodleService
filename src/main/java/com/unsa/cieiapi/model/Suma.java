package com.unsa.cieiapi.model;

public class Suma {
	Integer operador1;
	Integer operador2;
	
	public Suma() {
		
	}
	
	public Suma(Integer operador1, Integer operador2) {
		super();
		this.operador1 = operador1;
		this.operador2 = operador2;
	}
	public Integer getOperador1() {
		return operador1;
	}
	public void setOperador1(Integer operador1) {
		this.operador1 = operador1;
	}
	public Integer getOperador2() {
		return operador2;
	}
	public void setOperador2(Integer operador2) {
		this.operador2 = operador2;
	}
	
	
}
