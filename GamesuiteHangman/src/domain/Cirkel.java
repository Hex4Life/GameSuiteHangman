package domain;

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
		if (radius <= 0){
			throw new DomainException("Straal mag niet negatief zijn");
		}
		this.radius = radius;
	}

	// Functies
	
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
	
	public String toString() {
		return "Cirkel: middelpunt: " + this.getMiddelpunt().toString() +" - straal: " + this.getRadius(); 
	}	
}
