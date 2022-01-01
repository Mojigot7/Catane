package jeu;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Jeu01Test {

	/*@Test
	void creationJoueurs() {
		Jeu jeu = new Jeu();
		jeu.creationDesJoueurs();
	}*/
	
	@Test
	void tour1et2() {
		Jeu jeu = new Jeu();
		jeu.creationDesJoueurs();
		jeu.tour1();
		jeu.tour2();
		assertEquals(0, jeu.getJoueur1().getNbColonie());
		assertEquals(0, jeu.getJoueur2().getNbColonie());
		assertEquals(0, jeu.getJoueur3().getNbColonie());
		assertEquals(0, jeu.getJoueur4().getNbColonie());
	}
}