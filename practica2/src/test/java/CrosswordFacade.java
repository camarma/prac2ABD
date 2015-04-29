import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.ucm.abd.practica2.dao.AbstractCrosswordDAO;
import es.ucm.abd.practica2.dao.CrosswordDAO;
import es.ucm.abd.practica2.model.Contiene;
import es.ucm.abd.practica2.model.Crucigrama;
import es.ucm.abd.practica2.model.Definicion;
import es.ucm.abd.practica2.model.Orientation;


public class CrosswordFacade implements AbstractCrosswordFacade<Crucigrama, Definicion>{

	@Override
	public Crucigrama newCrossword(String title, Date date) {
		// TODO Auto-generated method stub
		Crucigrama crucigrama = new Crucigrama(date, title);
		return crucigrama;
	}

	@Override
	public Definicion newDefinition(String sequence, String hint, String[] tags) {
		// TODO Auto-generated method stub
		Definicion definicion = new Definicion(hint, sequence, tags);
		return definicion;
	}

	@Override
	public void addWordToCrossword(Crucigrama crossword, Definicion word, int row, int column, Orientation orientation) {
		// TODO Auto-generated method stub
				
		List<Contiene> lstCont = new ArrayList<Contiene>();
		lstCont = crossword.getLstCont();
		Contiene cont = new Contiene(crossword, word, row, column, orientation);
		lstCont.add(cont);
		crossword.setLstCont(lstCont);
		//cont.addPalabraACruci();
	}

	@Override
	public String getAnswerOfWord(Definicion word) {
		// TODO Auto-generated method stub
		return word.getRespuesta();
	}

	@Override
	public String[] getTagsOfWord(Definicion word) {
		// TODO Auto-generated method stub
		return word.getEtiquetas();
	}

	@Override
	public String getHintOfWord(Definicion word) {
		// TODO Auto-generated method stub
		return word.getEnunciado();
	}

	@Override
	public String getTitleOfCrossword(Crucigrama crossword) {
		// TODO Auto-generated method stub
		return crossword.getTitulo();
	}

	@Override
	public Date getDateOfCrossword(Crucigrama crossword) {
		// TODO Auto-generated method stub
		return crossword.getFecha_creacion();
	}

	@Override
	public List<Object[]> getWordsOfCrossword(Crucigrama crossword) {
		// TODO Auto-generated method stub
		List<Object[]> lstTotal = new ArrayList<Object[]>();
		List<Contiene> lstCont = new ArrayList<Contiene>();
		lstCont = crossword.getLstCont();
		for (int i = 0; lstCont.size()>i; i++){
			lstTotal.add(new Object[]{
				lstCont.get(i).getPalabra().getRespuesta(),
				lstCont.get(i).getPos_x(),
				lstCont.get(i).getPos_y(),
				lstCont.get(i).getOrientacion()});
		}
		return lstTotal;
	}

	@Override
	public AbstractCrosswordDAO<Crucigrama, Definicion> createDAO() {
		// TODO Auto-generated method stub
		CrosswordDAO cd = new CrosswordDAO();
		return cd;
	}

}
