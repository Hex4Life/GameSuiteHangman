package domain;

import java.util.ArrayList;
import java.util.List;

public class HintWoord {
	
	private boolean geraden;
	private List<HintLetter> hintLetters;
	private String woord;
	private String hint;
	
	public HintWoord(String woord){
		hintLetters = new ArrayList<>();
		setWoord(woord);
		
		char[] woordArray = woord.toCharArray();
		System.out.println(woordArray);
		;
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
			res =+ letter.toChar() + " ";
		}
		return res;
	}
	
	public boolean raad(char letter){
		return false;
	}
	
	public boolean isGeraden(){
		return geraden;
	}
	
	
	
	
	
}
