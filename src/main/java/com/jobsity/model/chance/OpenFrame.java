package com.jobsity.model.chance;

import java.util.ArrayList;
import java.util.List;

import com.jobsity.model.chance.enums.FrameType;
import com.jobsity.model.chance.interfaces.IFrame;
import com.jobsity.model.chance.interfaces.IRoll;

public class OpenFrame implements IFrame {
	
	private List<IRoll> rolls;
	
	public OpenFrame() {}
	
	public OpenFrame(IRoll roll1, IRoll roll2) {
		super();
		this.rolls = new ArrayList<IRoll>();
		rolls.add(roll1);
		rolls.add(roll2);
	}

	@Override
	public FrameType getIdentifier() {
		return FrameType.OPEN_OR_SPARE;
	}

	@Override
	public int getMaxRolls() {
		return 2;
	}

	@Override
	public List<IRoll> getRolls() {
		return rolls;
	}

	@Override
	public void setRolls(List<IRoll> rolls) {
		this.rolls = rolls;
	}

	@Override
	public int getNextAllowedRolls() {
		return 1;
	}
	
}
