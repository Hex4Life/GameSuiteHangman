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
		
//		int i = 0;
//		String bericht = "";
//		
//		while (!hintwoord.isGeraden() && i < 10) { // i = max aantal kansen
//			char letter = JOptionPane.showInputDialog(null, bericht + "\nRarara, welk woord zoeken we\n"
//															+ hintwoord.toString() + "\n"
//															+ "Geef een letter:", "Hangman - " + speler.getNaam(), JOptionPane.QUESTION_MESSAGE).charAt(0);	
//			
//			if (hintwoord.raad(letter)) {
//				bericht = "Super, doe zo voort!";
//			}
//			else {
//				bericht = "Helaas, volgende keer beter!";
//				i++;
//			}
//		}
//		
//		if (hintwoord.isGeraden()) {
//			JOptionPane.showMessageDialog(null, "Proficiat, u hebt het woord geraden. Het woord was: " + hintwoord.getWoord());
//		}
//		else {
//			JOptionPane.showMessageDialog(null, "Jammer, u hebt het woord niet geraden. Het woord was: " + hintwoord.getWoord());
//		}
	}

}
