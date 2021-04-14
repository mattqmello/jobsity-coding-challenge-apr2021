package com.jobsity.model.chance;

import com.jobsity.model.chance.enums.PinDownType;
import com.jobsity.model.chance.interfaces.IRoll;

public class Pinfall implements IRoll {
	
	private int pinsDown;
	
	public Pinfall(int pinsDown) {
		super();
		this.pinsDown = pinsDown;
	}
	
	@Override
	public int getPinsDown() {
		return pinsDown;
	}

	public void setPinsDown(int pinsDown) {
		this.pinsDown = pinsDown;
	}

	@Override
	public int getNextAllowedRolls() {
		return 1;
	}

	@Override
	public String getPinsdownRepresentation() {
		return pinsDown == 10 ? PinDownType.STRIKE.str : String.valueOf(pinsDown);
	}
}
