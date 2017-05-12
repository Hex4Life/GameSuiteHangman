package ui;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import domain.HangMan;

public class HangmanPaneel extends JPanel {

	private static final long serialVersionUID = 1L;	
	
	private JTextField letter;	
	private JLabel woord;
	
	private TekenVenster tekenVenster;
	private HangMan spel;
	
	public HangmanPaneel(HangMan spel){
		super();
		setSpel(spel);
		init();
	}

	private void init(){
		letter = new JTextField("",5);
		woord = new JLabel("");
		
		this.setLayout(new BorderLayout());
		this.add(letter, BorderLayout.EAST);
		this.add(woord, BorderLayout.CENTER);
		
		letter.addKeyListener(new RaadLuisteraar());
	}
	
	private void reset() {
		woord.setText(getSpel().getHint());
		letter.setText("");
		getTekenVenster().teken();
	}
	
	public class RaadLuisteraar implements KeyListener {

		@Override
		public void keyPressed(KeyEvent arg0) {
			if(arg0.getKeyCode()== KeyEvent.VK_ENTER){
				handleInput();
			}
		}

		@Override
		public void keyReleased(KeyEvent arg0) {/* Niet nodig*/}
		@Override
		public void keyTyped(KeyEvent arg0) {/* Niet nodig*/}
	}
	
	private void handleInput(){
		char guess = extractChar(letter.getText());
		if(guess == '\u0000'){
			JOptionPane.showMessageDialog(null, "Ongeldig karakter", "error", JOptionPane.ERROR_MESSAGE);
			reset();
			return;
		}
		
		getSpel().raad(guess);
		
		reset();
		
		handleEndOfGame();
	}
	
	private char extractChar(String msg){
		if(!msg.matches("^[a-zA-Z]$")){
			return '\u0000';
		}
		
		return msg.charAt(0);
	}
	
	private void handleEndOfGame(){
		//toon boodschap als gewonnen of verloren en vraag of speler opnieuw wilt spelen
		//als de speler opnieuw wilt spelen: herzet het spel en het paneel
		//anders stop (System.exit(0))
		
		String msg = null;
		
		if(getSpel().isGameOver()) msg = "Jammer maar helaas!";
		if(getSpel().isGewonnen()) msg = "Joepi, gewonnen!";
		
		if(msg != null){
			String input = null;
			boolean running = true;
			
			while(running){
				input = JOptionPane.showInputDialog(msg + "\nNog een keer? (y/n)");
				
				if(input == null || input.equals("n")) System.exit(0);
				if(input.equals("y")){
					getSpel().reset();
					reset();
					running = false;
				}
			}
		}
	}
	
	private void setSpel(HangMan spel){
		this.spel = spel;
	}

	private HangMan getSpel() {
		return spel;
	}
	

	private TekenVenster getTekenVenster() {
		return tekenVenster;
	}

	 public void setTekenVenster(TekenVenster tekenVenster) {
		this.tekenVenster = tekenVenster;

		reset();
	}
}