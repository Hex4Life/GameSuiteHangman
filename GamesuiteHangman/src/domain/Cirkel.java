package domain;

import java.awt.Graphics;

public class Cirkel extends Vorm{
	
	private Punt middelpunt;
	private int radius;
	
	public Cirkel(Punt middelpunt, int radius) {
		
		setMiddelpunt(middelpunt);
		setRadius(radius);
	}
	
	// Getters
	
	public Punt getMiddelpunt() {
		return middelpunt;
	}

	public int getRadius() {
		return radius;
	}

	// Setters
	
	public void setMiddelpunt(Punt middelpunt) {
		if(middelpunt == null){
			throw new DomainException("middelpunt mag niet null zijn.");
		}
		this.middelpunt = middelpunt;
	}

	public void setRadius(int radius) {
		if (!isValidRadius(radius)){
			throw new DomainException("Straal mag niet negatief zijn");
		}
		this.radius = radius;
	}
	public static boolean isValidRadius(int radius){
		return radius >0;
	}

	// Functies
	@Override
	public void teken(Graphics g){
		Omhullende omh = getOmhullende();
		g.drawOval(omh.getMinimumX(), omh.getMinimumY(), omh.getBreedte(), omh.getHoogte());

	}
	@Override
	public boolean equals(Object o) {
		if(o == null){
			return false;
		}
		
		if(o instanceof Cirkel){
			Cirkel cirkel = (Cirkel) o;
			
			return this.getMiddelpunt().equals(cirkel.getMiddelpunt()) && this.getRadius() == cirkel.getRadius();
		}
		
		return false;
	}
	@Override
	public String toString() {
		return "Cirkel: middelpunt: " + this.getMiddelpunt().toString() +" - straal: " + this.getRadius() 
		+ "Omhullende: " + this.getOmhullende().toString() +" - "+ this.getRadius()*2 +" - " + this.getRadius()*2; 
	}

	@Override
	public Omhullende getOmhullende() {
		
		int radius = this.getRadius();
		int x = this.getMiddelpunt().getX();
		int y = this.getMiddelpunt().getY();
		
		
		int linkerBovenHoekX = x - radius;
		int linkerBovenHoekY = y - radius;
		
		Punt linkerBovenHoek = new Punt(linkerBovenHoekX,linkerBovenHoekY);
		
		Omhullende omhullende = new Omhullende(linkerBovenHoek, radius*2, radius*2);
		
		
		return omhullende;
		
		
	
	}	
	
	
	
	
}
