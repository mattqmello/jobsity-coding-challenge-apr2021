package com.jobsity.model.util;

import java.util.ArrayList;
import java.util.List;

import com.jobsity.model.chance.FinalFrame;
import com.jobsity.model.chance.Pinfall;
import com.jobsity.model.chance.StrikeFrame;
import com.jobsity.model.chance.interfaces.IFrame;
import com.jobsity.model.chance.interfaces.IRoll;

public class CarlSampleUtil implements SampleUtil {
	
	public String getName() {
		return "Carl";
	}
	
	public List<IRoll> getRollsSample() {
		List<IRoll> rolls = new ArrayList<>();
		rolls.add(new Pinfall(10));
		rolls.add(new Pinfall(10));
		rolls.add(new Pinfall(10));
		rolls.add(new Pinfall(10));
		rolls.add(new Pinfall(10));
		rolls.add(new Pinfall(10));
		rolls.add(new Pinfall(10));
		rolls.add(new Pinfall(10));
		rolls.add(new Pinfall(10));
		rolls.add(new Pinfall(10));
		rolls.add(new Pinfall(10));
		rolls.add(new Pinfall(10));

		return rolls;
	}

	public List<IFrame> getFramesSample(List<IRoll> rolls) {
		List<IFrame> frames = new ArrayList<>();
		frames.add(new StrikeFrame(rolls.get(0)));
		frames.add(new StrikeFrame(rolls.get(1)));
		frames.add(new StrikeFrame(rolls.get(2)));
		frames.add(new StrikeFrame(rolls.get(3)));
		frames.add(new StrikeFrame(rolls.get(4)));
		frames.add(new StrikeFrame(rolls.get(5)));
		frames.add(new StrikeFrame(rolls.get(6)));
		frames.add(new StrikeFrame(rolls.get(7)));
		frames.add(new StrikeFrame(rolls.get(8)));
		frames.add(new FinalFrame(rolls.get(9), rolls.get(10), rolls.get(11)));
		return frames;
	}
	
	public List<Integer> getScoreSample() {
		List<Integer> scores = new ArrayList<>();
		scores.add(30);
		scores.add(60);
		scores.add(90);
		scores.add(120);
		scores.add(150);
		scores.add(180);
		scores.add(210);
		scores.add(240);
		scores.add(270);
		scores.add(300);
		return scores;
	}
	

}
