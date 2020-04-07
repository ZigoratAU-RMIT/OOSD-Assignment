package Model;

public class BigFightGame {
	private Egale egale;
	private Shark shark;
	private Pices[] pices;
	
	public BigFightGame(Egale egale, Shark shark, Pices[] pices) {
		this.egale = egale;
		this.shark = shark;
		this.pices = pices;
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
	public Pices[] getPices() {
		return pices;
	}
	public void setPices(Pices[] pices) {
		this.pices = pices;
	}
}
