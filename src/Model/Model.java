package Model;

public class Model {

	private BigFightGame bigFightGame;

	
	public BigFightGame getBigFightGame() {
		return bigFightGame;
	}
	public void setBigFightGame(BigFightGame bigFightGame) {
		this.bigFightGame = bigFightGame;
	}

	public Model(BigFightGame bigFightGame) {
		super();
		this.bigFightGame = bigFightGame;
	}
}
