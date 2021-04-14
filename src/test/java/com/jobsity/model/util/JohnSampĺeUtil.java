package com.jobsity.model.util;

import java.util.ArrayList;
import java.util.List;

import com.jobsity.model.chance.FinalFrame;
import com.jobsity.model.chance.OpenFrame;
import com.jobsity.model.chance.Pinfall;
import com.jobsity.model.chance.SpareFrame;
import com.jobsity.model.chance.StrikeFrame;
import com.jobsity.model.chance.interfaces.IFrame;
import com.jobsity.model.chance.interfaces.IRoll;

public class JohnSampĺeUtil implements SampleUtil {

	@Override
	public String getName() {
		return "John";
	}

	@Override
	public List<IRoll> getRollsSample() {
		List<IRoll> rolls = new ArrayList<>();
		rolls.add(new Pinfall(3));
		rolls.add(new Pinfall(7));
		rolls.add(new Pinfall(6));
		rolls.add(new Pinfall(3));
		rolls.add(new Pinfall(10));
		rolls.add(new Pinfall(8));
		rolls.add(new Pinfall(1));
		rolls.add(new Pinfall(10));
		rolls.add(new Pinfall(10));
		rolls.add(new Pinfall(9));
		rolls.add(new Pinfall(0));
		rolls.add(new Pinfall(7));
		rolls.add(new Pinfall(3));
		rolls.add(new Pinfall(4));
		rolls.add(new Pinfall(4));
		rolls.add(new Pinfall(10));
		rolls.add(new Pinfall(9));
		rolls.add(new Pinfall(0));
		return rolls;
	}

	@Override
	public List<IFrame> getFramesSample(List<IRoll> rolls) {
		List<IFrame> frames = new ArrayList<>();
		frames.add(new SpareFrame(rolls.get(0), rolls.get(1)));
		frames.add(new OpenFrame(rolls.get(2), rolls.get(3)));
		frames.add(new StrikeFrame(rolls.get(4)));
		frames.add(new OpenFrame(rolls.get(5), rolls.get(6)));
		frames.add(new StrikeFrame(rolls.get(7)));
		frames.add(new StrikeFrame(rolls.get(8)));
		frames.add(new OpenFrame(rolls.get(9), rolls.get(10)));
		frames.add(new SpareFrame(rolls.get(11), rolls.get(12)));
		frames.add(new OpenFrame(rolls.get(13), rolls.get(14)));
		frames.add(new FinalFrame(rolls.get(15), rolls.get(16), rolls.get(17)));
		return frames;
	}

	@Override
	public List<Integer> getScoreSample() {
		List<Integer> scores = new ArrayList<>();
		scores.add(16);
		scores.add(25);
		scores.add(44);
		scores.add(53);
		scores.add(82);
		scores.add(101);
		scores.add(110);
		scores.add(124);
		scores.add(132);
		scores.add(151);
		return scores;
	}

}
