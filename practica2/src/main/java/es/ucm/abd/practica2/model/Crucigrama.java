package es.ucm.abd.practica2.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Crucigrama {

	@Column
	private Date fecha_creacion;
	@Column(nullable = false, length = 30, unique = true)
	private String titulo;
	@Id
	private Integer id;
	
	private List<Crucigrama> lstCrucigramas;
	
	public Crucigrama(){
		
	}
	public Crucigrama(Date fecha, String titulo){
		this.titulo = titulo;
		this.fecha_creacion = fecha;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Crucigrama> getLstCrucigramas() {
		return lstCrucigramas;
	}

	public void setLstCrucigramas(List<Crucigrama> lstCrucigramas) {
		this.lstCrucigramas = lstCrucigramas;
	}
	
	
}
