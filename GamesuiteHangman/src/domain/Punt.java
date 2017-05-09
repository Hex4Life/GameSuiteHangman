package domain;

public class Punt {
	
	private int x;
	private int y;
	
	public Punt(int x, int y) {
		setX(x);
		setY(y);
	}

	public int getX() {
		return x;
	}

	private void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	private void setY(int y) {
		this.y = y;
	}
	
	public boolean equals(Object o){
		if(o instanceof Punt){
			Punt punt = (Punt)o;
			
			return this.getX() == punt.getX() && this.getY() == punt.getY(); 
		}
		
		return false;
	}
	
	public String toString(){
		return "(" + getX() + ", " + getY() + ")";
	}
	
}
