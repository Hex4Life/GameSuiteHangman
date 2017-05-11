package domain;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Driehoek extends Vorm {

	private Punt hoekPunt1;
	private Punt hoekPunt2;
	private Punt hoekPunt3;

	public Driehoek(Punt hoekPunt1, Punt hoekPunt2, Punt hoekPunt3) {
		setHoekPunten(hoekPunt1, hoekPunt2, hoekPunt3);
	}

	public void setHoekPunten(Punt hoekPunt1, Punt hoekPunt2, Punt hoekPunt3) {
		if (hoekPunt1 == null || hoekPunt2 == null || hoekPunt3 == null) {
			throw new DomainException("Hoekpunt mag niet null zijn");
		}
		if (((hoekPunt2.getX() - hoekPunt1.getX())
				* (hoekPunt3.getY() - hoekPunt1.getY())) == ((hoekPunt3.getX() - hoekPunt1.getX())
						* (hoekPunt2.getY() - hoekPunt1.getY()))) {
			throw new DomainException("Hoekpunten mogen niet op 1 rechte liggen.");

		}
		this.hoekPunt1 = hoekPunt1;
		this.hoekPunt2 = hoekPunt2;
		this.hoekPunt3 = hoekPunt3;
	}

	public Punt getHoekPunt1() {
		return hoekPunt1;
	}

	public Punt getHoekPunt2() {
		return hoekPunt2;
	}

	public Punt getHoekPunt3() {
		return hoekPunt3;
	}

	@Override
	public void teken(Graphics g) {
		int[] xPoints = { getHoekPunt1().getX(), getHoekPunt2().getX(), getHoekPunt3().getX() };
		int[] yPoints = { getHoekPunt1().getY(), getHoekPunt2().getY(), getHoekPunt3().getY() };
		g.drawPolygon(xPoints, yPoints, 3);

	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Driehoek) {
			Driehoek driehoek = (Driehoek) o;
			List<Punt> lijsthoekpunten1 = new ArrayList<>();
			List<Punt> lijsthoekpunten2 = new ArrayList<>();
			lijsthoekpunten1.add(hoekPunt1);
			lijsthoekpunten1.add(hoekPunt2);
			lijsthoekpunten1.add(hoekPunt3);

			lijsthoekpunten2.add(driehoek.getHoekPunt1());
			lijsthoekpunten2.add(driehoek.getHoekPunt2());
			lijsthoekpunten2.add(driehoek.getHoekPunt3());

			if (lijsthoekpunten1.containsAll(lijsthoekpunten2) && lijsthoekpunten2.containsAll(lijsthoekpunten1)) {
				return true;
			}

		}

		return false;
	}

	@Override
	public String toString() {
		return "Driehoek: hoekpunt1: " + this.hoekPunt1.toString() + " - hoekpunt2: " + this.hoekPunt2.toString()
				+ " hoekpunt3: " + this.hoekPunt3.toString();
	}

	@Override
	public Omhullende getOmhullende() {

		int linksX = 0;
		int rechtsX = 0;
		int bovenY = 0;
		int onderY = 0;

		int hoekPunt1X = hoekPunt1.getX();
		int hoekPunt1Y = hoekPunt1.getY();

		int hoekPunt2X = hoekPunt2.getX();
		int hoekPunt2Y = hoekPunt2.getY();

		int hoekPunt3X = hoekPunt3.getX();
		int hoekPunt3Y = hoekPunt3.getY();
		/////////////////////////////////////////////////
		if (hoekPunt1X <= hoekPunt2X) {
			if (hoekPunt1X <= hoekPunt3X) {
				linksX = hoekPunt1X;
			} else {
				linksX = hoekPunt3X;

			}

		}

		else if (hoekPunt2X <= hoekPunt3X ) {
			linksX = hoekPunt2X;
		} else {
			linksX = hoekPunt3X;
		}

		///////////////////////////////////////////////
		if (hoekPunt1X >= hoekPunt2X) {
			if (hoekPunt1X >= hoekPunt3X) {
				rechtsX = hoekPunt1X;
			} else {
				rechtsX = hoekPunt3X;

			}

		}

		else if (hoekPunt2X >= hoekPunt3X) {
			rechtsX = hoekPunt2X;
		} else {
			rechtsX = hoekPunt3X;
		}

		///////////////////////////////////////
		if (hoekPunt1Y >= hoekPunt2Y) {
			if (hoekPunt1Y >= hoekPunt3Y) {
				onderY = hoekPunt1Y;
			} else {
				onderY = hoekPunt3Y;

			}

		}

		else if (hoekPunt2Y >= hoekPunt3Y) {
			onderY = hoekPunt2Y;
		} else {
			onderY = hoekPunt3Y;
		}

		////////////////////////////////

		if (hoekPunt1Y <= hoekPunt2Y) {
			if (hoekPunt1Y <= hoekPunt3Y) {
				bovenY = hoekPunt1Y;
			} else {
				bovenY = hoekPunt3Y;

			}

		}

		else if (hoekPunt2Y <= hoekPunt3Y) {
			bovenY = hoekPunt2Y;
		} else {
			bovenY = hoekPunt3Y;
		}

		Punt linkerBovenHoek = new Punt(linksX, bovenY);
		int breedte = rechtsX - linksX;
		int hoogte = onderY - bovenY;

		Omhullende omhullende = new Omhullende(linkerBovenHoek, breedte, hoogte);

		return omhullende;

	}

}
