package domain;

import java.util.ArrayList;
import java.util.List;

public class HintWoord {
	
	private List<HintLetter> hintLetters;
	private String woord;
	
	public HintWoord(String woord){
		hintLetters = new ArrayList<>();
		setWoord(woord);
		
		char[] woordArray = woord.toCharArray();
		for(char c: woordArray){
			hintLetters.add(new HintLetter(c));
		}
	}
	
	private void setWoord(String woord){
		if(woord == null || woord.trim().isEmpty()){
			throw new DomainException("Woord mag niet leeg zijn.");
		}
		this.woord = woord;
	}
	
	public String getWoord(){
		return woord;
	}
	
	public String toString(){
		String res = "";
		for(HintLetter letter: hintLetters){
			res += letter.toChar() + " ";
		}
		res = res.substring(0, res.length()-1);
		
		return res;
	}
	
	public boolean raad(char letter){
		boolean geraden = false;
		for (HintLetter c : hintLetters){
			if (c.raad(letter)) {
				geraden = true;
			}
		}
		return geraden;
	}
	
	public boolean isGeraden(){
		for (HintLetter c : hintLetters){
			if (!c.isGeraden()) return false;
		}
		return true;
	}
}