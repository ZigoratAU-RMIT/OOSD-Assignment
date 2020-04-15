package Model;

public class Egale extends Animal {

	private int Rsting = 1;
	
	public Egale(String name) {
		super(name,true);
		// TODO Auto-generated constructor stub	
	}
	
	public int getRsting() {
		return Rsting;
	}
	public void setRsting(int rsting) {
		Rsting = rsting;
	}
}