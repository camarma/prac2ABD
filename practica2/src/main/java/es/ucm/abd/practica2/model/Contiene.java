package es.ucm.abd.practica2.model;

import java.util.List;


public class Contiene {

		private int pos_x;
		private int pos_y;
		private Orientation orientacion;
		private Crucigrama crucigrama;
		private Definicion palabra;
		private List<Object[]> lstCrucigrama;
		
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
		
		public void addPalabraACruci(){

		}
		public List<Crucigrama[]> listaCrucigramas(Crucigrama cruci){
			
			return null;
		}
}
