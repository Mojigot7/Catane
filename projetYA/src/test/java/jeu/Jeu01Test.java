package jeu;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Jeu01Test {

	@Test
	void creationJoueurs() {
		Jeu jeu = new Jeu();
		jeu.creationDesJoueurs();
	}

}