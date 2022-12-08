package tp.model.agents;
import tp.model.comportements.Hebergeur;
import java.lang.Math;


public class Arbre extends Vegetal {
	
	private double taille;
	private int nbHeberges;
	
	public Arbre() {
		taille = 1;
		nbHeberges = 0;
	}
	
	public double getTaille() {
		return taille;
	}

	public void setTaille(double taille) {
		this.taille = taille;
	}

	public boolean peutAccueillir(Agent a){
		if(a.getClass().getSimpleName() == "AbeilleSolitaire" || a.getClass().getSimpleName() == "Frelons") {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean accueillir(Agent a) {
		if(peutAccueillir(a) == true) {
			return true;
		}
		else {
			return false;
		}
	}
	
	

	@Override
	protected void miseAJour() {
		// TODO Auto-generated method stub
		
	}
}