package tp.model.agents;
import tp.model.comportements.Deplacable;
import tp.model.agents.Faim;
import tp.model.comportements.Hebergeur;
import java.awt.Point;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Cette classe modélise un Animal dans la simulation
 * @author bruno
 *
 */
public abstract class Animal extends Agent implements Deplacable{
	/** état de santé de l'animal */
	Etat etat;
	/** Sexe de l'animal **/
	Sexe sexe;
	//** Degr� de faim de l'animal **/
	Faim faim;
	

	private Hebergeur hebergeur;
	public int jourSansManger;

	
	/* 
	 * constructeurs 
	 */
	/**
	 * 
	 * @param sexe
	 * @param coord
	 */
	

	public Animal(Sexe sexe, Point coord) {
		age = 0;
		etat =Etat.Normal;
		faim = Faim.Faim;
		id = Animal.getUniqueId();
		this.sexe=sexe;
		//this.coord=coord;
		this.coord=new Point(coord);
	}
	
	/**
	 * 
	 * @param sexe
	 */
	public Animal(Sexe sexe) {
		//TODO
		/* crée un animal avec le sexe passé en paramètre, à la position (0;0), d'âge 0 et lui attribue un id unique
		 * une bonne manière de faire 
		 * en utilisant ce qui existe déjà, une moins bonne
		 */
		this(sexe, new Point(0,0)); //c'est emma qui l'a trouvé
	
	}
	
	public Animal() {
		//TODO
		/* crée un animal de sexe femelle, à la position (0;0), d'âge 0 et lui attribue un id unique
		 * une bonne manière de faire 
		 * en utilisant ce qui existe déjà, une moins bonne
		 */
		this(Sexe.Femelle, new Point(0,0)); //c'est emma qui l'a trouvé
		
		
	}
	
	/*
	 *  Accesseurs et mutateurs
	 */
	//TODO
	
	
	/*
	 * Redéfinitions de méthodes d'object
	 */
	//TODO
	

	/* 
	 * comportements d'instance
	 */
	
	

	public void seDeplacer() {
		//TODO utiliser Math.random() pour choisir une direction de déplacement
		//variables de déplacement
		int dx; 
		int dy;
		dx = (int) (-1.5 + 2.5*Math.random());
		dy = (int) (-1.5 + 2.5*Math.random());
		//sécurité pour etre sur qu'il se déplace
		if (dx == 0 & dy == 0) {
			while (dx == 0 & dy == 0) {
				dx = (int) (-1.5 + 3*Math.random());
				dy = (int) (-1.5 + 3*Math.random());
			}
		}
		//changement des coordonnées
		Point pt = getCoord();
		pt.x = pt.x + dx;
		pt.y = pt.y + dy;
		setCoord(pt);
	}

	/**
	 * condition d'installation d'un animal dans un h�bergeur
	 * @param h
	 * @return
	 */
	protected final boolean sInstaller(Hebergeur h) {
		boolean ret=false;
		if(h!= null && h.accueillir(this)) {
			hebergeur = h;
			ret=true;
		}
		return ret;
	}
	
	public static void main(String args[]) {
		//tests unitaires de la classe Animal
		//TODO décommentez les lignes pour approfondir le test unitaire
		//complétez la méthode pour tester les nouvelles fonctionnalités que vous allez implémenter
		//Animal a = new AbeilleDomestique();
		
		/*
		 * les lignes suivantes doivent afficher à terme: NomDeLaClasse n° id_animal(sexe, (position x; position y)).
		 * ex: 28 (FEMELLE, (25;30))
		 */
		/*
		System.out.println("*** Animaux créés: **********");
		System.out.println(a);
		System.out.println(a.toString());
		
		System.out.println("*** Getters et setters **********");
		
		System.out.println(a.getSexe());
		//Sexe ss = d.getSexe();
		//ss=Sexe.Male;
		System.out.println(a.getSexe());
		
		//les lignes suivantes devraient afficher la même chose....

		System.out.println(a.getCoord());
		Point pt = a.getCoord();
		pt.x=50;
		System.out.println(a.getCoord());*/
		
		
		//TODO ajoutez vos propres tests de getters et setters
		
		//TODO test vieillir
		
		//TODO test seDeplacer
		
		//TODO test id
		/*
		//affichage des getters
		System.out.println(a.getId());
		System.out.println(a.getId());
		System.out.println(a.getEtat());
		System.out.println(a.getAge());
		a.setAge(12);
		System.out.println(a.getAge());
		a.vieillir();
		System.out.println(a.getAge());
		System.out.println(a.getCoord());
		a.seDeplacer();
		System.out.println(a.getCoord());*/


	
		
		/*
		 * Test comparaison
		 */
		
		//System.out.println(d==e);
		//System.out.println(d.equals(e));
		System.out.println("Bonjour"=="Bonjour");
		System.out.println("Bonjour".equals("Bonjour"));
		
	}
	
