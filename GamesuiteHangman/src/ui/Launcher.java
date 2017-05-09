package ui;

import javax.swing.JOptionPane;

import domain.Punt;
import domain.Speler;

public class Launcher {

	public static void main(String[] args) {
		String naam = JOptionPane.showInputDialog("Welkom! \nHoe heet je?");
		Speler speler = new Speler(naam);
		JOptionPane.showMessageDialog(null, "... heeft als score: " + speler.getScore());
		JOptionPane.showMessageDialog(null, "... zal binnekort spelen", speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
		
		int xcoor;
		xcoor = Integer.parseInt(JOptionPane.showInputDialog("x coordinaat van het punt: "));
		int ycoor;
		ycoor = Integer.parseInt(JOptionPane.showInputDialog("y coordinaat van het punt: "));
		Punt punt1 = new Punt(xcoor, ycoor);
		JOptionPane.showMessageDialog(null, "U heeft een correct punt aangemaakt: " + punt1);
	}
	

}
