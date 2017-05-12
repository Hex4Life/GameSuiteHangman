package ui;

import domain.HangMan;
import domain.Speler;
import domain.WoordenLijst;

public class HangmanUi {
	
	private Speler speler;
	private WoordenLijst woordenlijst;
	//private HintWoord hintwoord = new HintWoord("hint woord");
	
	public HangmanUi(Speler speler, WoordenLijst woordenlijst){
		this.speler = speler;
		this.woordenlijst = woordenlijst;
	}
	
	public void showMenu() {
		HangMan spel = new HangMan(speler, woordenlijst);
		HangmanPaneel paneel = new HangmanPaneel(spel);
		HangManHoofdScherm scherm = new HangManHoofdScherm(spel, paneel);
		scherm.start();
	}

}
