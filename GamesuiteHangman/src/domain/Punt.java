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
	
	public boolean equals(Punt punt){
		if(punt == null)return false;
		
		boolean resultX = false;
		boolean resultY = false;
		
		if(this.getX() == punt.getX()) resultX = true;
		if(this.getY() == punt.getY()) resultY = true;
		
		if(resultX && resultY) return true;
		return false;
	}

}
