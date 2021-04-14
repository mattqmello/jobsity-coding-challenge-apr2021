package com.jobsity.model.game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import com.jobsity.bo.PlayerBO;
import com.jobsity.model.exception.FrameException;
import com.jobsity.model.exception.GameException;
import com.jobsity.model.exception.PlayerException;
import com.jobsity.model.exception.PlayerNameAbsent;
import com.jobsity.model.exception.PlayerNameAndPinfallAbsent;
import com.jobsity.model.exception.PlayerPinfallAbsent;
import com.jobsity.model.exception.RollException;

public class Game {
	
	private static final String FOUL = "F";
	private static final String ZERO = "0";
	
	private final Logger logger = Logger.getLogger("Game");
	private PlayerBO playerFacade = new PlayerBO(); 

	public Map<String, Player> loadPlayerRolls(List<List<String>> namesAndRolls) throws GameException, RollException, FrameException, PlayerException {
		Map<String,Player> playersMap = new HashMap<>();
		
		logger.info("Loading players Scores...");
		
		for (List<String> nameAndRoll : namesAndRolls) {
			createPlayersAndRolls(nameAndRoll, playersMap);
		}
		
		for (Entry<String, Player> playerEntry : playersMap.entrySet()) {
			playerFacade.generateFramesForPlayer(playerEntry.getValue());
			playerFacade.calculateScoresForPlayer(playerEntry.getValue());
		}
		
		return playersMap;
	}
	
	protected void createPlayersAndRolls(List<String> rollPair, Map<String, Player> playersInGame) throws RollException, FrameException, PlayerException {
		checkRollPair(rollPair);
		
		String name = rollPair.get(0);
		String pinFall = FOUL.equals(rollPair.get(1)) ? ZERO : rollPair.get(1);
		
		logger.debug("Name: "+name);
		logger.debug("Pinfall: "+pinFall);
		
		Player player;
		
		if (playersInGame.containsKey(name)) 
		{
			player = playersInGame.get(name);
			playerFacade.addRollForPlayer(pinFall, player);
		} 
		else {
			player = new Player(name);
			playerFacade.addRollForPlayer(pinFall, player);
			
			playersInGame.put(name, player);
		}
		
		logger.debug("Num of Rolls for "+name+"= "+player.getPlainRolls().size());
	}
	
	protected void checkRollPair(List<String> roll) throws PlayerException {
		if (roll == null || roll.isEmpty()) {
			throw new PlayerNameAndPinfallAbsent();
		}
		
		if (roll.get(0)==null || "".equals(roll.get(0)) ) {
			throw new PlayerNameAbsent();
		}
		
		if (roll.get(1)==null || "".equals(roll.get(1)) ) {
			throw new PlayerPinfallAbsent();
		}
	}
}
