package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WoordenLijst {
	
	private List<String> woorden;
	
	public WoordenLijst(){
		woorden = new ArrayList<>();
	}
	
	public void voegToe(String woord){
		if(woord == null) throw new DomainException("Woord mag niet null zijn.");
		if(woord.trim().isEmpty()) throw new DomainException("Woord mag niet leeg zijn.");
		if(woorden.contains(woord)) throw new DomainException("Woord bestaat al.");
		woorden.add(woord);
	}
	
	public int getAantalWoorden(){
		return woorden.size();
	}
	
	public String getRandomWoord(){
		if(getAantalWoorden() == 0) throw new DomainException("Woordenlijst is nog leeg.");
		Random random = new Random();
		return woorden.get(random.nextInt(getAantalWoorden()));
	}
	
}
