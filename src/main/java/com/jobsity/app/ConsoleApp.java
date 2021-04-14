package com.jobsity.app;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.jobsity.io.GameInput;
import com.jobsity.io.GameOutput;
import com.jobsity.model.exception.FrameException;
import com.jobsity.model.exception.GameException;
import com.jobsity.model.exception.GameInputException;
import com.jobsity.model.exception.PlayerException;
import com.jobsity.model.exception.RollException;
import com.jobsity.model.game.Game;
import com.jobsity.model.game.Player;

public class ConsoleApp {

	private final static Logger logger = Logger.getLogger("ConsoleApp");

	public static void main(String[] args) throws GameInputException, GameException, RollException, FrameException, PlayerException {
		logger.info("Welcome to the Bowling Game Calculator!");
		
		List<List<String>> namesAndRolls = new GameInput().readFileFromCmd(args);
		
		Map<String, Player> playersInGame = new Game().loadPlayerRolls(namesAndRolls);
		
		new GameOutput().printGameScore(playersInGame);
		
		logger.info("End.");
	}

}
