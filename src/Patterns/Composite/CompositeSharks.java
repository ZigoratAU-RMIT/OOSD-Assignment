package Patterns.Composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeSharks {
	private String name;
	private int life;
	private int lifeCycle;
	private List<CompositeSharks> sharksList;

	// CompositeSharks constructor
	public CompositeSharks(String name,int life, int lifeCycle) {
		this.name = name;
		this.life = life;
		this.lifeCycle = lifeCycle;
		sharksList = new ArrayList<CompositeSharks>();
	}

	public void add(CompositeSharks e) {
		sharksList.add(e);
	}

	public void remove(CompositeSharks e) {
		sharksList.remove(e);
	}

	public List<CompositeSharks> getSubordinates(){
		return sharksList;
	}

	public String toString(){
		return ("Sharks :[ Name : " + name + ", life : " + life + ", lifeCycle :" + lifeCycle+" ]\n");
	}   
}
