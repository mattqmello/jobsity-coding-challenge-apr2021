package com.jobsity.model.chance;

import com.jobsity.model.chance.enums.PinDownType;
import com.jobsity.model.chance.interfaces.IRoll;

public class Foul implements IRoll {
	
	@Override
	public int getPinsDown() {
		return 0;
	}

	@Override
	public int getNextAllowedRolls() {
		return 1;
	}

	@Override
	public String getPinsdownRepresentation() {
		return PinDownType.FOUL.str;
	}
}
