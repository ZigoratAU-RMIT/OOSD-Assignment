package Model;

public class BigFightGame {
	private Egale egale;
	private Shark shark;
	private Pieces[] pieces;
	
	public BigFightGame(Egale egale, Shark shark, Pieces[] pices) {
		this.egale = egale;
		this.shark = shark;
		this.pieces = pices;
	}
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
	public Pieces[] getPices() {
		return pieces;
	}
	public void setPices(Pieces[] pices) {
		this.pieces = pices;
	}
}
