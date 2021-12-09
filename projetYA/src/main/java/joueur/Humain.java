package joueur;

import java.util.Scanner;

import plateau.Plateau;

public class Humain extends Joueur {
	public Humain(String nom) {
		super(nom);
	}

	@Override
	public void poserRoute(Plateau p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void poserColonie(Plateau p) {
		int x, y;
		Scanner sc = new Scanner(System.in);
		System.out.println("Où voulez-vous posez votre colonie ? (Saisissez la première coordonnée)");
		x = sc.nextInt();
		System.out.println("Où voulez-vous posez votre colonie ? (Saisissez la seconde coordonnée)");
		y = sc .nextInt();
		if(!p.horsPlateau(x, y)) {
			
		} else {
			
		}
		
	}

	@Override
	public void poserVille(Plateau p) {
		// TODO Auto-generated method stub
		
	}
}
