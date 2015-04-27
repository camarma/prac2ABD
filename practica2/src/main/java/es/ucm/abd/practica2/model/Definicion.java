package es.ucm.abd.practica2.model;

import java.util.ArrayList;
import java.util.List;

public class Definicion {
	
	private Integer id;
	private String enunciado;
	private byte[] imagen;
	private String respuesta;
	private String[] etiquetas;
	private List<Definicion> lstPalabras;

	public Definicion(String enunciado, String respuesta, String[] etiquetas){
		this.enunciado = enunciado;
		this.respuesta = respuesta;
		this.etiquetas = etiquetas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public String[] getEtiquetas() {
		return etiquetas;
	}

	public void setEtiquetas(String[] etiquetas) {
		this.etiquetas = etiquetas;
	}
	
	
}

