package Patterns.State;

public class Context {
	
	public enum GameStatus {
		BEGIN,
		START,
		PAUSE,
		EGALE,
		EGALEATTACK,
		SHARK,
		SHARKATTACK,
		END}
	
	private GameStatus state;
	
	public Context() {
		state = GameStatus.START;
	}

	public GameStatus getGameState() {
		return state;
	}

	public void setGameState(GameStatus state) {
		this.state = state;
	}

}
