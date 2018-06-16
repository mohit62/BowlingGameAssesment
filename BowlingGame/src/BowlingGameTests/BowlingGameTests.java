package BowlingGameTests;
import static org.junit.Assert.*;

import org.junit.Test;

import BowlingGame.BowlingGame;


public class BowlingGameTests {
	
	BowlingGame g=new BowlingGame();
	 @Test
	  public void testSingleFrame()
	  { 
	    assertEquals(7, g.score("25"));
	  }
	@Test
	public void testSimpleSpare()
	  {
		assertEquals(22, g.score("5/|52"));
		assertEquals(15, g.scoreinFrame(1));
	  }
	@Test
	public void testSimpleStrike()
	  {
		assertEquals(24, g.score("X|52"));
		assertEquals(17, g.scoreinFrame(1));
	  }
	 @Test
	  public void testPerfectSpares()
	  {
	    
	    assertEquals(150, g.score("5/|5/|5/|5/|5/|5/|5/|5/|5/|5/||5"));
	  }
	 @Test
	 public void testPerfectStrikes()
	  {
	    assertEquals(300, g.score("X|X|X|X|X|X|X|X|X|X||XX"));
	  }
	 @Test
	 public void testPerfectMiss()
	  {
	    assertEquals(0, g.score("--|--|--|--|--|--|--|--|--|--||"));
	  }
	 @Test
	 public void testAlternateMiss()
	  {
	    assertEquals(90, g.score("9-|9-|9-|9-|9-|9-|9-|9-|9-|9-||"));
	  }
	 @Test
	  public void testNoSpareOrStrike()
	  {
	    assertEquals(23, g.score("23|45|54"));
	    assertEquals(5, g.scoreinFrame(1));
	    assertEquals(14, g.scoreinFrame(2));
	    assertEquals(23, g.scoreinFrame(3));
	  }
	 
	 
	 @Test
	  public void testSimpleFrameAfterSpare()
	  {
		assertEquals(22, g.score("5/|52"));
	    assertEquals(15, g.scoreinFrame(1));
	    assertEquals(22, g.scoreinFrame(2));

	  }
	 @Test
	  public void testBonusStrikeAFterSpare()
	  {
	    assertEquals(20, g.score("--|--|--|--|--|--|--|--|--|4/||X"));
	   }
	 @Test
	  public void testLastStrikeMiss()
	  { 
	    assertEquals(299, g.score("X|X|X|X|X|X|X|X|X|X||X9"));
	  }
	 
	 @Test
	  public void testLastFrameSpare()
	  { 
	    assertEquals(16, g.score("--|--|--|--|--|--|--|--|--|4/||6"));
	  }

}
