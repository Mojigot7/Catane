package inventaire;

import java.util.HashMap;

public class Inventaire {
	private HashMap<String,Integer> ressource;
	private HashMap<String,Integer> batiment;
	
	public Inventaire() {
		this.ressource = new HashMap<>(5);
		this.ressource.put("BOIS", 0);
		this.ressource.put("ARGILE", 0);
		this.ressource.put("LAINE", 0);
		this.ressource.put("MINERAI", 0);
		this.ressource.put("BLE", 0);
		this.batiment = new HashMap<>(3);
		this.batiment.put("ROUTE", 2);
		this.batiment.put("COLONIE", 2);
		this.batiment.put("VILLE", 0);
	}
	
	public HashMap<String,Integer> getRessource(){
		return this.ressource;
	}
	
	public HashMap<String,Integer> getBatiment(){
		return this.batiment;
	}
}
