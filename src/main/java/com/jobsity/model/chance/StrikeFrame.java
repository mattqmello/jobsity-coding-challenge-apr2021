package com.jobsity.model.chance;

import java.util.Collections;
import java.util.List;

import com.jobsity.model.chance.enums.FrameType;
import com.jobsity.model.chance.interfaces.IFrame;
import com.jobsity.model.chance.interfaces.IRoll;

public class StrikeFrame implements IFrame {

	private IRoll rollStrike;
	
	public StrikeFrame() {}
	
	public StrikeFrame(IRoll roll1) {
		super();
		rollStrike = roll1;
	}

	@Override
	public FrameType getIdentifier() {
		return FrameType.STRIKE;
	}
	
	@Override
	public int getMaxRolls() {
		return 1;
	}
	
	@Override
	public void setRolls(List<IRoll> rolls) {
		this.rollStrike = rolls.get(0);
	}

	@Override
	public List<IRoll> getRolls() {
		return Collections.singletonList(rollStrike);
	}

	@Override
	public int getNextAllowedRolls() {
		return 2;
	}

}