package domain;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Tekening implements Drawable {

	private String naam;
	private List<Vorm> vormen;
	public static final int MIN_X = 0;
	public static final int MIN_Y = 0;
	public static final int MAX_X = 399;
	public static final int MAX_Y = 399;
	
	public Tekening(String naam) {
		setNaam(naam);
		vormen = new ArrayList<Vorm>();
	}
	
	public static boolean isValidNaam(String naam){
		return naam != null && !naam.trim().isEmpty();
	}
	
	private void setNaam(String naam) {
		if (!isValidNaam(naam)) {
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
		
		getVormen().add(vorm);
	}
	
	public Vorm getVorm(int index) {
		return getVormen().get(index);
	}
	
	public void verwijder(Vorm vorm) {
		getVormen().remove(vorm);
	}
	
	public boolean bevat(Vorm vorm) {
		return getVormen().contains(vorm);
	}

	public int getAantalVormen() {
		return getVormen().size();
	}
	public List<Vorm> getVormen(){
		return vormen;
	}
	
	@Override
	public void teken(Graphics g){
		for(Vorm vorm : getVormen()){
			vorm.teken(g);
		}
	}
	
	@Override
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