	public final void aggraverEtat() {
		/* d�tail sur plusieurs lignes de:
		 * 	LinkedList<Etat> liste = new LinkedList<Etat>(Arrays.asList(Etat.values()));

		Etat[] tableauEtat = Etat.values();
		List<Etat> listeEtat = Arrays.asList(tableauEtat);
		LinkedList<Etat> liste = new LinkedList<Etat>(listeEtat);
		*/
		LinkedList<Etat> liste = new LinkedList<Etat>(Arrays.asList(Etat.values()));
		// ArrayList<Etat> liste = new ArrayList<Etat>(Arrays.asList(Etat.values()));
		/* d�tail de
		 * Iterator<Etat> it = liste.listIterator(liste.indexOf(etat));
		 
		int indexEtatActuel = liste.indexOf(this.etat); (inutile avec l'algo suivant)
		Iterator<Etat> it = liste.listIterator();
		boolean trouve = false;
		while(it.hasNext() && !trouve) {
			if(it.next().equals(this.etat)) {trouve=true;}
		}
		*/
		Iterator<Etat> it = liste.listIterator(liste.indexOf(etat));
		if(it.hasNext()) {
			etat =  it.next(); //naturellement le pointeur est sur celui  d'avant le actuel
			etat = it.next();
		}
	}
	
	protected final void ameliorerEtat() {
		/* d�tail sur plusieurs lignes de:
		 * 	LinkedList<Etat> liste = new LinkedList<Etat>(Arrays.asList(Etat.values()));

		Etat[] tableauEtat = Etat.values();
		List<Etat> listeEtat = Arrays.asList(tableauEtat);
		LinkedList<Etat> liste = new LinkedList<Etat>(listeEtat);
		*/
		LinkedList<Etat> liste = new LinkedList<Etat>(Arrays.asList(Etat.values()));
		// ArrayList<Etat> liste = new ArrayList<Etat>(Arrays.asList(Etat.values()));
		/* d�tail de
		 * Iterator<Etat> it = liste.listIterator(liste.indexOf(etat));
		 
		int indexEtatActuel = liste.indexOf(this.etat); (inutile avec l'algo suivant)
		Iterator<Etat> it = liste.listIterator();
		boolean trouve = false;
		while(it.hasNext() && !trouve) {
			if(it.next().equals(this.etat)) {trouve=true;}
		}
		*/
		//on change iterator en listiterator parce que iterator ne va que dans un sens
		ListIterator<Etat> it = liste.listIterator(liste.indexOf(etat));
		if( it.hasPrevious()) {
			etat =  it.previous();
		}	
	}
	
	protected void seNourrir() {
		int jourMax = 5;
		jourSansManger ++ ;
		if (jourSansManger >= jourMax) {
			setEtat(Etat.Mourant);
		}
	}
	
	public Point getCoord() {
		return (Point)coord.clone();
	}
	
	public Etat getEtat() {
		return etat;
	}

	public Sexe getSexe() {
		return sexe;
	}
	public String toString() {
		return super.toString() + sexe;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}
	
	public Faim getFaim() {
		return faim;
	}

	public void setFaim(Faim faim) {
		this.faim = faim;
	}
	
}
