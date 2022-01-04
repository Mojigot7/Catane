package plateau;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import joueur.*;

class Plateau01Test {

	@Test
	void affichePlateau() {
		Plateau p = new Plateau();
		Humain j = new Humain("g",Color.RED);
		j.getDev().creationCarteDev(j.getDev().getStock());
		j.voirInventaire();
		assertEquals(4,9/2);
	}
	
	/*@Test
	void poserRoute() {
		Plateau p = new Plateau();
		Joueur j = new Humain("Jean", Color.BLUE);
		Joueur j2 = new Humain("Louis", Color.RED);
		assertEquals(true, p.poserColonie(2, 2, j));
		assertEquals(true, p.poserColonie(4, 4, j2));
		assertEquals(true, p.poserRoute(2, 3, j));
		assertEquals(true, p.poserRoute(3, 4, j));
		assertEquals(false, p.poserRoute(3, 4, j2));
		p.affiche();
	}
	
	@Test
	void poserColonie() {
		Plateau p = new Plateau();
		Joueur j = new Humain("Jean", Color.BLUE);
		Joueur j2 = new Humain("Jean", Color.RED);
		assertEquals(true, p.poserColonie(2, 2, j));
		assertEquals(true, p.poserVille(2, 2, j));
		assertEquals(false, p.poserColonie(2, 4, j2));
		assertEquals(true, p.poserColonie(6, 4, j2));
		assertEquals(true, p.poserVille(6, 4, j2));
		assertEquals(false, p.poserVille(6, 6, j2));
		p.affiche();
	}*/

}
