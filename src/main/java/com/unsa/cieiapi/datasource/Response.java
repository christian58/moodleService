package com.unsa.cieiapi.datasource;

public class Response {
	boolean respuesta;
	String mensaje;
	Integer valorSuma;
	
	public Response () {
		
	}
	public Response(boolean respuesta, String mensaje, Integer valorSuma) {
		super();
		this.respuesta = respuesta;
		this.mensaje = mensaje;
		this.valorSuma = valorSuma;
	}
	public boolean isRespuesta() {
		return respuesta;
	}
	public void setRespuesta(boolean respuesta) {
		this.respuesta = respuesta;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public Integer getValorSuma() {
		return valorSuma;
	}
	public void setValorSuma(Integer valorSuma) {
		this.valorSuma = valorSuma;
	}
	

}
