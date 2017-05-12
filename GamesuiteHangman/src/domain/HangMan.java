package domain;

public class HangMan {
	
	private Speler speler;
	private WoordenLijst woordenlijst;
	private TekenHangMan tekening;
	private HintWoord currentHintWoord;
	private GameStatus status;
	
	public HangMan(Speler speler, WoordenLijst woordenLijst){
		setSpeler(speler);
		setWoordenLijst(woordenLijst);
		tekening = new TekenHangMan();
		reset();
	}
	
	public void reset(){
		getTekening().reset();
		currentHintWoord = new HintWoord(woordenlijst.getRandomWoord());
		status = GameStatus.BEZIG;
	}
	
	public String getHint(){
		return currentHintWoord.toString();
	}
	
	private void setWoordenLijst(WoordenLijst lijst){
		if(lijst == null){
			throw new DomainException("WoordenLijst kan niet null zijn voor HangMan");
		}
		
		if(lijst.getAantalWoorden() == 0){
			throw new DomainException("WoordenLijst kan niet leeg zijn voor HangMan");
		}
		
		this.woordenlijst = lijst;
	}
	
	public Speler getSpeler(){
		return speler;
	}
	
	private void setSpeler(Speler speler){
		if(speler == null){
			throw new DomainException("Speler kan niet null zijn voor HangMan.");
		}
		
		this.speler = speler;
	}
	
	public TekenHangMan getTekening(){
		return tekening;
	}
	
	public boolean raad(char letter){
		boolean hit = currentHintWoord.raad(letter);
		
		if(hit){
			if(currentHintWoord.isGeraden()) status = GameStatus.GEWONNEN;
		} else {
			getTekening().zetVolgendeZichtbaar();
			if(getTekening().getAantalOnzichtbare() == 0) status = GameStatus.VERLOREN;
		}
		
		return hit;
	}
	
	public boolean isGameOver(){
		return status.equals(GameStatus.VERLOREN);
	}
	
	public boolean isGewonnen(){
		return status.equals(GameStatus.GEWONNEN);
	}

}
