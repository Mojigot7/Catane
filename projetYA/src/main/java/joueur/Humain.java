package joueur;

import java.util.Scanner;

import plateau.Plateau;

public class Humain extends Joueur {
	public Humain(String nom) {
		super(nom);
	}

	@Override
	public void poserRoute(Plateau p) {
		int x, y;
		Scanner sc = new Scanner(System.in);
		System.out.println("Où voulez-vous posez votre colonie ? (Saisissez la première coordonnée)");
		x = sc.nextInt();
		System.out.println("Où voulez-vous posez votre colonie ? (Saisissez la seconde coordonnée)");
		y = sc .nextInt();
		while(!p.poserRoute(x, y)) {
			System.out.println("Où voulez-vous posez votre colonie ? (Saisissez la première coordonnée)");
			x = sc.nextInt();
			System.out.println("Où voulez-vous posez votre colonie ? (Saisissez la seconde coordonnée)");
			y = sc .nextInt();
		}
		sc.close();
		this.utiliserRoute();
	}

	@Override
	public void poserColonie(Plateau p) {
		//TODO: Vérifier qu'il n'y a pas de colonie n'appartenant pas au joueur courant
		int x, y;
		Scanner sc = new Scanner(System.in);
		System.out.println("Où voulez-vous posez votre colonie ? (Saisissez la première coordonnée)");
		x = sc.nextInt();
		System.out.println("Où voulez-vous posez votre colonie ? (Saisissez la seconde coordonnée)");
		y = sc .nextInt();
		while(!p.poserColonie(x, y)) {
			System.out.println("Où voulez-vous posez votre colonie ? (Saisissez la première coordonnée)");
			x = sc.nextInt();
			System.out.println("Où voulez-vous posez votre colonie ? (Saisissez la seconde coordonnée)");
			y = sc .nextInt();
		}
		sc.close();
		this.utiliserColonie();
	}

	@Override
	public void poserVille(Plateau p) {
		//TODO: verifier que la colonie où poser la ville appartient au joueur courant
		int x, y;
		Scanner sc = new Scanner(System.in);
		System.out.println("Où voulez-vous posez votre colonie ? (Saisissez la première coordonnée)");
		x = sc.nextInt();
		System.out.println("Où voulez-vous posez votre colonie ? (Saisissez la seconde coordonnée)");
		y = sc .nextInt();
		while(!p.poserVille(x, y)) {
			System.out.println("Où voulez-vous posez votre colonie ? (Saisissez la première coordonnée)");
			x = sc.nextInt();
			System.out.println("Où voulez-vous posez votre colonie ? (Saisissez la seconde coordonnée)");
			y = sc .nextInt();
		}
		sc.close();
		this.utiliserVille();
	}
}
