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
		g.drawLine(getStartPunt().getX(), getStartPunt().getY(), getEindPunt().getX(), getEindPunt().getY());
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
		return "Lijn: startpunt: " + start + " - eindpunt: " + eind;
	}
}
