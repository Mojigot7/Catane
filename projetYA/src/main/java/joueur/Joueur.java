package joueur;

import java.awt.Color;

import inventaire.*;
import plateau.Plateau;

public abstract class Joueur {
	protected int score = 2;
	protected String nom;
	protected Ressource ressource;
	protected Batiment batiment;
	protected Color couleur;
	// private developpement;
	
	public Joueur(String nom, Color couleur) {
		this.nom = nom;
		this.couleur = couleur;
	}
	
	public Batiment getBatiment() {
		return this.batiment;
	}
	
	public void setBatiment(Batiment b) {
		this.batiment = b;
	}
	
	public Ressource getRessource() {
		return this.ressource;
	}
	
	public void setRessource(Ressource r) {
		this.ressource = r;
	}
	
	public boolean possedeColonie() {
		this.batiment = Batiment.COLONIE;
		if(this.batiment.getQuantite() > 0) {
			return true;
		}
		return false;
	}
	
	public boolean possedeRoute() {
		this.batiment = Batiment.ROUTE;
		if(this.batiment.getQuantite() > 0) {
			return true;
		}
		return false;
	}
	
	public boolean possedeVille() {
		this.batiment = Batiment.VILLE;
		if(this.batiment.getQuantite() > 0) {
			return true;
		}
		return false;
	}
	
	public void utiliserColonie() {
		this.batiment = Batiment.COLONIE;
		this.batiment.setQuantite(this.batiment.getQuantite()-1);
	}
	
	public void utiliserRoute() {
		this.batiment = Batiment.ROUTE;
		this.batiment.setQuantite(this.batiment.getQuantite()-1);
	}
	
	public void utiliserVille() {
		this.batiment = Batiment.VILLE;
		this.batiment.setQuantite(this.batiment.getQuantite()-1);
	}
	
	public boolean peutAcheterColonie() {
		this.ressource = Ressource.ARGILE;
		if(this.ressource.getQuantite() < 1) {
			return false;
		}
		this.ressource = Ressource.BOIS;
		if(this.ressource.getQuantite() < 1) {
			return false;
		}
		this.ressource = Ressource.LAINE;
		if(this.ressource.getQuantite() < 1) {
			return false;
		}
		this.ressource = Ressource.BLE;
		if(this.ressource.getQuantite() < 1) {
			return false;
		}
		return true;
	}
	
	public boolean peutAcheterRoute() {
		this.ressource = Ressource.ARGILE;
		if(this.ressource.getQuantite() < 1) {
			return false;
		}
		this.ressource = Ressource.BOIS;
		if(this.ressource.getQuantite() < 1) {
			return false;
		}
		return true;
	}
	
	public boolean peutAcheterVille() {
		this.ressource = Ressource.MINERAI;
		if(this.ressource.getQuantite() < 3) {
			return false;
		}
		this.ressource = Ressource.BLE;
		if(this.ressource.getQuantite() < 2) {
			return false;
		}
		return true;
	}
	
	public void acheterColonie() {
		this.ressource = Ressource.ARGILE;
		this.ressource.setQuantite(this.ressource.getQuantite()-1);
		this.ressource = Ressource.BOIS;
		this.ressource.setQuantite(this.ressource.getQuantite()-1);
		this.ressource = Ressource.LAINE;
		this.ressource.setQuantite(this.ressource.getQuantite()-1);
		this.ressource = Ressource.BLE;
		this.ressource.setQuantite(this.ressource.getQuantite()-1);
		this.batiment = Batiment.COLONIE;
		this.batiment.setQuantite(this.batiment.getQuantite()+1);
	}
	
	public void acheterRoute() {
		this.ressource = Ressource.ARGILE;
		this.ressource.setQuantite(this.ressource.getQuantite()-1);
		this.ressource = Ressource.BOIS;
		this.ressource.setQuantite(this.ressource.getQuantite()-1);
		this.batiment = Batiment.ROUTE;
		this.batiment.setQuantite(this.batiment.getQuantite()+1);
	}
	
	public void acheterVille() {
		this.ressource = Ressource.MINERAI;
		this.ressource.setQuantite(this.ressource.getQuantite()-3);
		this.ressource = Ressource.BLE;
		this.ressource.setQuantite(this.ressource.getQuantite()-2);
		this.batiment = Batiment.VILLE;
		this.batiment.setQuantite(this.batiment.getQuantite()+1);
	}
	
	public abstract void poserRoute(Plateau p);
	public abstract void poserColonie(Plateau p);
	public abstract void poserVille(Plateau p);

	public Color getCouleur() {
		return couleur;
	}
}
