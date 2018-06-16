package BowlingScorer;
public class BowlingScorer {
	
	private int chance;
	private int[] throwBall = new int[21];
    private int currentChance = 0;
    
	public void addChance(int noOfPins)
	  {
	    throwBall[currentChance++] = noOfPins;
	  }
	
	public int scoreinFrame(int totalFrameNo)
	  {
	    chance = 0;
	    int score=0;
	    for (int currentFrame = 0; currentFrame < totalFrameNo; currentFrame++)
	    {
	      if (isStrike())
	        score += 10 + strikeBonus();
	      else if (isSpare())
	        score += 10 + spareBonus();
	      else
	        score += twochancesInFrame();
	    }

	    return score;
	  }

	  private boolean isStrike()
	  {
	    if (throwBall[chance] == 10)
	    {
	      chance++;
	      return true;
	    }
	    return false;
	  }

	  private boolean isSpare()
	  {
	    if ((throwBall[chance] + throwBall[chance+1]) == 10)
	    {
	      chance += 2;
	      return true;
	    }
	    return false;
	  }
	  
	  private int twochancesInFrame()
	  {
	    return throwBall[chance++] + throwBall[chance++];
	  }

	  private int spareBonus()
	  {
	    return throwBall[chance];
	  }
	  private int strikeBonus()
	  {
	    return throwBall[chance] + throwBall[chance+1];
	  }
	  
}
