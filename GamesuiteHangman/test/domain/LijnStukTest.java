package domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LijnStukTest {
	private Punt punt1 = new Punt(10, 20);
	private Punt zelfdeAlsPunt1 = new Punt(10, 20);
	private Punt punt2 = new Punt(190, 30);
	private Punt zelfdeAlsPunt2 = new Punt(190, 30);
	
	private Punt punt3 = new Punt(2,2);
	private Punt punt4 = new Punt(5,4);
	private Punt punt5 = new Punt(2,5);
	private Punt punt6 = new Punt(4,2);
	

	@Test
	public void LijnStuk_moet_lijnstuk_aanmaken_met_gegeven_startPunt_en_eindPunt() {
		LijnStuk lijnstuk = new LijnStuk(punt1, punt2);

		assertEquals(punt1, lijnstuk.getStartPunt());
		assertEquals(punt2, lijnstuk.getEindPunt());
	}
	
	@Test (expected = DomainException.class)
	public void LijnStuk_Moet_exception_gooien_als_startpunt_null()  {
		new LijnStuk(null, punt2);
	}
	
	@Test (expected = DomainException.class)
	public void LijnStuk_Moet_exception_gooien_als_eindpunt_null()  {
		new LijnStuk(punt1, null);
	}
	
	@Test
	public void equals_moet_true_teruggeven_als_begin_en_eindpunt_gelijk_zijn(){
		LijnStuk lijnStuk = new LijnStuk(punt1, punt2);
		LijnStuk zelfdeLijnStuk = new LijnStuk(zelfdeAlsPunt1, zelfdeAlsPunt2);
		assertTrue(lijnStuk.equals(zelfdeLijnStuk));
	}
	
	@Test
	public void equals_moet_false_teruggeven_als_parameter_null(){
		LijnStuk lijnStuk = new LijnStuk(punt1, punt2);
		assertFalse(lijnStuk.equals(null));
	}
	@Test
	public void equals_moet_true_teruggeven_als_omgekeert_lijnstuk_hetzelfde_is(){
		LijnStuk lijnstuk = new LijnStuk(punt1,punt2);
		LijnStuk lijnstuk2 = new LijnStuk(punt2, punt1);
		assertTrue(lijnstuk.equals(lijnstuk2));
	}
	@Test
	public void omhullende_is_juist_als_startpunt_is_linkerbovenhoek(){
		
		LijnStuk lijnstuk = new LijnStuk(punt3, punt4);
		
		assertTrue(punt3.equals(lijnstuk.getOmhullende().getLinkerBovenhoek()));
		
		
		
	}
	
	@Test
	public void omhullende_is_juist_als_startpunt_is_linkeronderhoek(){
		
		LijnStuk lijnstuk = new LijnStuk(punt5, punt6);
		
		assertTrue(punt3.equals(lijnstuk.getOmhullende().getLinkerBovenhoek()));
		
		
		
	}
	
	@Test
	public void omhullende_is_juist_als_startpunt_is_rechterbovenhoek(){
		
		LijnStuk lijnstuk = new LijnStuk(punt6, punt5);
		
		assertTrue(punt3.equals(lijnstuk.getOmhullende().getLinkerBovenhoek()));
		
		
		
	}
	
	@Test
	public void omhullende_is_juist_als_startpunt_is_rechteronderhoek(){
		
		LijnStuk lijnstuk = new LijnStuk(punt4, punt3);
		
		assertTrue(punt3.equals(lijnstuk.getOmhullende().getLinkerBovenhoek()));
		
		
		
	}
}
	
