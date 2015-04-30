package es.ucm.abd.practica2.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import es.ucm.abd.practica2.model.Contiene;
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
		Crucigrama crucigrama = (Crucigrama) session.get(Crucigrama.class, id);
		session.close();
		return crucigrama;
	}

	@Override
	public List<Object[]> getCrosswordData(String str) {
		Session session = this.sf.openSession();
	
		Query query = session.createQuery("SELECT cr.id, cr.titulo, cr.fecha_creacion, count(lc.id) "+
										  "FROM Crucigrama as cr LEFT JOIN cr.lstCont lc "+ 
										  "WHERE cr.titulo LIKE :str "+
										  "group by cr.id"); 
		query.setString("str", "%"+str+"%");
		List<Object[]> resultados = query.list(); 
		session.close();
		return resultados;
	}

	@Override
	public List<Definicion> findWordsByTags(String[] tags) {
		// TODO Auto-generated method stub
		Session session = this.sf.openSession();
		Query query = null;
		List<Definicion> resultados = null;
		String hql = "FROM Definicion as d";
		if(tags.length<=0){
			query = session.createQuery(hql); 
			resultados = query.list(); 
		}else{
			for(int i=0; i<tags.length;i++){
				query = session.createQuery(hql+" where :tags MEMBER OF d.etiquetas"); 
				query.setString("tags", tags[i]);
				resultados = query.list();
			}
		}
		session.close();
		return resultados;
	}

	@Override
	public List<Definicion> getMatchingWords(CharConstraint[] constraints) {
		// TODO Auto-generated method stub
		Session session = this.sf.openSession();
		Query query = null;
		int j=0;
		String respuesta="";
		String character;
		String position;
		char letraRespuesta;
		List<Definicion> resultados = null;
		boolean ok = false;
		List<Definicion> lstDefiniciones = new ArrayList<Definicion>();
		String hql = "FROM Definicion as d";
		query = session.createQuery(hql); 
		resultados = query.list(); 
		session.close();
		if(constraints.length<=0){
			return resultados;
		}else{
			for(int i=0; resultados.size()>i; i++){
				for(j=0;constraints.length>j;j++){
					respuesta = resultados.get(i).getRespuesta();
					position = constraints[j].toString().split(" at ")[1];
					character = constraints[j].toString().split(" at ")[0];
					position = position.substring(0, position.length()-1);
					character = character.substring(1);
					if(resultados.get(i).getRespuesta().length()>=Integer.parseInt(position)){
						letraRespuesta = resultados.get(i).getRespuesta().charAt(Integer.parseInt(position)-1);
						if(character.charAt(0) == letraRespuesta){
							//lstDefiniciones.add(resultados.get(i));
							//j=constraints.length;
							ok=true;
						}else{
							ok=false;
						}
					}if(Integer.parseInt(position)==resultados.get(i).getRespuesta().length()+1){
						ok=false;
					}
				}
				if(ok){
					lstDefiniciones.add(resultados.get(i));
				}
				j=0;
			}
			return lstDefiniciones;
		}
	}
}
