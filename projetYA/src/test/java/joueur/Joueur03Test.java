package joueur;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import plateau.Plateau;

class Joueur03Test {

	@Test
	void jetterSesRessources() {
		Joueur j1 = new Humain("Billy", Color.RED);
		j1.inventaire.getRessource().replace("BOIS", 4);
		j1.inventaire.getRessource().replace("ARGILE", 5);
		((Humain)j1).voirInventaire();
		j1.jeterSesRessources();
		((Humain)j1).voirInventaire();
	}
	
	@Test
	void deplacerVoleur() {
		Plateau p = new Plateau();
		Joueur j = new Humain("Jean",Color.BLUE);
		p.affiche();
		j.deplacerVoleur(p);
		p.affiche();
	}

}