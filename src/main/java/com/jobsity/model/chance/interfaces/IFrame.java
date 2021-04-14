package com.jobsity.model.chance.interfaces;

import java.util.List;

import com.jobsity.model.chance.enums.FrameType;

public interface IFrame {
	public FrameType getIdentifier() ;
	
	public int getMaxRolls() ;
	
	public int getNextAllowedRolls() ;
	
	public List<IRoll> getRolls();
	public void setRolls(List<IRoll> rolls);
}
