package joueur;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import plateau.Plateau;

class IA02Test {

	@Test
	void faireChoix() {
		Plateau p = new Plateau();
		Joueur j = new IA("gil",Color.BLUE);
		Joueur j2 = new IA("doll",Color.RED);
		for(int i = 0; i < 5; i++) {
			j.faireChoix(p);
			j2.faireChoix(p);
		}
		((IA)j).voirInventaire();
		((IA)j2).voirInventaire();
	}

}
