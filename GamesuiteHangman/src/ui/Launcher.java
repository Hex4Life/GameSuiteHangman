package ui;

import javax.swing.JOptionPane;

import domain.Speler;

public class Launcher {

	private static final Object[] OPTIONS = {"HangMan", "Pictionary"};
	
	public static void main(String[] args) {
		String naam = inputNaamSpeler();
		if(naam == null) return;
		Speler speler = new Speler(naam);
		
		JOptionPane.showMessageDialog(null, "... heeft als score: " + speler.getScore());
		JOptionPane.showMessageDialog(null, "... zal binnekort spelen", speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
		
		Object keuze = JOptionPane.showInputDialog(null, "Dag " + naam + ", welk spel wil je spelen?", "Keuze spel", JOptionPane.QUESTION_MESSAGE, null, OPTIONS, null);
		
		if (keuze.equals("HangMan")) {
			HangmanUi ui = new HangmanUi(speler);
			ui.showMenu();
		}
		else if (keuze.equals("Pictionary")) {
			PictionaryUi ui = new PictionaryUi(speler);
			ui.showMenu();
		}
		
	}
	
	private static String inputNaamSpeler(){
		String input = "";
		String errMsg = "";
		
		do{
			input = JOptionPane.showInputDialog(errMsg + "Welkom! \nHoe heet je?");
			if(input == null) return null;
			errMsg = "Ongeldige naam\n\n";
		} while(input.trim().isEmpty());
			
		return input;
	}
}
