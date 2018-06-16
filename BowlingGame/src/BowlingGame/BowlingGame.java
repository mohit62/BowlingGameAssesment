package BowlingGame;
import BowlingScorer.BowlingScorer;
import java.util.Scanner;  
public class BowlingGame {
	
  private boolean firstChanceInFrame = true;
  private int CurrentFrame = 0;
  private BowlingScorer Scorer = new BowlingScorer();
private static Scanner sc;
  
  public int score(String input)
  {
	inputStringToPoints(input);
    return scoreinFrame(CurrentFrame);
  }
  
  private void inputStringToPoints(String input){
	  for (int i=0;i<input.length();i++){
			if (input.charAt(i) != '|'){
				if (input.charAt(i) == 'X') {
					add(10);
				}
				else if(input.charAt(i) == '/' ){
					add(10-Integer.parseInt(String.valueOf(input.charAt(i-1))));
				}
				else if (input.charAt(i) == '-'){
					add(0);
				}
				else{
					add(Integer.parseInt(String.valueOf(input.charAt(i))));
				}	
			}
		}
  }
  
  private void add(int noOfPins)
  {
    Scorer.addChance(noOfPins);
    adjustCurrentFrame(noOfPins);
  }

  private void adjustCurrentFrame(int noOfPins)
  {
    if (firstChanceInFrame == true)
    {
      if (adjustFrameForStrike(noOfPins) == false)
    	  firstChanceInFrame = false;
    }
    else
    {
    	firstChanceInFrame=true;
    	nextFrame();
    }
  }

  private boolean adjustFrameForStrike(int noOfPins)
  {
    if (noOfPins == 10)
    {
      nextFrame();
      return true;
    }
    return false;
  }  

  private void nextFrame()
  {
    CurrentFrame = Math.min(10, CurrentFrame + 1);
  }

  public int scoreinFrame(int totalFrames)
  {
    return Scorer.scoreinFrame(totalFrames);
  }
  
  public static void main(String args[]){
	  sc = new Scanner(System.in);  
	  System.out.println("Enter Input Game State");  
	  String input=sc.next();  
	  BowlingGame newGame = new BowlingGame();
	  System.out.println("The score is "+newGame.score(input));
	  
  }
  
}
