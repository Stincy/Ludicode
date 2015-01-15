package BDD;


public class Level {
	private String name;
	private int difficulty;
	private String information;
	private String tiles;
	private int nbCommands;
	
	
	
	public int getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String info) {
		this.information = info;
	}
	public String getTiles() {
		return tiles;
	}
	public void setTiles(String tiles) {
		this.tiles = tiles;
	}
	public int getNbCommands() {
		return nbCommands;
	}
	public void setNbCommands(int nbCommands) {
		this.nbCommands = nbCommands;
	}

}
