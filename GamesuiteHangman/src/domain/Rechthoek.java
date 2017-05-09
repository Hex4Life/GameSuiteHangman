package domain;

public class Rechthoek {
	private int breedte, hoogte;
	private Punt linkerBovenhoek;
	
	public Rechthoek(Punt LinkerBovenhoek, int breedte, int hoogte){
		setBreedte(breedte);
		setHoogte(hoogte);
		this.linkerBovenhoek = LinkerBovenhoek;
	}

	public int getBreedte() {
		return breedte;
	}

	public int getHoogte() {
		return hoogte;
	}

	private void setBreedte(int breedte) {
		if (breedte < 0) throw new DomainException("De breedte mag niet negatief zijn.");
		this.breedte = breedte;
	}

	private void setHoogte(int hoogte) {
		if (hoogte <  0) throw new DomainException("De hoogte mag niet negatief zijn.");
		this.hoogte = hoogte;
	}
	
}
