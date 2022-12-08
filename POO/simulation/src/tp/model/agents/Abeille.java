package tp.model.agents;
import java.awt.Point;
import tp.model.agents.Animal;

import tp.model.comportements.Hebergeur;

public abstract class Abeille extends Animal implements Hebergeur{
	private boolean parasite;
	private int qteMiel;
	private int qteMax;
	public int jourSansManger;
	
	public Abeille(Sexe sexe, Point coord) {
		parasite = false;
		qteMiel = 0;
		qteMax = 10;
		this.sexe = sexe;
		this.coord = new Point(0,0);
	}
		
	public boolean peutAccueillir(Agent a){
		if(a.getClass().getSimpleName() == "Varroa") {
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
	public void rencontre(Animal a) {
		if(a.getClass().getSimpleName() == "FrelonAsiatique" || a.getClass().getSimpleName() == "FrelonEuropeen") {
			setEtat(Etat.EnDetresse);
			if (a.getFaim() == Faim.Faim) {
				setEtat(Etat.Mourant);
			}
		}
		if(a.getClass().getSimpleName() == "Varroa" && parasite == false) {
			parasite = true;
			a.setCoord(coord);
			aggraverEtat();
		}
		
		if(a.getClass().getSimpleName() == "Fleur" && getEtat() != Etat.Mourant) {
			jourSansManger = 0;
			//remplacer par améliorer etats
			setEtat(Etat.EnForme);
		}
	}
}