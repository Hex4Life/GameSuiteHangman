package db;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import domain.WoordenLijst;

public class WoordenLezer {
	
	
	private String bestandsNaam;
	
	public WoordenLezer(String bestandsNaam){
		if(bestandsNaam == null || bestandsNaam.trim().isEmpty()){
			throw new DbException("geen geldige bestandsnaam");
		}
		
		this.bestandsNaam = bestandsNaam;
	}
	
	public WoordenLijst lees(){
		Scanner sc = null;
		
		try {
			sc = new Scanner(new File(bestandsNaam));
		} catch (FileNotFoundException e){
			throw new DbException("Het bestand " + bestandsNaam + " kan niet gevonden worden.");
		}
		
		WoordenLijst lijst = new WoordenLijst();
		
		while(sc.hasNext()){
			lijst.voegToe(sc.nextLine());
		}
		
		sc.close();
		
		return lijst;
	}

}
