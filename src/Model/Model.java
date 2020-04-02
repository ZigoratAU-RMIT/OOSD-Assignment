package Model;

public class Model {

	private Egale egale;
	private Shark shark;
	private Pices[] pices;

	public Egale getEgale() {
		return egale;
	}

	public void setEgale(Egale egale) {
		this.egale = egale;
	}

	public Shark getShark() {
		return shark;
	}

	public void setShark(Shark shark) {
		this.shark = shark;
	}

	public Pices[] getPices() {
		return pices;
	}

	public void setPices(Pices[] pices) {
		this.pices = pices;
	}
	
	public Model() {
		egale = new Egale("Bateleur");
		shark = new Shark("White");
		pices = new Pices[6];
		pices[0] = new Pices("Bald");
		pices[1]= new Pices("Whale");
		pices[2]= new Pices("Black");
		pices[3]= new Pices("Bull");
		pices[4]= new Pices("Whale");
		pices[5]= new Pices("Blue");
	}
}
