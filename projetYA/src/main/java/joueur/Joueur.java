package joueur;

import inventaire.*;
import plateau.Plateau;

public abstract class Joueur {
	private int score = 2;
	private String nom;
	private Ressource ressource;
	private Batiment batiment;
	// private developpement;
	
	public Joueur(String nom) {
		this.nom = nom;
	}
	
	public abstract void poserRoute(Plateau p);
	public abstract void poserColonie(Plateau p);
	public abstract void poserVille(Plateau p);
}
