
/**
 * Write a description of MarkovOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class MarkovOne extends AbstractMarkovModel{
	
	public MarkovOne() {
		myRandom = new Random();
	}
	
	public String getRandomText(int numChars){
		if (myText == null){
			return "";
		}
		StringBuilder sb = new StringBuilder();
		int index = myRandom.nextInt(myText.length() - 1);
		String key = myText.substring(index, index + 1);
		sb.append(key);
		for(int k = 0; k < numChars - 1; k++){
			ArrayList<String> follows = getFollows(key);
			index = myRandom.nextInt(follows.size());
			sb.append(follows.get(index));
			key = key.substring(1) + follows.get(index);
		}
		
		return sb.toString();
	}
	
	public String toString() {
	   return "MarcovModel of order " + "1";
	}
}
