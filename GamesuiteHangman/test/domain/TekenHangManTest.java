package domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TekenHangManTest {

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void Afbeelding_Hangman_maakt_een_hangman_afbeelding_met_de_naam_hangman_en_18_vormen_waarvan_14_onzichtbaar() {
		TekenHangMan tekening1 = new TekenHangMan();
		assertEquals(14, tekening1.getAantalOnzichtbare());
	}

	@Test
	public void zetVolgendeZichtbaar_moet_eerste_onzichtbare_vorm_zichtbaar_zetten() {
		TekenHangMan tekening1 = new TekenHangMan();
		assertEquals(14, tekening1.getAantalOnzichtbare());
		tekening1.zetVolgendeZichtbaar();
		assertEquals(13, tekening1.getAantalOnzichtbare());
	}

	@Test(expected=DomainException.class)
	public void zetVolgendeZichtbaar_moet_exception_gooien_als_alle_vormen_zichtbaar() {
		TekenHangMan tekening1 = new TekenHangMan();
		assertEquals(14, tekening1.getAantalOnzichtbare());
		for(int i=0; i<15; i++){
			tekening1.zetVolgendeZichtbaar();
		}
	}

	@Test
	public void reset_moet_alle_vormen_behalve_galg_weer_onzichtbaar_zetten() {
		TekenHangMan tekening1 = new TekenHangMan();
		assertEquals(14, tekening1.getAantalOnzichtbare());
		tekening1.zetVolgendeZichtbaar();
		assertEquals(13, tekening1.getAantalOnzichtbare());
		tekening1.reset();
		assertEquals(14, tekening1.getAantalOnzichtbare());
	}

	@Test(expected=DomainException.class)
	public void voegToe_moet_een_exception_gooien() {
		new TekenHangMan().voegToe(new Rechthoek(new Punt(5, 10), 2, 8));
	}

	@Test(expected=DomainException.class)
	public void verwijder_moet_een_exception_gooien() {
		new TekenHangMan().verwijder(new Rechthoek(new Punt(5, 10), 2, 8));
	}

}
