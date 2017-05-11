package domain;

public class HangMan {
	
	private Speler speler;
	private TekenHangMan tekening;
	private WoordenLijst woordenlijst;
	private HintWoord currentHintWoord;
	private GameStatus status;
	
	public HangMan(Speler speler, WoordenLijst woordenLijst){
		this.speler = speler;
		this.woordenlijst = woordenLijst;
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
	
	public Speler getSpeler(){
		return speler;
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
