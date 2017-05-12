package ui;

import javax.swing.JOptionPane;

import domain.Cirkel;
import domain.DomainException;
import domain.Driehoek;
import domain.LijnStuk;
import domain.Punt;
import domain.Rechthoek;
import domain.Speler;
import domain.Tekening;

public class PictionaryUi {

	private Speler speler;
	private Tekening tekening;
	private Object[] shapes = {"Cirkel", "Driehoek", "Lijnstuk", "Rechthoek"};
	private GameHoofdScherm scherm;
	
	public PictionaryUi(Speler speler){
		this.speler = speler;
	}
	
	public void showMenu(){
		String naam = inputNaamTekening();
		if(naam == null) return;
		tekening = new Tekening(naam);
		scherm = new GameHoofdScherm(speler.getNaam(), tekening);
		
		boolean running = true;
		
		while(running){
			String keuze = JOptionPane.showInputDialog("Wat wil je doen:\n\n1. Vorm maken\n2. Tekening tonen\n\n0. Stoppen");
			if(keuze == null) return;

			switch(keuze){
				case "0" : running = false; break;
				case "1" : vormMaken(); break;
				case "2" : toonTekening(); break;
				default : JOptionPane.showMessageDialog(null, "Ongeldige input");
			}
		}
	}
	
	public String inputNaamTekening(){
		String input = "";
		String errMsg = "";
		
		do{
			input = JOptionPane.showInputDialog(errMsg + "Geef de naam van de tekening:");
			if(input == null) return null;
			errMsg = "Geen geldige naam\n\n";
		} while(!Tekening.isValidNaam(input));
		
		return input;
	}
	
	private void toonTekening(){
		scherm.setVisible(true);
		scherm.teken();
	}
	
	public void vormMaken(){
		Object keuze = JOptionPane.showInputDialog(null, "Wat wilt u tekenen", "input", JOptionPane.INFORMATION_MESSAGE, null, shapes, null);
		
		if(keuze == null) return;
		try{
			if(keuze.equals("Cirkel")){
				Cirkel cirkel = inputCirkel();
				if(cirkel == null) return;
				tekening.voegToe(cirkel);
				JOptionPane.showMessageDialog(null, "U heeft een correcte cirkel aangemaakt:\n" + cirkel, speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
			} else if(keuze.equals("Rechthoek")){
				Rechthoek rechthoek = inputRechthoek();
				if(rechthoek == null) return;
				tekening.voegToe(rechthoek);
				JOptionPane.showMessageDialog(null, "U heeft een correcte rechthoek aangemaakt:\n" + rechthoek, speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
			} else if(keuze.equals("Driehoek")){
				Driehoek driehoek = inputDriehoek();
				if(driehoek == null) return;
				tekening.voegToe(driehoek);
				JOptionPane.showMessageDialog(null, "U heeft een correcte driehoek aangemaakt:\n" + driehoek, speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
			} else if(keuze.equals("Lijnstuk")){
				LijnStuk lijnstuk = inputLijnStuk();
				if(lijnstuk == null) return;
				tekening.voegToe(lijnstuk);
				JOptionPane.showMessageDialog(null, "U heeft een correct lijnstuk aangemaakt:\n" + lijnstuk, speler.getNaam(), JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (DomainException e) {JOptionPane.showMessageDialog(null, e.getMessage());}
	}
	
	public LijnStuk inputLijnStuk(){
		LijnStuk lijnstuk = null;
		
		while(lijnstuk == null){
			try{
				Punt punt1 = inputPunt("StartPunt van het lijnstuk:");
				if(punt1 == null) return null;
				
				Punt punt2 = inputPunt("EindPunt van het lijnstuk:");
				if(punt2 == null) return null;
				
				lijnstuk = new LijnStuk(punt1, punt2);
			} catch (DomainException e){
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
		
		return lijnstuk;
	}
	
	public Driehoek inputDriehoek(){
		Driehoek driehoek = null;
		
		while(driehoek == null){
			try{
				Punt hoek1 = inputPunt("Punt 1 van de driehoek:");
				if(hoek1 == null) return null;
				
				Punt hoek2 = inputPunt("Punt 2 van de driehoek:");
				if(hoek2 == null) return null;
				
				Punt hoek3 = inputPunt("Punt 3 van de driehoek:");
				if(hoek3 == null) return null;
				
				driehoek = new Driehoek(hoek1, hoek2, hoek3);
			} catch (DomainException e){
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
		
		return driehoek;
	}
	
	public Rechthoek inputRechthoek(){
		Punt linkerbovenhoek = inputPunt("Linkerboven hoek van de rechthoek:");
		if(linkerbovenhoek == null) return null;

		int breedte = 0;
		String errMsg = "";
		do{
			String input = inputNumber(errMsg + "Breedte van de rechthoek:");
			if(input == null) return null;
			breedte = Integer.parseInt(input);
			
			errMsg = "Ongeldige breedte voor rechthoek\n\n";
		} while(!Rechthoek.isValidBreedte(breedte));
		
		int hoogte = 0;
		errMsg = "";
		do{
			String input = inputNumber(errMsg + "Hoogte van de rechthoek:");
			if(input == null) return null;			
			hoogte = Integer.parseInt(input);
			
			errMsg = "Ongeldige hoogte voor rechthoek\n\n";
		} while(!Rechthoek.isValidHoogte(hoogte));
		
		
		return new Rechthoek(linkerbovenhoek, breedte, hoogte);
	}
	
	public Cirkel inputCirkel(){
		Punt middelpunt = inputPunt("Middelpunt van de cirkel:");
		if(middelpunt == null) return null;
		
		int radius = 0;
		String errMsg = "";
		do {
			String input = inputNumber(errMsg + "Radius van de cirkel:");
			if(input == null) return null;
			radius = Integer.parseInt(input);
			
			errMsg = "Ongeldige straal voor cirkel\n\n";
		} while(!Cirkel.isValidRadius(radius));
		
		return new Cirkel(middelpunt, radius);
	}
	
	public Punt inputPunt(String msg){
		String input1 = inputNumber(msg + "\nx coordinaat van het punt:");
		if(input1 == null) return null;
		String input2 = inputNumber(msg + "\ny coordinaat van het punt:");
		if(input2 == null) return null;
		
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
