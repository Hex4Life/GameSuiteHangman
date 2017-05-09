package domain;

public class LijnStuk extends Vorm{
	private Punt start;
	private Punt eind;
	
	public LijnStuk(Punt start, Punt eind){
		setStartEnEindPunt(start, eind);
	}
	
	public void setStartEnEindPunt(Punt start, Punt eind){
		if(start != null) this.start = start;
		else{throw new DomainException("Startpunt mag niet null zijn.");}
		
		if(eind != null) this.eind = eind;
		else{throw new DomainException("Eindpunt mag niet null zijn.");}
	}

	public Punt getStartPunt() {
		return start;
	}

	public Punt getEindPunt() {
		return eind;
	}

	@Override
	public boolean equals(Object o){
		if(o instanceof LijnStuk){
			LijnStuk lijnstuk = (LijnStuk)o;
			
			return this.getStartPunt().equals(lijnstuk.getStartPunt()) && this.getEindPunt().equals(lijnstuk.getEindPunt()); 
		}
		
		return false;
	}

	@Override
	public String toString(){
		return "Lijn: startpunt: " + start + " - eindpunt: " + eind;
	}
}
