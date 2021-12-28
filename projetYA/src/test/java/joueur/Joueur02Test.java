package joueur;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import plateau.Plateau;
import tuiles.Sommet;

class Joueur02Test {

	@Test
	void poserColonie() {
		Joueur j4 = new Humain("François",Color.BLUE);
		Joueur j5 = new Humain("Gilles", Color.RED);
		Plateau p = new Plateau();
		p.affiche();
		j4.poserColonie(p);
		j4.poserColonie(p);
		j5.poserColonie(p);
		assertEquals(Color.RED,((Sommet)p.getPlateau()[4][0]).getCouleur());
		p.affiche();
	}
	
	@Test
	void poserRoute() {
		Joueur j = new Humain("F",Color.BLUE);
		Plateau p = new Plateau();
		j.poserColonie(p);
		j.poserRoute(p);
		j.poserRoute(p);
		p.affiche();
	}
	
	@Test
	void poserVille() {
		Joueur j = new Humain("G",Color.YELLOW);
		Joueur j2 = new Humain("H",Color.GREEN);
		Plateau p = new Plateau();
		j.poserColonie(p);
		j.poserVille(p);
		j2.poserColonie(p);
		j.poserColonie(p);
		j.poserVille(p);
		p.affiche();
	}

}
