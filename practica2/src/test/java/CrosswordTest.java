import es.ucm.abd.practica2.model.Crucigrama;
import es.ucm.abd.practica2.model.Definicion;


public class CrosswordTest extends CrosswordTestBase<Crucigrama, Definicion>{

	@Override
	protected AbstractCrosswordFacade<Crucigrama, Definicion> buildFacade() {
		CrosswordFacade cf = new CrosswordFacade();
		return cf;
	}

}
