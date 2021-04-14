package com.jobsity.model.util;

import java.util.ArrayList;
import java.util.List;

import com.jobsity.model.chance.BlankRoll;
import com.jobsity.model.chance.FinalFrame;
import com.jobsity.model.chance.Foul;
import com.jobsity.model.chance.OpenFrame;
import com.jobsity.model.chance.interfaces.IFrame;
import com.jobsity.model.chance.interfaces.IRoll;

public class EarlSampleUtil implements SampleUtil {
	
	public String getName() {
		return "Earl";
	}
	
	public List<IRoll> getRollsSample() {
		List<IRoll> rolls = new ArrayList<>();
		rolls.add(new Foul());
		rolls.add(new Foul());
		rolls.add(new Foul());
		rolls.add(new Foul());
		rolls.add(new Foul());
		rolls.add(new Foul());
		rolls.add(new Foul());
		rolls.add(new Foul());
		rolls.add(new Foul());
		rolls.add(new Foul());
		rolls.add(new Foul());
		rolls.add(new Foul());
		rolls.add(new Foul());
		rolls.add(new Foul());
		rolls.add(new Foul());
		rolls.add(new Foul());
		rolls.add(new Foul());
		rolls.add(new Foul());
		rolls.add(new Foul());
		rolls.add(new Foul());
		rolls.add(new BlankRoll());

		return rolls;
	}

	public List<IFrame> getFramesSample(List<IRoll> rolls) {
		List<IFrame> frames = new ArrayList<>();
		frames.add(new OpenFrame(rolls.get(0), rolls.get(1)));
		frames.add(new OpenFrame(rolls.get(2), rolls.get(3)));
		frames.add(new OpenFrame(rolls.get(4), rolls.get(5)));
		frames.add(new OpenFrame(rolls.get(6), rolls.get(7)));
		frames.add(new OpenFrame(rolls.get(8), rolls.get(9)));
		frames.add(new OpenFrame(rolls.get(10), rolls.get(11)));
		frames.add(new OpenFrame(rolls.get(12), rolls.get(13)));
		frames.add(new OpenFrame(rolls.get(14), rolls.get(15)));
		frames.add(new OpenFrame(rolls.get(16), rolls.get(17)));
		frames.add(new FinalFrame(rolls.get(18), rolls.get(19), rolls.get(20)));
		return frames;
	}
	
	public List<Integer> getScoreSample() {
		List<Integer> scores = new ArrayList<>();
		scores.add(0);
		scores.add(0);
		scores.add(0);
		scores.add(0);
		scores.add(0);
		scores.add(0);
		scores.add(0);
		scores.add(0);
		scores.add(0);
		scores.add(0);
		return scores;
	}
	

}
