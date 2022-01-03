package joueur;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import plateau.Plateau;

class Joueur04Test {

	@Test
	void faireChoix() {
		Plateau p = new Plateau();
		Joueur j = new Humain("f",Color.BLUE);
		j.getInventaire().getRessource().replace("BOIS", 4);
		j.getInventaire().getRessource().replace("ARGILE", 4);
		j.faireChoix(p);
	}

}
