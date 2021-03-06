package domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CirkelTest {

	private int radius1;
	private int radius2;
	private Punt punt1;
	private Punt punt2;
	private Cirkel cirkel1;
	private Cirkel cirkel2;
	private int radius3;
	
	@Before
	public void setUp() throws Exception {
		radius1 = 10;
		radius2 = 6;
		radius3 = 1;
		punt1 = new Punt(2, 7);
		punt2 = new Punt(-5, 0);
		cirkel1 = new Cirkel(punt1, radius1);
		cirkel2 = new Cirkel(punt2, radius2);
	}

	

	@Test
	public void Cirkel_maakt_geldige_cirkel_aan_met_middelpunt_en_straal() {
		Cirkel cirkel = new Cirkel(punt1, radius1);
		
		assertEquals(radius1, cirkel.getRadius());
		assertEquals(punt1, cirkel.getMiddelpunt());
	}
	
	@Test(expected = DomainException.class)
	public void Cirkel_aanmaken_met_middelpunt_null_gooit_exception() {
		cirkel1 = new Cirkel(null, radius1);
	}
	
	@Test(expected = DomainException.class)
	public void Cirkel_aanmaken_met_straal_kleiner_dan_nul_gooit_exception() {
		cirkel1 = new Cirkel(punt1, -5);
	}
	
	@Test(expected = DomainException.class)
	public void Cirkel_aanmaken_met_straal_nul_gooit_exception() {
		cirkel1 = new Cirkel(punt1, 0);
	}
	
	@Test
	public void equals_geeft_true_als_zelfde_middelpunt_en_straal() {
		cirkel1 = new Cirkel(punt1, radius1); 
		cirkel2 = new Cirkel(punt1, radius1); 
		
		assertTrue(cirkel1.equals(cirkel2));
	}
	
	@Test
	public void equals_geeft_false_als_2de_cirkel_null_is() {
		assertFalse(cirkel1.equals(null));
	}
	
	@Test
	public void equals_geeft_false_als_straal_verschillend() {
		cirkel1 = new Cirkel(punt1, radius1); 
		cirkel2 = new Cirkel(punt1, radius2); 
		
		assertFalse(cirkel1.equals(cirkel2));
	}
	
	@Test
	public void equals_geeft_false_als_middelpunt_verschillend() {
		cirkel1 = new Cirkel(punt1, radius1); 
		cirkel2 = new Cirkel(punt2, radius1); 
		
		assertFalse(cirkel1.equals(cirkel2));
	}
	
	@Test
	public void omhullende_is_juist(){
		Cirkel cirkel = new Cirkel(punt1, radius3);
		
		assertEquals(cirkel.getOmhullende(), new Omhullende(new Punt(1, 6), 2, 2));
		
	}

}
