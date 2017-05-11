package ui;

import javax.swing.JOptionPane;

import domain.HintWoord;
import domain.Speler;

public class HangmanUi {
	
	private Speler speler;
	
	private HintWoord hintwoord = new HintWoord("hint woord");
	
	public HangmanUi(Speler speler){
		this.speler = speler;
	}
	
	public void showMenu() {
		int i = 0;
		String bericht = "";
		
		while (!hintwoord.isGeraden() && i < 10) { // i = max aantal kansen
			char letter = JOptionPane.showInputDialog(null, bericht + "\nRarara, welk woord zoeken we\n"
															+ hintwoord.toString() + "\n"
															+ "Geef een letter:", "Hangman - " + speler.getNaam(), JOptionPane.QUESTION_MESSAGE).charAt(0);	
			
			if (hintwoord.raad(letter)) {
				bericht = "Super, doe zo voort!";
			}
			else {
				bericht = "Helaas, volgende keer beter!";
				i++;
			}
		}
		
		if (hintwoord.isGeraden()) {
			JOptionPane.showMessageDialog(null, "Proficiat, u hebt het woord geraden. Het woord was: " + hintwoord.getWoord());
		}
		else {
			JOptionPane.showMessageDialog(null, "Jammer, u hebt het woord niet geraden. Het woord was: " + hintwoord.getWoord());
		}
	}

}
