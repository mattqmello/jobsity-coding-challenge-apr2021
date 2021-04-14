package com.jobsity.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import com.jobsity.model.exception.GameFileAbsent;
import com.jobsity.model.exception.GameInputException;
import com.jobsity.model.exception.InvalidGameFile;
import com.jobsity.model.exception.NoValidRollsFound;
import com.jobsity.model.exception.RollException;

public class GameInput {

	private final Logger logger = Logger.getLogger("GameInput");

	public List<List<String>> readFileFromCmd(String[] args) throws GameInputException {
		String fileName;
		
		try {
			checkGameFileArgument(args);
			fileName = args[0];
		} 
		catch (GameFileAbsent | InvalidGameFile e) {
			throw new GameInputException(e);
		}
		
		logger.info("Game file: "+fileName);
		
		try {
			return readGameRolls(fileName);
		} 
		catch (Exception e) {
			throw new GameInputException("Error reading the game file: "+e.getMessage(), e);
		}
	}

	protected List<List<String>> readGameRolls(String fileName) throws IOException, GameInputException, RollException {
		BufferedReader buffRead = new BufferedReader(new FileReader(fileName));
		String line;
		
		List<List<String>> rollsPerPlayer = new ArrayList<List<String>>();
		List<String> playerRoll;
		
		logger.debug("Reading file lines...");
		
	    while ((line = buffRead.readLine()) != null) {
	    	if (line.length() < 3) {
	    		continue;
			}
	    	
	    	playerRoll = Arrays.asList(line.split("\t"));
	    	rollsPerPlayer.add(playerRoll);
	    	
	    	logger.debug("Actual roll: "+ playerRoll);
	    }
	    
	    if (rollsPerPlayer.size()==0) {
	    	buffRead.close();
			throw new NoValidRollsFound("No valid rolls found in file.");
		}
	    
	    logger.debug("Rolls read: "+ rollsPerPlayer.size());
	    
	    buffRead.close();
	    
		return rollsPerPlayer;
	}

	protected void checkGameFileArgument(String[] args) throws GameFileAbsent, InvalidGameFile {
        if (null == args || args.length == 0) {
        	throw new GameFileAbsent("Game file (.txt) absent.");
        }
        
        if (!args[0].endsWith(".txt")) {
        	throw new InvalidGameFile("Invalid game file extension: "+args[0]);
		}
	}

}
