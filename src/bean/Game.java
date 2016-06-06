package bean;

/**
 * Contient toutes les données d'une instance de jeu.
 * @author BloodyRaven
 *
 */
public class Game {

	private int population, happiness, gold, criminality, defense;
	
	public Game() {
		this.population=50;
		this.happiness=50;
		this.gold=100;
		this.criminality=0;
		this.defense=0;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public int getHappiness() {
		return happiness;
	}

	public void setHappiness(int happiness) {
		this.happiness = happiness;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getCriminality() {
		return criminality;
	}

	public void setCriminality(int criminality) {
		this.criminality = criminality;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}
	
	
}
