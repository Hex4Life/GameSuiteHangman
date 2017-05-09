package ui;

import javax.swing.JOptionPane;

import domain.Cirkel;
import domain.DomainException;
import domain.Punt;
import domain.Rechthoek;
import domain.Speler;

public class PictionaryUi {

	private Speler speler;
	private Object[] shapes = {"Cirkel", "Driehoek", "Lijnstuk", "Rechthoek"};
	
	public PictionaryUi(Speler speler){
		this.speler = speler;
	}
	
	public void showMenu(){
		Object keuze = JOptionPane.showInputDialog(null, "Wat wilt u tekenen", "input", JOptionPane.INFORMATION_MESSAGE, null, shapes, null);
		
		if(keuze.equals("Cirkel")){
			Cirkel cirkel = inputCirkel();
			if(cirkel == null) return;
			JOptionPane.showMessageDialog(null, "U heeft een correcte cirkel aangemaakt: " + cirkel, speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
		} else if(keuze.equals("Rechthoek")){
			Rechthoek rechthoek = inputRechthoek();
			if(rechthoek == null) return;
			JOptionPane.showMessageDialog(null, "U heeft een correcte rechthoek aangemaakt: " + rechthoek, speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public Rechthoek inputRechthoek(){
		Rechthoek rechthoek = null;
		
		while(rechthoek == null){
			try{
				Punt linkerbovenhoek = inputPunt();
				if(linkerbovenhoek == null) return null;
				
				String breedte = inputNumber("Breedte van de rechthoek:");
				if(breedte == null) return null;
				
				String hoogte = inputNumber("Hoogte van de rechthoek:");
				if(hoogte == null) return null;
				
				rechthoek = new Rechthoek(linkerbovenhoek, Integer.parseInt(breedte), Integer.parseInt(hoogte));
			} catch (DomainException e){
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
		
		return rechthoek;
	}
	
	public Cirkel inputCirkel(){
		Cirkel cirkel = null;
		
		while(cirkel == null){
			try{
				Punt middelpunt = inputPunt();
				if(middelpunt == null) return null;
				
				String input = inputNumber("Radius van de cirkel:");
				if(input == null) return null;
				cirkel = new Cirkel(middelpunt, Integer.parseInt(input));			
			} catch (DomainException e){
				JOptionPane.showMessageDialog(null, e.getMessage());
			}			
		}
		
		return cirkel;
	}
	
	public Punt inputPunt(){
		String input1 = inputNumber("x coordinaat van het punt:");
		String input2 = inputNumber("y coordinaat van het punt:");
		
		return new Punt(Integer.parseInt(input1), Integer.parseInt(input2));
	}
	
	public String inputNumber(String msg){
		String input;
		do {
			input = JOptionPane.showInputDialog(msg);
			if(input == null) return null;
		} while(!isValidNumber(input));
		
		return input;
	}
	
	public boolean isValidNumber(String text){
		try{
			Integer.parseInt(text);
		} catch (NumberFormatException e){
			return false;
		}
		return true;
	}
}
