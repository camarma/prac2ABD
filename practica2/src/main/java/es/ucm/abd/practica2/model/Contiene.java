package es.ucm.abd.practica2.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Contiene {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Integer id;
		@Column
		private int pos_x;
		@Column
		private int pos_y;

		private Orientation orientacion;
		@ManyToOne
		private Crucigrama crucigrama;
		@ManyToOne
		private Definicion palabra;
		
		public Contiene(){
			
		}
		
		public Contiene(int pos_x, int pos_y, Orientation orientacion){
			this.pos_x 		 = pos_x;
			this.pos_y 		 = pos_y;
			this.orientacion = orientacion;
		}
		
		public Contiene(Crucigrama cruci, Definicion palabra, int pos_x, int pos_y, Orientation orientacion){
			this.crucigrama  = cruci;
			this.palabra     = palabra;
			this.pos_x 		 = pos_x;
			this.pos_y 		 = pos_y;
			this.orientacion = orientacion;
		}

		public int getPos_x() {
			return pos_x;
		}

		public void setPos_x(int pos_x) {
			this.pos_x = pos_x;
		}

		public int getPos_y() {
			return pos_y;
		}

		public void setPos_y(int pos_y) {
			this.pos_y = pos_y;
		}
		
		public Orientation getOrientacion() {
			return orientacion;
		}

		public Crucigrama getCrucigrama() {
			return crucigrama;
		}

		public void setCrucigrama(Crucigrama crucigrama) {
			this.crucigrama = crucigrama;
		}

		public Definicion getPalabra() {
			return palabra;
		}

		public void setPalabra(Definicion palabra) {
			this.palabra = palabra;
		}

		public void setOrientacion(Orientation orientacion) {
			this.orientacion = orientacion;
		}
}
