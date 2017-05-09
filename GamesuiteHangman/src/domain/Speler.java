package domain;

public class Speler {
	private String naam;
	private int score;
	
	public Speler(String naam){
		setNaam(naam);
		setScore(0);
	}
	
	public Speler(String naam, int score){
		setNaam(naam);
		setScore(score);
	}

	private void setNaam(String naam) {
		if(naam== null || naam.trim().isEmpty()) throw new DomainException("naam mag niet leeg zijn");
		this.naam = naam;
	}

	private void setScore(int score) {
		if(score < 0) throw new DomainException("score moet positief zijn.");
		this.score = score;
	}

	public String getNaam() {
		return naam;
	}

	public int getScore() {
		return score;
	}
	
	public int addToScore(int score){
		this.setScore(this.getScore()+score);
		return this.getScore();
		
	}
	
	@Override
	public boolean equals(Object o){
		if(o instanceof Speler){
			Speler s = (Speler)o;
			
			return s.getNaam().equals(this.getNaam()) && s.getScore() == this.getScore();
		}
		
		return false;
	}
	
	@Override
	public String toString(){
		return "Naam: " + this.getNaam() + " Score: "+this.getScore();
	}

}
