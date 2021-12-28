package joueur;

import java.awt.Color;
import java.util.Map;

import inventaire.*;
import plateau.Plateau;

public abstract class Joueur {
	protected int score = 2;
	protected int cptChevalier = 0;
	protected String nom;
	protected Inventaire inventaire;
	protected Color couleur;
	// private developpement;
	
	public Joueur(String nom, Color couleur) {
		this.nom = nom;
		this.couleur = couleur;
		this.inventaire = new Inventaire();
	}
	
	public int getNbArgile() {
		return this.inventaire.getRessource().get("ARGILE");
	}
	
	public int getNbBois() {
		return this.inventaire.getRessource().get("BOIS");
	}
	
	public int getNbBle() {
		return this.inventaire.getRessource().get("BLE");
	}
	
	public int getNbLaine() {
		return this.inventaire.getRessource().get("LAINE");
	}
	
	public int getNbMinerai() {
		return this.inventaire.getRessource().get("MINERAI");
	}
	
	public int getNbColonie() {
		return this.inventaire.getBatiment().get("COLONIE");
	}
	
	public int getNbRoute() {
		return this.inventaire.getBatiment().get("ROUTE");
	}
	
	public int getNbVille() {
		return this.inventaire.getBatiment().get("VILLE");
	}
	
	public void voirInventaire() {
		System.out.println("Inventaire de "+this.nom+" :");
		for(Map.Entry<String, Integer> inv : this.inventaire.getBatiment().entrySet()) {
			System.out.println(inv.getKey()+" : "+inv.getValue());
		}
		for(Map.Entry<String, Integer> inv : this.inventaire.getRessource().entrySet()) {
			System.out.println(inv.getKey()+" : "+inv.getValue());
		}
	}
	
	public boolean possedeColonie() {
		if(this.inventaire.getBatiment().get("COLONIE") > 0) {
			return true;
		}
		return false;
	}
	
	public boolean possedeRoute() {
		if(this.inventaire.getBatiment().get("ROUTE") > 0) {
			return true;
		}
		return false;
	}
	
	public boolean possedeVille() {
		if(this.inventaire.getBatiment().get("VILLE") > 0) {
			return true;
		}
		return false;
	}
	
	public void utiliserColonie() {
		this.inventaire.getBatiment().replace("COLONIE", this.inventaire.getBatiment().get("COLONIE")-1);
	}
	
	public void utiliserRoute() {
		this.inventaire.getBatiment().replace("ROUTE", this.inventaire.getBatiment().get("ROUTE")-1);
	}
	
	public void utiliserVille() {
		this.inventaire.getBatiment().replace("VILLE", this.inventaire.getBatiment().get("VILLE")-1);
		this.inventaire.getBatiment().replace("COLONIE", this.inventaire.getBatiment().get("COLONIE")+1);
	}
	
	public boolean peutAcheterColonie() {
		if(this.inventaire.getRessource().get("ARGILE") < 1) {
			return false;
		}
		if(this.inventaire.getRessource().get("BOIS") < 1) {
			return false;
		}
		if(this.inventaire.getRessource().get("LAINE") < 1) {
			return false;
		}
		if(this.inventaire.getRessource().get("BLE") < 1) {
			return false;
		}
		return true;
	}
	
	public boolean peutAcheterRoute() {
		if(this.inventaire.getRessource().get("ARGILE") < 1) {
			return false;
		}
		if(this.inventaire.getRessource().get("BOIS") < 1) {
			return false;
		}
		return true;
	}
	
	public boolean peutAcheterVille() {
		if(this.inventaire.getRessource().get("MINERAI") < 3) {
			return false;
		}
		if(this.inventaire.getRessource().get("BLE") < 2) {
			return false;
		}
		return true;
	}
	
	public void acheterColonie() {
		this.inventaire.getBatiment().replace("COLONIE", this.inventaire.getBatiment().get("COLONIE")+1);
		this.inventaire.getRessource().replace("ARGILE", this.inventaire.getRessource().get("ARGILE")-1);
		this.inventaire.getRessource().replace("BOIS", this.inventaire.getRessource().get("BOIS")-1);
		this.inventaire.getRessource().replace("LAINE", this.inventaire.getRessource().get("LAINE")-1);
		this.inventaire.getRessource().replace("BLE", this.inventaire.getRessource().get("BLE")-1);
	}
	
	public void acheterRoute() {
		this.inventaire.getBatiment().replace("ROUTE", this.inventaire.getBatiment().get("ROUTE")+1);
		this.inventaire.getRessource().replace("ARGILE", this.inventaire.getRessource().get("ARGILE")-1);
		this.inventaire.getRessource().replace("BOIS", this.inventaire.getRessource().get("BOIS")-1);
	}
	
	public void acheterVille() {
		this.inventaire.getBatiment().replace("VILLE", this.inventaire.getBatiment().get("VILLE")+1);
		this.inventaire.getRessource().replace("MINERAI", this.inventaire.getRessource().get("MINERAI")-3);
		this.inventaire.getRessource().replace("BLE", this.inventaire.getRessource().get("BLE")-2);
	}
	
	public int sommeDesRessources() { // Pour l'implémentation du Voleur
		int somme = 0;
		for(Map.Entry<String, Integer> inv : this.inventaire.getRessource().entrySet()) {
			somme += inv.getValue();
		}
		return somme;
	}
	
	public void ressourceAleatoire(String typeDeRessource, boolean estVille) { // Compare le type de la tuile à la ressource associé. Donne 2 ressources pour les villes et 1 pour les colonies
		for(Map.Entry<String, Integer> inv : this.inventaire.getRessource().entrySet()) {
			if(inv.getKey().equals(typeDeRessource)) {
				if(estVille) {
					this.inventaire.getRessource().replace(inv.getKey(), this.inventaire.getRessource().get(inv.getKey())+2);
				}else {
					this.inventaire.getRessource().replace(inv.getKey(), this.inventaire.getRessource().get(inv.getKey())+1);
				}
				return;
			}
		}
	}
	
	public abstract void poserRoute(Plateau p);
	public abstract void poserColonie(Plateau p);
	public abstract void poserVille(Plateau p);

	public Color getCouleur() {
		return couleur;
	}
}
