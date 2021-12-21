package joueur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import inventaire.Batiment;
import plateau.Plateau;

class Joueur01Test {
	
	@Test
	void possedeBatiment() {
		Joueur j1 = new Humain("Jean");
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
		Joueur j2 = new Humain("Pierre");
		j2.utiliserColonie();
		j2.setBatiment(Batiment.COLONIE);
		assertEquals(1,j2.getBatiment().getQuantite());
		j2.utiliserVille();
		j2.setBatiment(Batiment.VILLE);
		assertEquals(-1,j2.getBatiment().getQuantite());
	}
	
	@Test
	void peutAcheterBatiment() {
		Joueur j3 = new Humain("Bertrand");
		assertEquals(false,j3.peutAcheterColonie());
		assertEquals(false,j3.peutAcheterRoute());
		assertEquals(false,j3.peutAcheterVille());
	}
	
	@Test
	void poserColonie() {
		Joueur j4 = new Humain("François");
		Plateau p = new Plateau();
		p.affiche();
		j4.poserColonie(p);
		p.affiche();
	}
}
