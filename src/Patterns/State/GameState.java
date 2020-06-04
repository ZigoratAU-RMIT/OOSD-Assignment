package Patterns.State;

import Patterns.State.Context.GameStatus;

public class GameState  implements State {
	@Override
	public void doEgaleAction(Context context) {
		// TODO Auto-generated method stub
		context.setGameState(GameStatus.EGALE);
	}

	@Override
	public void doSharkAction(Context context) {
		// TODO Auto-generated method stub
		context.setGameState(GameStatus.SHARK);
	}

	@Override
	public void doGameBeginAction(Context context) {
		// TODO Auto-generated method stub
		context.setGameState(GameStatus.BEGIN);
	}

	@Override
	public void doGameStartAction(Context context) {
		// TODO Auto-generated method stub
		context.setGameState(GameStatus.START);
	}

	@Override
	public void doGamePauseAction(Context context) {
		// TODO Auto-generated method stub
		context.setGameState(GameStatus.PAUSE);
	}

	@Override
	public void doGameEndAction(Context context) {
		// TODO Auto-generated method stub
		context.setGameState(GameStatus.END);
	}

	@Override
	public void doEgaleAttackAction(Context context) {
		// TODO Auto-generated method stub
		context.setGameState(GameStatus.EGALEATTACK);
	}

	@Override
	public void doSharkAttackAction(Context context) {
		// TODO Auto-generated method stub
		context.setGameState(GameStatus.SHARKATTACK);
	}

}
