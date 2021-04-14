package com.jobsity.model.game;

import java.util.List;

import com.jobsity.model.chance.interfaces.IFrame;
import com.jobsity.model.chance.interfaces.IRoll;

public class Player {
	
	private String name;
	private List<Integer> scores;
	private List<IFrame> frames;
	private List<IRoll> rolls;

	public Player() {}
	
	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<IFrame> getFrames() {
		return frames;
	}
	public void setFrames(List<IFrame> frames) {
		this.frames = frames;
	}

	public List<IRoll> getPlainRolls() {
		return rolls;
	}

	public void setPlainRolls(List<IRoll> rolls) {
		this.rolls = rolls;
	}

	public List<Integer> getScores() {
		return scores;
	}

	public void setScores(List<Integer> scores) {
		this.scores = scores;
	}
}
