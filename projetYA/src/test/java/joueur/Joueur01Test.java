package joueur;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import inventaire.Batiment;
import plateau.Plateau;

class Joueur01Test {
	
	@Test
	void possedeBatiment() {
		Joueur j1 = new Humain("Jean",Color.BLUE);
		assertEquals(true, j1.possedeColonie());
		assertEquals(true, j1.possedeRoute());
		assertEquals(false, j1.possedeVille());
		j1.setBatiment(Batiment.COLONIE);
		assertEquals(2,j1.getBatiment().getQuantite());
		j1.setBatiment(Batiment.VILLE);
		assertEquals(0,j1.getBatiment().getQuantite());
	}
	
	@Test
	void utiliserBatiment() {
		Joueur j2 = new Humain("Pierre",Color.BLUE);
		j2.utiliserColonie();
		j2.setBatiment(Batiment.COLONIE);
		assertEquals(1,j2.getBatiment().getQuantite());
		j2.utiliserVille();
		j2.setBatiment(Batiment.VILLE);
		assertEquals(-1,j2.getBatiment().getQuantite());
	}
	
	@Test
	void peutAcheterBatiment() {
		Joueur j3 = new Humain("Bertrand",Color.BLUE);
		assertEquals(false,j3.peutAcheterColonie());
		assertEquals(false,j3.peutAcheterRoute());
		assertEquals(false,j3.peutAcheterVille());
	}
}
