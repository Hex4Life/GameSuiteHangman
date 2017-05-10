package domain;

import java.util.ArrayList;
import java.util.List;

public class Tekening {

	private String naam;
	private List<Vorm> vormen;
	private static final int MIN_X = 0;
	private static final int MIN_Y = 0;
	private static final int MAX_X = 399;
	private static final int MAX_Y = 399;
	
	public Tekening(String naam) {
		setNaam(naam);
		vormen = new ArrayList<Vorm>();
	}
	
	private void setNaam(String naam) {
		if (naam == null || naam.trim().isEmpty()) {
			throw new IllegalArgumentException("Naam mag niet leeg zijn");
		}
		this.naam = naam;
	}
	
	public String getNaam() {
		return this.naam;
	}
	
	public void voegToe(Vorm vorm) {
		
		if (vorm == null) throw new DomainException("Vorm mag niet leeg zijn");
		if (bevat(vorm)) throw new DomainException("Tekening bevat vorm al");
		Omhullende o = vorm.getOmhullende();
		if (o.getMinimumX() < MIN_X ||
				o.getMaximumX() > MAX_X ||
				o.getMinimumY()< MIN_Y ||
				o.getMaximumY() > MAX_Y) throw new DomainException("de figuur mag niet buiten de tekening liggen");
		
		vormen.add(vorm);
	}
	
	public Vorm getVorm(int index) {
		return vormen.get(index);
	}
	
	public void verwijder(Vorm vorm) {
		vormen.remove(vorm);
	}
	
	public boolean bevat(Vorm vorm) {
		return vormen.contains(vorm);
	}

	public int getAantalVormen() {
		return vormen.size();
	}

	public String toString() {
		String res = "Tekening met naam " + getNaam() + " bestaat uit " + getAantalVormen() + " vormen:\n";
		for (Vorm vorm: vormen) {
			res += vorm + "\n";
		}
		return res;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Tekening) {
			Tekening tekening = (Tekening) o;
			if (tekening.getAantalVormen() != this.getAantalVormen()) {
				return false;
			}
			
			for (Vorm vorm: vormen) {
				if (!tekening.bevat(vorm)) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	
}
