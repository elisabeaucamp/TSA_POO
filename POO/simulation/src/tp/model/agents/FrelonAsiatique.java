package tp.model.agents;
import tp.model.comportements.Hebergeur;
import java.awt.Point;

public class FrelonAsiatique extends Frelons {

	public FrelonAsiatique(Sexe sexe, Point coord) {
		super(sexe, coord);
		proies.add(FrelonEuropeen.class);
	}
	@Override
	protected void seNourrir() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void miseAJour() {
		// TODO Auto-generated method stub
		
	}
	/*
	public void rencontreFrelon(Animal a) {
		if(a.getClass().getSimpleName() == "FrelonEuropeen") {
			setEtat(Etat.EnDetresse);
		}
	}*/

}