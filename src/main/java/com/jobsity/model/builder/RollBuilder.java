package com.jobsity.model.builder;

import com.jobsity.model.chance.Foul;
import com.jobsity.model.chance.Pinfall;
import com.jobsity.model.chance.interfaces.IRoll;
import com.jobsity.model.exception.InvalidPinfallNumber;

public class RollBuilder {

	public IRoll buildRoll(int pins) throws InvalidPinfallNumber {
		if (pins < 0) {
			throw new InvalidPinfallNumber("Invalid pinfall number: "+pins+". Must be between 0 and 10.");
		} 
		else if (pins > 0) {
			return new Pinfall(pins);
		} 
		else {
			return new Foul();
		}
	}
}
