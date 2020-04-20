package Model;

public class BigFightGame {
	private Eagle egale;
	private Shark shark;
	private Pieces[] pieces;
	
	public BigFightGame(Eagle egale, Shark shark, Pieces[] pieces) {
		this.egale = egale;
		this.shark = shark;
		this.pieces = pieces;
	}
	public Eagle getEgale() {
		return egale;
	}
	public void setEgale(Eagle egale) {
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
	public void setPices(Pieces[] pieces) {
		this.pieces = pieces;
	}
}
