package plateau;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import joueur.*;

class Plateau01Test {

	@Test
	void affichePlateau() {
		Plateau p = new Plateau();
		p.affiche();
	}
	
	@Test
	void poserRoute() {
		Plateau p = new Plateau();
		Joueur j = new Humain("Jean", Color.BLUE);
		Joueur j2 = new Humain("Louis", Color.RED);
		assertEquals(true, p.poserColonie(2, 2, j));
		assertEquals(true, p.poserColonie(4, 4, j2));
		assertEquals(true, p.poserRoute(3, 2, j));
		assertEquals(true, p.poserRoute(4, 1, j));
		assertEquals(true, p.poserRoute(4, 3, j2));
		assertEquals(false, p.poserRoute(5, 0, j2));
		assertEquals(false, p.poserRoute(8, 3, j2));
		assertEquals(false, p.poserRoute(2, 3, j2));
		p.affiche();
	}
	
	@Test
	void poserColonie() {
		Plateau p = new Plateau();
		Joueur j = new Humain("Jean", Color.BLUE);
		assertEquals(true, p.poserColonie(2, 2, j));
		assertEquals(true, p.poserColonie(4, 4, j));
		assertEquals(false, p.poserColonie(2, 4, j));
		assertEquals(false, p.poserColonie(6, 4, j));
	}

}
