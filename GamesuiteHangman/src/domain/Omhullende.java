package domain;

public class Omhullende {
	
	private Punt linkerBovenhoek;
	private int breedte;
	private int hoogte;

//Constructor
	public Omhullende(Punt linkerBovenhoek, int breedte, int hoogte){
		setLinkerBovenhoek(linkerBovenhoek);
		setBreedte(breedte);
		setHoogte(hoogte);
	}

//Basic getters and setters
	public Punt getLinkerBovenhoek() {
		return linkerBovenhoek;
	}

	public void setLinkerBovenhoek(Punt linkerBovenhoek) {
		if(linkerBovenhoek == null) throw new DomainException("LinkerBovenhoek mag niet null zijn.");
		this.linkerBovenhoek = linkerBovenhoek;
	}

	public int getBreedte() {
		return breedte;
	}

	public void setBreedte(int breedte) {
		if(breedte < 0) throw new DomainException("De breedte mag niet nul of negatief zin.");
		this.breedte = breedte;
	}
	
	public int getHoogte() {
		return hoogte;
	}

	public void setHoogte(int hoogte) {
		if(hoogte < 0) throw new DomainException("De hoogte mag niet nul of negatief zin.");
		this.hoogte = hoogte;
	}
	
//Getters Min & Max
	public int getMinimumX(){
		return linkerBovenhoek.getX();
	}
	
	public int getMinimumY(){
		return linkerBovenhoek.getY();
	}
	
	public int getMaximumX(){
		return linkerBovenhoek.getX() + breedte;
	}
	
	public int getMaximumY(){
		return linkerBovenhoek.getY() + hoogte;
	}
	
	//equals
	public boolean equals(Object o){
		if(o instanceof Omhullende){
			Omhullende omhullende = (Omhullende)o;
			
			return this.getLinkerBovenhoek().equals(omhullende.getLinkerBovenhoek()) && this.getBreedte() == omhullende.getBreedte() && this.getHoogte() == omhullende.getHoogte();
		}
		return false;
	}
	
	
	
}
