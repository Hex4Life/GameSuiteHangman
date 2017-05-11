package ui;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;

import domain.Tekening;

public class TekenVenster extends Canvas {

	private static final long serialVersionUID = 1L;
	private Tekening tekening = null;

	public TekenVenster(Tekening tekening) {
		this.setPreferredSize(new Dimension(400, 400));
		setTekening(tekening);
	}

	private void setTekening(Tekening tekening) {
		if (tekening == null)
			throw new UiException("Tekening mag niet null zijn");
		this.tekening = tekening;
	}

	public void teken() {
		repaint();
	}

	@Override
	public void paint(Graphics graphics) {
		tekening.teken(graphics);
	}
}