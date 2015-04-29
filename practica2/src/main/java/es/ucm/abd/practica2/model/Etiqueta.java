package es.ucm.abd.practica2.model;

import java.util.ArrayList;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
@Entity
public class Etiqueta {
	
	private ArrayList<String> listaEtiquetas;

	public ArrayList<String> getListaEtiquetas() {
		return listaEtiquetas;
	}

	public void setListaEtiquetas(ArrayList<String> listaEtiquetas) {
		this.listaEtiquetas = listaEtiquetas;
	}
	
	
}
