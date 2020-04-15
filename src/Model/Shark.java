package Model;

public class Shark extends Animal {
	
	private int Jumping = 1;
	
	public int getJumping() {
		return Jumping;
	}

	public void setJumping(int jumping) {
		Jumping = jumping;
	}

	public Shark(String name) {
		super(name, false);
		// TODO Auto-generated constructor stub
	}

}
