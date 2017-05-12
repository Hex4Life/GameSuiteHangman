package domain;

import java.awt.Graphics;

public class LijnStuk extends Vorm{
	private Punt start;
	private Punt eind;
	
	public LijnStuk(Punt start, Punt eind){
		setStartEnEindPunt(start, eind);
	}
	
	public void setStartEnEindPunt(Punt start, Punt eind){
		if (start == null || eind == null)throw new DomainException("start en eind mogen niet null zijn");
		if (start.equals(eind)) throw new DomainException("begin en eind punt mogen niet hetzelfde zijn");
		this.eind = eind;
		this.start = start;
	}

	public Punt getStartPunt() {
		return start;
	}

	public Punt getEindPunt() {
		return eind;
	}
	
	@Override
	public void teken(Graphics g){
		if(isZichtbaar()){
			g.drawLine(getStartPunt().getX(), getStartPunt().getY(), getEindPunt().getX(), getEindPunt().getY());			
		}
	}

	@Override
	public boolean equals(Object o){
		if(o instanceof LijnStuk){
			LijnStuk lijnstuk = (LijnStuk)o;
			
			return (this.getStartPunt().equals(lijnstuk.getStartPunt()) && this.getEindPunt().equals(lijnstuk.getEindPunt()))
					|| (this.getEindPunt().equals(lijnstuk.getStartPunt()) && this.getStartPunt().equals(lijnstuk.getEindPunt())); 
		}
		return false;
	}

	@Override
	public String toString(){
		return "Lijn: startpunt: " + start + " - eindpunt: " + eind + "\n" + super.toString();
	}

	@Override
	public Omhullende getOmhullende() {
		Punt start = this.getStartPunt();
		Punt eind = this.getEindPunt();
		
		int startX = start.getX();
		int startY = start.getY();
		
		int eindX = eind.getX();
		int eindY = eind.getY();
		
		//int hoogte = 
		
		//Punt linkerBovenHoek = new Punt();
		
		if(startX < eindX){
			if(startY < eindY){
				Punt linkerBovenHoek = new Punt(startX, startY);
				int hoogte = eindY - startY;
				int breedte = eindX - startX;
				
				Omhullende omhullende = new Omhullende(linkerBovenHoek, breedte, hoogte);
				return omhullende;

			}
			
			//startY > eeindY
			else{ 
				Punt linkerBovenHoek = new Punt(eindX - startX , eindY);
				int hoogte = startY - eindY;
				int breedte = eindX - startX;
				
				
				Omhullende omhullende = new Omhullende(linkerBovenHoek, breedte, hoogte);
				return omhullende;

			}
		}
		
		//startX > eindX
		else{
			if(startY > eindY){
				Punt linkerBovenHoek = new Punt(eindX, eindY);
				
				int hoogte = startY-eindY;
				int breedte = startX-eindX;
				
				Omhullende omhullende = new Omhullende(linkerBovenHoek, breedte, hoogte);
				return omhullende;

			}
			else{
				
				Punt linkerBovenHoek = new Punt(startX -eindX, startY);
				
				int hoogte = eindY - startY;
				int breedte = startX-eindX;
			
				
				Omhullende omhullende = new Omhullende(linkerBovenHoek, breedte, hoogte);
				return omhullende;

				
			}
			
		}
	
			}
	
}
