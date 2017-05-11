package domain;

public abstract class Vorm implements Drawable {

	public boolean zichtbaar;
	
	public Vorm(){
		setZichtbaar(true);
	}

	public abstract boolean equals(Object o);

	public abstract Omhullende getOmhullende();
	
	public boolean isZichtbaar(){
		return zichtbaar;
	}
	
	public void setZichtbaar(boolean zichtbaar){
		this.zichtbaar = zichtbaar;
	}
	
}
