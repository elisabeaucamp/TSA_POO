package launchers;
import tp.model.agents.AbeilleDomestique;
import java.awt.Point;

import tp.model.agents.Agent;
import tp.model.agents.Animal;
import tp.model.agents.Etat;
import tp.model.agents.FrelonAsiatique;
import tp.model.agents.Frelons;
import tp.model.agents.Sexe;


public class LauncherTP2 {
	
	public static void main(String [] args){
		Animal a = new AbeilleDomestique(Sexe.Femelle,new Point(25,30));
		a.getEtat();
		System.out.println(a.getEtat());
		a.aggraverEtat();
		System.out.println(a.getEtat());
		//TODO
		//tester la hiérarchie d'agent
		Frelons f = new FrelonAsiatique(Sexe.Femelle, new Point(25,30));
		System.out.println(a.getEtat());
	}

}