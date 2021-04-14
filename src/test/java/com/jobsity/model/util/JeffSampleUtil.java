package com.jobsity.model.util;

import java.util.ArrayList;
import java.util.List;

import com.jobsity.model.chance.FinalFrame;
import com.jobsity.model.chance.Foul;
import com.jobsity.model.chance.OpenFrame;
import com.jobsity.model.chance.Pinfall;
import com.jobsity.model.chance.SpareFrame;
import com.jobsity.model.chance.StrikeFrame;
import com.jobsity.model.chance.interfaces.IFrame;
import com.jobsity.model.chance.interfaces.IRoll;

public class JeffSampleUtil implements SampleUtil {
	
	public String getName() {
		return "Jeff";
	}
	
	public List<IRoll> getRollsSample() {
		List<IRoll> rolls = new ArrayList<>();
		rolls.add(new Pinfall(10));
		rolls.add(new Pinfall(7));
		rolls.add(new Pinfall(3));
		rolls.add(new Pinfall(9));
		rolls.add(new Pinfall(0));
		rolls.add(new Pinfall(10));
		rolls.add(new Pinfall(0));
		rolls.add(new Pinfall(8));
		rolls.add(new Pinfall(8));
		rolls.add(new Pinfall(2));
		rolls.add(new Foul());
		rolls.add(new Pinfall(6));
		rolls.add(new Pinfall(10));
		rolls.add(new Pinfall(10));
		rolls.add(new Pinfall(10));
		rolls.add(new Pinfall(8));
		rolls.add(new Pinfall(1));
		return rolls;
	}

	public List<IFrame> getFramesSample(List<IRoll> rolls) {
		List<IFrame> frames = new ArrayList<>();
		frames.add(new StrikeFrame(rolls.get(0)));
		frames.add(new SpareFrame(rolls.get(1), rolls.get(2)));
		frames.add(new OpenFrame(rolls.get(3), rolls.get(4)));
		frames.add(new StrikeFrame(rolls.get(5)));
		frames.add(new OpenFrame(rolls.get(6), rolls.get(7)));
		frames.add(new SpareFrame(rolls.get(8), rolls.get(9)));
		frames.add(new OpenFrame(rolls.get(10), rolls.get(11)));
		frames.add(new StrikeFrame(rolls.get(12)));
		frames.add(new StrikeFrame(rolls.get(13)));
		frames.add(new FinalFrame(rolls.get(14), rolls.get(15), rolls.get(16)));
		return frames;
	}
	
	public List<Integer> getScoreSample() {
		List<Integer> scores = new ArrayList<>();
		scores.add(20);
		scores.add(39);
		scores.add(48);
		scores.add(66);
		scores.add(74);
		scores.add(84);
		scores.add(90);
		scores.add(120);
		scores.add(148);
		scores.add(167);
		return scores;
	}
}
