package com.jobsity.model.util;

import java.util.List;

import com.jobsity.model.chance.interfaces.IFrame;
import com.jobsity.model.chance.interfaces.IRoll;

public interface SampleUtil {

	public String getName() ;
	
	public List<IRoll> getRollsSample();
	public List<IFrame> getFramesSample(List<IRoll> rolls) ;
	public List<Integer> getScoreSample();
}
