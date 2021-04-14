package com.jobsity.io;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.jobsity.model.chance.enums.FrameType;
import com.jobsity.model.chance.interfaces.IFrame;
import com.jobsity.model.chance.interfaces.IRoll;
import com.jobsity.model.game.Player;

public class GameOutput {

	private final Logger logger = Logger.getLogger("GameOutput");
	
	private static final String FRAMES_HEADER = "Frame\t\t1\t\t2\t\t3\t\t4\t\t5\t\t6\t\t7\t\t8\t\t9\t\t10";
	private static final Object DOUBLE_TAB = "\t\t";
	private static final Object SINGLE_TAB = "\t";

	private static final char SPARE_CHAR = '/';
	
	public void printGameScore(Map<String, Player> playersInGame) {
		List<Player> playersList = new ArrayList<Player>(playersInGame.values());
		
		logger.debug("Printing results...");
		
		for (Player player : playersList) {
			printFrames();
			printPlayerName(player);
			printPlayerPinfalls(player);
			printPlayerScores(player);
		}
	}
	
	protected String printFrames() {
		return println(FRAMES_HEADER);		
	}
	
	protected String printPlayerName(Player player) {
		return println(player.getName());
	}
	
	protected String printPlayerPinfalls(Player player) {
		List<IFrame> frames = player.getFrames();
		List<IRoll> rolls;
		IFrame frame;
		
		StringBuffer line = new StringBuffer();
		line.append("Pinfalls");
		
		for (int f=0; f < frames.size(); f++) {
			
			frame = frames.get(f);
			
			rolls = frame.getRolls();
			
			for (int r=0; r < rolls.size(); r++) {
				
				if (FrameType.OPEN_OR_SPARE == frame.getIdentifier()) {
					line.append(SINGLE_TAB);
					line.append(rolls.get(r).getPinsdownRepresentation());
					line.append(SINGLE_TAB);
					
					if (rolls.get(r).getPinsDown() + rolls.get(r+1).getPinsDown() == 10) {
						line.append(SPARE_CHAR);
					} else {
						line.append(rolls.get(r+1).getPinsdownRepresentation());
					}
					r++;
					continue;
				}
				
				if (FrameType.STRIKE == frame.getIdentifier()) {
					line.append(DOUBLE_TAB);
					line.append(rolls.get(r).getPinsdownRepresentation());
					continue;
				}
				
				if (FrameType.FINAL == frame.getIdentifier()) {
					if (rolls.get(r).getNextAllowedRolls()>=0) {
						line.append(SINGLE_TAB);
					}
					
					line.append(rolls.get(r).getPinsdownRepresentation());
					continue;
				}
			}
		}
		
		return println(line.toString());
	}

	protected String println(String str) {
		System.out.println(str);
		return str;
	}

	protected String printPlayerScores(Player player) {
		StringBuffer line = new StringBuffer();
		line.append("Score");
		
		for (Integer score : player.getScores()) {
			line.append(DOUBLE_TAB);
			line.append(score);
		}
		
		return println(line.toString());
	}
}
