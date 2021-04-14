package com.jobsity.io;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.jobsity.model.game.Player;
import com.jobsity.model.util.CarlSampleUtil;
import com.jobsity.model.util.DaveSampleUtil;
import com.jobsity.model.util.EarlSampleUtil;
import com.jobsity.model.util.JeffSampleUtil;
import com.jobsity.model.util.JohnSampĺeUtil;

public class GameOutputTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testPrintFrames() {
		String expec = "Frame\t\t1\t\t2\t\t3\t\t4\t\t5\t\t6\t\t7\t\t8\t\t9\t\t10";
		String act = new GameOutput().printFrames();
		
		Assert.assertEquals(expec, act);
	}

	@Test
	public void testPrintPlayerName() {
		Player player = new Player();
		player.setName("Jeff");
		
		String expec = "Jeff";
		String act = new GameOutput().printPlayerName(player);
		
		Assert.assertEquals(expec, act);
	}
	
	@Test
	public void testPrintPlayerPinfalls_Jeff() {
		JeffSampleUtil sample = new JeffSampleUtil(); 
		Player player = new Player();
		
		player.setName(sample.getName());
		player.setPlainRolls(sample.getRollsSample());
		player.setFrames(sample.getFramesSample(player.getPlainRolls()));
		player.setScores(sample.getScoreSample());
		
		String expec = "Pinfalls\t\tX\t7\t/\t9\t0\t\tX\t0\t8\t8\t/\tF\t6\t\tX\t\tX\tX\t8\t1";
		String act = new GameOutput().printPlayerPinfalls(player);
		
		Assert.assertEquals(expec, act);
	}
	
	@Test
	public void testPrintPlayerPinfalls_John() {
		JohnSampĺeUtil sample = new JohnSampĺeUtil(); 
		Player player = new Player();
		
		player.setName(sample.getName());
		player.setPlainRolls(sample.getRollsSample());
		player.setFrames(sample.getFramesSample(player.getPlainRolls()));
		player.setScores(sample.getScoreSample());
		
		String expec = "Pinfalls\t3\t/\t6\t3\t\tX\t8\t1\t\tX\t\tX\t9\t0\t7\t/\t4\t4\tX\t9\t0";
		String act = new GameOutput().printPlayerPinfalls(player);
		
		Assert.assertEquals(expec, act);
	}
	
	@Test
	public void testPrintPlayerPinfalls_Carl() {
		CarlSampleUtil sample = new CarlSampleUtil(); 
		Player player = new Player();
		
		player.setName(sample.getName());
		player.setPlainRolls(sample.getRollsSample());
		player.setFrames(sample.getFramesSample(player.getPlainRolls()));
		player.setScores(sample.getScoreSample());
		
		String expec = "Pinfalls\t\tX\t\tX\t\tX\t\tX\t\tX\t\tX\t\tX\t\tX\t\tX\tX\tX\tX";
		String act = new GameOutput().printPlayerPinfalls(player);
		
		Assert.assertEquals(expec, act);
	}
	
	@Test
	public void testPrintPlayerPinfalls_Dave() {
		DaveSampleUtil sample = new DaveSampleUtil(); 
		Player player = new Player();
		
		player.setName(sample.getName());
		player.setPlainRolls(sample.getRollsSample());
		player.setFrames(sample.getFramesSample(player.getPlainRolls()));
		player.setScores(sample.getScoreSample());
		
		String expec = "Pinfalls\tF\tF\tF\tF\tF\tF\tF\tF\tF\tF\tF\tF\tF\tF\tF\tF\tF\tF\tX\tX\tX";
		String act = new GameOutput().printPlayerPinfalls(player);
		
		Assert.assertEquals(expec, act);
	}

	@Test
	public void testPrintPlayerPinfalls_Earl() {
		EarlSampleUtil sample = new EarlSampleUtil(); 
		Player player = new Player();
		
		player.setName(sample.getName());
		player.setPlainRolls(sample.getRollsSample());
		player.setFrames(sample.getFramesSample(player.getPlainRolls()));
		player.setScores(sample.getScoreSample());
		
		String expec = "Pinfalls\tF\tF\tF\tF\tF\tF\tF\tF\tF\tF\tF\tF\tF\tF\tF\tF\tF\tF\tF\tF";
		String act = new GameOutput().printPlayerPinfalls(player);
		
		Assert.assertEquals(expec, act);
	}

	@Test
	public void testPrintPlayerScores_Jeff() {
		JeffSampleUtil sample = new JeffSampleUtil(); 
		Player player = new Player();
		
		player.setName(sample.getName());
		player.setPlainRolls(sample.getRollsSample());
		player.setFrames(sample.getFramesSample(player.getPlainRolls()));
		player.setScores(sample.getScoreSample());
		
		String expec = "Score\t\t20\t\t39\t\t48\t\t66\t\t74\t\t84\t\t90\t\t120\t\t148\t\t167";
		String act = new GameOutput().printPlayerScores(player);
		
		Assert.assertEquals(expec, act);
	}

	@Test
	public void testPrintPlayerScores_John() {
		JohnSampĺeUtil sample = new JohnSampĺeUtil(); 
		Player player = new Player();
		
		player.setName(sample.getName());
		player.setPlainRolls(sample.getRollsSample());
		player.setFrames(sample.getFramesSample(player.getPlainRolls()));
		player.setScores(sample.getScoreSample());
		
		String expec = "Score\t\t16\t\t25\t\t44\t\t53\t\t82\t\t101\t\t110\t\t124\t\t132\t\t151";
		String act = new GameOutput().printPlayerScores(player);
		
		Assert.assertEquals(expec, act);
	}

	@Test
	public void testPrintPlayerScores_Carl() {
		CarlSampleUtil sample = new CarlSampleUtil(); 
		Player player = new Player();
		
		player.setName(sample.getName());
		player.setPlainRolls(sample.getRollsSample());
		player.setFrames(sample.getFramesSample(player.getPlainRolls()));
		player.setScores(sample.getScoreSample());
		
		String expec = "Score\t\t30\t\t60\t\t90\t\t120\t\t150\t\t180\t\t210\t\t240\t\t270\t\t300";
		String act = new GameOutput().printPlayerScores(player);
		
		Assert.assertEquals(expec, act);
	}

	@Test
	public void testPrintPlayerScores_Dave() {
		DaveSampleUtil sample = new DaveSampleUtil(); 
		Player player = new Player();
		
		player.setName(sample.getName());
		player.setPlainRolls(sample.getRollsSample());
		player.setFrames(sample.getFramesSample(player.getPlainRolls()));
		player.setScores(sample.getScoreSample());
		
		String expec = "Score\t\t0\t\t0\t\t0\t\t0\t\t0\t\t0\t\t0\t\t0\t\t0\t\t30";
		String act = new GameOutput().printPlayerScores(player);
		
		Assert.assertEquals(expec, act);
	}

	@Test
	public void testPrintPlayerScores_Earl() {
		EarlSampleUtil sample = new EarlSampleUtil(); 
		Player player = new Player();
		
		player.setName(sample.getName());
		player.setPlainRolls(sample.getRollsSample());
		player.setFrames(sample.getFramesSample(player.getPlainRolls()));
		player.setScores(sample.getScoreSample());
		
		String expec = "Score\t\t0\t\t0\t\t0\t\t0\t\t0\t\t0\t\t0\t\t0\t\t0\t\t0";
		String act = new GameOutput().printPlayerScores(player);
		
		Assert.assertEquals(expec, act);
	}

}
