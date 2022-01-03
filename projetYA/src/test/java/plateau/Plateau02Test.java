package plateau;

import static org.junit.jupiter.api.Assertions.*;



import java.awt.Color;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import colors.ConsoleColors;
import inventaire.Inventaire;
import joueur.Humain;
import joueur.Joueur;

class Plateau02Test {

	@Test
	void recolte() {
		Joueur j = new Humain("Mia", Color.RED);
		Plateau p = new Plateau();
		p.poserColonie(4, 4, j);
		p.recolte(10, j);
		assertEquals(1,j.getNbArgile());
		((Humain)j).voirInventaire();
	}
	
	@Test
	void recolte2() {
		ArrayList<Joueur> l = new ArrayList<Joueur>();
		Plateau p = new Plateau();
		Joueur j1 = new Humain("M", Color.GREEN);
		Joueur j2 = new Humain("N", Color.BLUE);
		l.add(j1);
		l.add(j2);
		p.poserColonie(2, 2, j1);
		p.poserColonie(4, 4, j2);
		p.recolte(10, l);
		p.recolte(6, l);
		p.recolte(5, l);
		p.affiche();
		assertEquals(1,j1.getNbArgile());
		assertEquals(1,j2.getNbArgile());
		assertEquals(0,j1.getNbBois());
		assertEquals(1,j2.getNbBois());
		((Humain)j1).voirInventaire();
		((Humain)j2).voirInventaire();
	}
	
	@Test
	void recolte3() {
		Joueur j = new Humain("L", Color.GREEN);
		Plateau p = new Plateau();
		p.poserColonie(2, 2, j);
		p.poserColonie(6, 8, j);
		p.recolte(10, j);
		p.affiche();
		assertEquals(1,j.getNbArgile());
		assertEquals(1,j.getNbBois());
		((Humain)j).voirInventaire();
		assertEquals(false,p.poserColonie(2, 4, j));
	}

}