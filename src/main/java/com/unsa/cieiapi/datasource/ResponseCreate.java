package com.unsa.cieiapi.datasource;

public class ResponseCreate {
	boolean respuesta;
	String mensaje;
	
	public ResponseCreate() {
		
	}
	
	public ResponseCreate(boolean respuesta, String mensaje) {
		super();
		this.respuesta = respuesta;
		this.mensaje = mensaje;
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
	
	
}
