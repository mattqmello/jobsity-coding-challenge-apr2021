package com.jobsity.bo;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.jobsity.model.builder.RollBuilder;
import com.jobsity.model.chance.BlankRoll;
import com.jobsity.model.chance.FinalFrame;
import com.jobsity.model.chance.OpenFrame;
import com.jobsity.model.chance.SpareFrame;
import com.jobsity.model.chance.StrikeFrame;
import com.jobsity.model.chance.interfaces.IFrame;
import com.jobsity.model.chance.interfaces.IRoll;
import com.jobsity.model.exception.FrameException;
import com.jobsity.model.exception.InvalidPinfallException;
import com.jobsity.model.exception.InvalidPlayerState;
import com.jobsity.model.exception.PlayerException;
import com.jobsity.model.exception.RollException;
import com.jobsity.model.game.Player;

public class PlayerBO {
	
	private final Logger logger = Logger.getLogger("PlayerFacade");
	private RollBuilder rollBuilder = new RollBuilder();
	
	public void addRollForPlayer(String pinsStr, Player player) throws RollException, FrameException {
		int pins = getPinfallValue(pinsStr);
		
		IRoll roll = rollBuilder.buildRoll(pins);
		
		if (player.getPlainRolls() == null) {
			player.setPlainRolls(new ArrayList<IRoll>());
		}

		player.getPlainRolls().add(roll);
	}

	protected int getPinfallValue(String pinsStr) throws InvalidPinfallException {
		try {
			return Integer.valueOf(pinsStr);
		} 
		catch (NumberFormatException e) {
			throw new InvalidPinfallException("Invalid pinfall: "+pinsStr);
		}
	}

	public List<IFrame> generateFramesForPlayer(Player player) throws RollException, PlayerException {
		logger.info("Generating Players Frames...");
		
		List<IFrame> frames = getPlayerFrames(player);
		
		IRoll currRoll;
		IRoll prevRoll;
		int pinsSum=0;
		boolean hasPreviousRolls=false;
		
		for (int i=0; i < player.getPlainRolls().size(); i++) {
			
			if (frames.size()<10) {
				
				hasPreviousRolls = i>0;
				currRoll = player.getPlainRolls().get(i);
				
				if (currRoll.getPinsDown() == 10) {
					frames.add(new StrikeFrame(currRoll));
					continue;
				}
				
				if (hasPreviousRolls) {
					prevRoll = player.getPlainRolls().get(i-1);
					
					pinsSum = prevRoll.getPinsDown() + currRoll.getPinsDown();
							
					if (pinsSum == 10) {
						frames.add(new SpareFrame(prevRoll,currRoll));
						continue;
					}
					
					if (pinsSum >= 0 && pinsSum < 10) {
						frames.add(new OpenFrame(prevRoll,currRoll));
						continue;
					}
				}
			} 
			else if (frames.size() == 10) {
				
				IFrame finalFrame = new FinalFrame();
				finalFrame.setRolls(new ArrayList<IRoll>());
				
				for (int f = i; f < player.getPlainRolls().size(); f++) {
					currRoll = player.getPlainRolls().get(f);
					
					finalFrame.getRolls().add(currRoll == null ? new BlankRoll() : currRoll);
				}
				
				frames.add(finalFrame);
			}
		}
		
		logger.info("Frames generated: "+frames.size());
		return frames;
	}
	
	protected List<IFrame> getPlayerFrames(Player player) {
		if (player.getFrames() == null) {
			player.setFrames(new ArrayList<IFrame>());
		} 
		
		return player.getFrames();
	}

	public List<Integer> calculateScoresForPlayer(Player player) throws InvalidPlayerState {
		List<Integer> scores = getPlayerScores(player);
		List<IRoll> rolls = player.getPlainRolls();
		
		int sum=0;
		
		for (int i=0; i < rolls.size(); i++) {
			
			sum += rolls.get(i).getPinsDown();
			
			scores.add(sum);
			i+=1;
			continue;
		}
		
		return scores;
	}

	protected List<Integer> getPlayerScores(Player player) {
		if (player.getScores() == null) {
			player.setScores(new ArrayList<Integer>());
		} 
		
		return player.getScores();
	}
}
