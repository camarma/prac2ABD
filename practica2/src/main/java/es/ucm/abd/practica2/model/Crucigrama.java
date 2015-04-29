package es.ucm.abd.practica2.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Crucigrama {

	@Temporal(TemporalType.DATE)
	private Date fecha_creacion;
	@Column(nullable = false, length = 30, unique = true)
	private String titulo;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@OneToMany(mappedBy = "crucigrama", cascade = CascadeType.ALL)
	private List<Contiene> lstCont;
	
	public Crucigrama(){
		
	}
	public Crucigrama(Date fecha, String titulo){
		this.titulo = titulo;
		this.fecha_creacion = fecha;
		this.lstCont = new ArrayList<Contiene>();
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

	public List<Contiene> getLstCont() {
		return lstCont;
	}

	public void setLstCont(List<Contiene> lstContienes) {
		this.lstCont = lstContienes;
		
	}
	/*public List<Object[]> listarCrucigramas(Crucigrama cruci){
		List<Object[]> listaCrucigrama = new  ArrayList<Object[]>();
		this.lstCrucigramas = cruci.getLstCrucigramas();
		for(int i=0; this.lstCrucigramas.size()>i; i++){
			listaCrucigrama.add(i, (Object[]) this.lstCrucigramas.get(i));
		}
		return listaCrucigrama;
	}*/
}
