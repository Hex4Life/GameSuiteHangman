package domain;

public class HintLetter {
	
	boolean geraden = false;
	private char letter;
	
	public HintLetter(char letter){
		setLetter(letter);
	}
	
	private void setLetter(char letter){
		if (letter == ' '){
			geraden = true;
		}
		this.letter = letter;
	}
	
	public char getLetter(){
		return letter;			
	} 
	
	public boolean isGeraden(){
		return geraden;
	}
	
	public boolean raad(char letter){
		if(Character.toLowerCase(letter) == Character.toLowerCase(this.letter) && geraden == false){
			geraden = true;
			return geraden;
		}
		return false;
	}
	
	public char toChar(){
		if(geraden){
			return letter;
		}
		return '_';
	}
}
