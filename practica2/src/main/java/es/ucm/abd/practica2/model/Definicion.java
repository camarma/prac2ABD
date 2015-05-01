package es.ucm.abd.practica2.model;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OrderColumn;

@Entity
public class Definicion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id_Definicion")
	private Integer id;	
	@Column(nullable = false, length = 300)
	private String enunciado;	
	@Lob
	private byte[] imagen;
	@Column(nullable = false, length = 100)
	private String respuesta;
	@ElementCollection
	@OrderColumn(name ="Id_etiqueta")
	private String[] etiquetas;
	
	protected Definicion(){
		
	}

	public Definicion(String enunciado, String respuesta, String[] etiquetas, byte[] imagen){
		this.enunciado = enunciado;
		this.respuesta = respuesta;
		this.etiquetas = etiquetas;
		this.imagen    = imagen;
	}
	
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

