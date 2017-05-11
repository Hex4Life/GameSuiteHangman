package domain;

import java.awt.Graphics;

public class Rechthoek extends Vorm{

	private int breedte, hoogte;
	private Punt linkerBovenhoek;
	
	public Rechthoek(Punt linkerBovenhoek, int breedte, int hoogte){
		setBreedte(breedte);
		setHoogte(hoogte);
		setLinkerBovenhoek(linkerBovenhoek);
	}

	public int getBreedte() {
		return breedte;
	}

	public int getHoogte() {
		return hoogte;
	}

	private void setBreedte(int breedte) {
		if (!isValidBreedte(breedte)) throw new DomainException("De breedte mag niet negatief zijn.");
		this.breedte = breedte;
	}

	private void setHoogte(int hoogte) {
		if (!isValidHoogte(hoogte)) throw new DomainException("De hoogte mag niet negatief zijn.");
		this.hoogte = hoogte;
	}
	
	public Punt getLinkerBovenhoek(){
		return linkerBovenhoek;
	}
	
	private void setLinkerBovenhoek(Punt linkerBovenhoek){
		if(linkerBovenhoek == null){
			throw new DomainException("Linkerbovenhoek van rechthoek mag niet null zijn.");
		}
		
		this.linkerBovenhoek = linkerBovenhoek;
	}
	public static boolean isValidBreedte(int breedte){
		return breedte > 0;
	}
	public static boolean isValidHoogte(int hoogte){
		return hoogte > 0;
	}
	
	@Override
	public void teken(Graphics g){
		Omhullende omh = getOmhullende();
		g.drawRect(omh.getMinimumX(), omh.getMinimumY(), omh.getBreedte(), omh.getHoogte());
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof Rechthoek){
			Rechthoek r = (Rechthoek)o;
			
			return r.getLinkerBovenhoek().equals(this.getLinkerBovenhoek())
					&& r.getBreedte() == this.getBreedte()
					&& r.getHoogte() == this.getHoogte();
		}
		
		return false;
	}
	
	@Override
	public String toString(){
		return "Rechthoek: positie: " + getLinkerBovenhoek() + " - breedte: " + getBreedte() + " - hoogte: " + getHoogte();
	}

	@Override
	public Omhullende getOmhullende() {
		Omhullende omhullende = new Omhullende(this.getLinkerBovenhoek(), this.getBreedte(), this.getHoogte());
		return omhullende;
	
	}
}
