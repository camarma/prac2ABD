import java.util.Date;
import java.util.List;

import es.ucm.abd.practica2.dao.AbstractCrosswordDAO;
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
		Contiene cont = new Contiene(crossword, word, row, column, orientation);
		cont.addPalabraACruci();
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
		return null;
	}

	@Override
	public AbstractCrosswordDAO<Crucigrama, Definicion> createDAO() {
		// TODO Auto-generated method stub
		return null;
	}

}
