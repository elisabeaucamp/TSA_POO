package tp.model.agents;
import tp.model.comportements.Deplacable;
import java.awt.Point;
import tp.model.agents.Fleur;

public abstract class Agent {

	private static int currentId = 0;
	/** identifiant unique de l'animal*/
	protected int id;
	/** age en unité de temps*/
	protected int age;
	/** position sur la carte*/
	protected Point coord;

	/**
	 * Renvoie un identifiant unique non encore utilisé
	 * @return un identifiant entier unique d'animal
	 */
	protected static int getUniqueId() {
		//TODO 
		int ID;
		ID = currentId;
		currentId = currentId + 1;
		return ID;
	}

	public void vieillir() {
		//TODO fait vieillir l'animal d'une unité de temps
		//une bonne manière de faire, une moins bonne...
		setAge(getAge()+1);
	}

	public void rencontrer(Animal a) {
		//TODO
	}

	public Agent() {
		super();
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		if (age != other.age)
			return false;
		return true;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age ;
	}

	public void setCoord(Point coord) {
		this.coord = coord;
	}

	public int getId() {
		return id;
	}

	public String toString() {
		return getClass().getSimpleName() + " " + id  + " (" + coord.x + ";" + coord.y + "), ";
	}
	
	public void cycle() {
		vieillir();
		if (this instanceof Deplacable) {
			((Deplacable)this).seDeplacer();
		}
		seNourrir();
		miseAJour();
	}
	protected abstract void seNourrir();
	protected abstract void miseAJour();

}