package joueur;

import static org.junit.jupiter.api.Assertions.*;


import java.awt.Color;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import inventaire.Inventaire;
import plateau.Plateau;

class Joueur01Test {
	
	@Test
	void possedeBatiment() {
		Joueur j1 = new Humain("Jean",Color.BLUE);
		assertEquals(true, j1.possedeColonie());
		assertEquals(true, j1.possedeRoute());
		assertEquals(false, j1.possedeVille());
	}
	
	@Test
	void utiliserBatiment() {
		Joueur j2 = new Humain("Pierre",Color.BLUE);
		j2.utiliserColonie();
		assertEquals(1, j2.getNbColonie());
	}
	
	@Test
	void peutAcheterBatiment() {
		Joueur j3 = new Humain("Bertrand",Color.BLUE);
		assertEquals(false,j3.peutAcheterColonie());
		assertEquals(false,j3.peutAcheterRoute());
		assertEquals(false,j3.peutAcheterVille());
	}
}
