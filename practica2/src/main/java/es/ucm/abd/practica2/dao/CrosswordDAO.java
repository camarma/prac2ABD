package es.ucm.abd.practica2.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import es.ucm.abd.practica2.model.Crucigrama;
import es.ucm.abd.practica2.model.Definicion;

public class CrosswordDAO implements AbstractCrosswordDAO<Crucigrama, Definicion>{
	
	private SessionFactory sf;
	
	public CrosswordDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setSessionFactory(SessionFactory f) {
		// TODO Auto-generated method stub
		this.sf = f;
	}

	@Override
	public int insertCrossword(Crucigrama crossword) {
		// TODO Auto-generated method stub
		Session session = this.sf.openSession();
	    session.beginTransaction();
		crossword.getFecha_creacion();
        crossword.getTitulo();
         
        //Save the employee in database
        session.save(crossword);
 
        //Commit the transaction
        session.getTransaction().commit();
        return crossword.getId();
	}

	@Override
	public void insertWord(Definicion word) {
		// TODO Auto-generated method stub
        Session session = this.sf.openSession();
        session.beginTransaction();
		word.getEnunciado();
		word.getImagen();
		word.getRespuesta();
         
        //Save the employee in database
        session.save(word);
 
        //Commit the transaction
        session.getTransaction().commit();
	}

	@Override
	public Crucigrama findCrosswordById(int id) {
		// TODO Auto-generated method stub
		Session session = this.sf.openSession();
		Crucigrama crucigrama = null;
		/*String hql = "select c.titulo, c.fecha_creacion from crucigrama as c where c.id= :id";
		Query query = session.createQuery(hql);
		query.setInteger("id", id);
		List results = query.list();*/
		
		Query query = session.createQuery("select c.titulo, c.fecha_creacion from crucigrama as c"); 
		query.setInteger("id", id);
		List<Crucigrama> resultados =  query.list(); 
		for (Crucigrama p : resultados) {     
			crucigrama = new Crucigrama(p.getFecha_creacion(), p.getTitulo());
		}
		//System.out.println(results.get(0));
		session.close();
		return crucigrama;
	}

	@Override
	public List<Object[]> getCrosswordData(String str) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Definicion> findWordsByTags(String[] tags) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Definicion> getMatchingWords(CharConstraint[] constraints) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
