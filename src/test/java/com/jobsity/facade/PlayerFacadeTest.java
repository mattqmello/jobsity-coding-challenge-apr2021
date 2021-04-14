package com.jobsity.facade;

import java.util.List;

import org.apache.log4j.Logger;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.jobsity.bo.PlayerBO;
import com.jobsity.model.chance.interfaces.IFrame;
import com.jobsity.model.exception.FrameException;
import com.jobsity.model.exception.PlayerException;
import com.jobsity.model.exception.RollException;
import com.jobsity.model.game.Player;
import com.jobsity.model.util.CarlSampleUtil;
import com.jobsity.model.util.DaveSampleUtil;
import com.jobsity.model.util.JeffSampleUtil;
import com.jobsity.model.util.JohnSampleUtil;

public class PlayerFacadeTest {
	
	PlayerBO classUnderTest;
	
	@Before
	public void setUp() throws Exception {
		classUnderTest = new PlayerBO();
	}
	
	@Test
	public void testAddRollForPlayer_numOfRolls() throws RollException, FrameException {
		Player player = new Player();
		int pinfall = 10;
		
		for (int i=0; i < 10; i++) {
			classUnderTest.addRollForPlayer(String.valueOf(pinfall), player);
		}
		
		Assert.assertEquals(10, player.getPlainRolls().size());
	}

	@Test
	public void testAddRollForPlayer_numOrder() throws RollException, FrameException {
		Player player = new Player();
		int[] pin = new int[] {10, 1, 0};
		
		classUnderTest.addRollForPlayer(String.valueOf(pin[0]), player);
		classUnderTest.addRollForPlayer(String.valueOf(pin[1]), player);
		classUnderTest.addRollForPlayer(String.valueOf(pin[2]), player);
		
		for (int i=0; i < player.getPlainRolls().size(); i++) {
			Assert.assertEquals(pin[i], player.getPlainRolls().get(i).getPinsDown());
		}
	}
	
	@Test
	public void testGenerateFramesForPlayer_Carl() throws RollException, PlayerException {
		CarlSampleUtil sample = new CarlSampleUtil(); 
		Player player = new Player();
		
		player.setName(sample.getName());
		player.setPlainRolls(sample.getRollsSample());
		player.setFrames(sample.getFramesSample(player.getPlainRolls()));
		
		List<IFrame> expected = player.getFrames();
		List<IFrame> actual = classUnderTest.generateFramesForPlayer(player);
		
		Assert.assertEquals(expected.size(), actual.size());
		Assert.assertThat(actual, CoreMatchers.is(expected));
		for (int i=0; i < expected.size(); i++) {
			Assert.assertEquals(expected.get(i).getIdentifier(), actual.get(i).getIdentifier());
		}
	}
	
	@Test
	public void testGenerateFramesForPlayer_Dave() throws RollException, PlayerException {
		DaveSampleUtil sample = new DaveSampleUtil(); 
		Player player = new Player();
		
		player.setName(sample.getName());
		player.setPlainRolls(sample.getRollsSample());
		player.setFrames(sample.getFramesSample(player.getPlainRolls()));
		
		List<IFrame> expected = player.getFrames();
		List<IFrame> actual = classUnderTest.generateFramesForPlayer(player);
		
		Assert.assertEquals(expected.size(), actual.size());
		Assert.assertThat(actual, CoreMatchers.is(expected));
		for (int i=0; i < expected.size(); i++) {
			Assert.assertEquals(expected.get(i).getIdentifier(), actual.get(i).getIdentifier());
		}
	}
	
	@Test
	public void testGenerateFramesForPlayer_Jeff() throws RollException, PlayerException {
		JeffSampleUtil sample = new JeffSampleUtil(); 
		Player player = new Player();
		
		player.setName(sample.getName());
		player.setPlainRolls(sample.getRollsSample());
		player.setFrames(sample.getFramesSample(player.getPlainRolls()));
		
		List<IFrame> expected = player.getFrames();
		List<IFrame> actual = classUnderTest.generateFramesForPlayer(player);
		
		Assert.assertEquals(expected.size(), actual.size());
		Assert.assertThat(actual, CoreMatchers.is(expected));
		for (int i=0; i < expected.size(); i++) {
			Assert.assertEquals(expected.get(i).getIdentifier(), actual.get(i).getIdentifier());
		}
	}
	
	@Test
	public void testGenerateFramesForPlayer_Jonh() throws RollException, PlayerException {
		JohnSampleUtil sample = new JohnSampleUtil(); 
		Player player = new Player();
		
		player.setName(sample.getName());
		player.setPlainRolls(sample.getRollsSample());
		player.setFrames(sample.getFramesSample(player.getPlainRolls()));
		
		List<IFrame> expected = player.getFrames();
		List<IFrame> actual = classUnderTest.generateFramesForPlayer(player);
		
		Assert.assertEquals(expected.size(), actual.size());
		Assert.assertThat(actual, CoreMatchers.is(expected));
		
		for (int i=0; i < expected.size(); i++) {
			Assert.assertEquals(expected.get(i).getIdentifier(), actual.get(i).getIdentifier());
		}
	}

	@Test
	public void testCalculateScoresForPlayer_Jeff() throws PlayerException {
		JeffSampleUtil sample = new JeffSampleUtil(); 
		Player player = new Player();
		
		player.setName(sample.getName());
		player.setPlainRolls(sample.getRollsSample());
		player.setFrames(sample.getFramesSample(player.getPlainRolls()));
		player.setScores(sample.getScoreSample());
		
		List<Integer> expected = player.getScores();
		List<Integer> actual = classUnderTest.calculateScoresForPlayer(player);
		
		Assert.assertEquals(expected.size(), actual.size());
		Assert.assertThat(actual, CoreMatchers.is(expected));
		
		for (int i=0; i < expected.size(); i++) {
			Assert.assertEquals(expected.get(i), actual.get(i));
			Logger.getLogger(this.getClass()).debug("Expecte: "+expected.get(i)+" // Actual: "+actual.get(i));
		}
	}
	
	@Test
	public void testCalculateScoresForPlayer_Carl() throws PlayerException {
		CarlSampleUtil sample = new CarlSampleUtil(); 
		Player player = new Player();
		
		player.setName(sample.getName());
		player.setPlainRolls(sample.getRollsSample());
		player.setFrames(sample.getFramesSample(player.getPlainRolls()));
		player.setScores(sample.getScoreSample());
		
		List<Integer> expected = player.getScores();
		List<Integer> actual = classUnderTest.calculateScoresForPlayer(player);
		
		Assert.assertEquals(expected.size(), actual.size());
		Assert.assertThat(actual, CoreMatchers.is(expected));
		
		for (int i=0; i < expected.size(); i++) {
			Assert.assertEquals(expected.get(i), actual.get(i));
		}
	}
	
	@Test
	public void testCalculateScoresForPlayer_Dave() throws PlayerException {
		DaveSampleUtil sample = new DaveSampleUtil(); 
		Player player = new Player();
		
		player.setName(sample.getName());
		player.setPlainRolls(sample.getRollsSample());
		player.setFrames(sample.getFramesSample(player.getPlainRolls()));
		player.setScores(sample.getScoreSample());
		
		List<Integer> expected = player.getScores();
		List<Integer> actual = classUnderTest.calculateScoresForPlayer(player);
		
		Assert.assertEquals(expected.size(), actual.size());
		Assert.assertThat(actual, CoreMatchers.is(expected));
		
		for (int i=0; i < expected.size(); i++) {
			Assert.assertEquals(expected.get(i), actual.get(i));
		}
	}

}
