package Patterns.Composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeEagles {
	private String name;
	private int life;
	private int lifeCycle;
	private List<CompositeEagles> eaglesList;

	// CompositeEagles constructor
	public CompositeEagles(String name,int life, int lifeCycle) {
		this.name = name;
		this.life = life;
		this.lifeCycle = lifeCycle;
		eaglesList = new ArrayList<CompositeEagles>();
	}

	public void add(CompositeEagles e) {
		eaglesList.add(e);
	}

	public void remove(CompositeEagles e) {
		eaglesList.remove(e);
	}

	public List<CompositeEagles> getSubordinates(){
		return eaglesList;
	}

	public String toString(){
		return ("Eagles :[ Name : " + name + ", life : " + life + ", lifeCycle :" + lifeCycle + " ]\n");
	}   
}
