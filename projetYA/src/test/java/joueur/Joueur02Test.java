package joueur;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import plateau.Plateau;

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
		assertEquals(Color.RED,p.getPlateau()[4][0].getCouleur());
		p.affiche();
	}

}
