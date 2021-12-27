package joueur;

import java.awt.Color;
import java.util.Scanner;

import plateau.Plateau;

public class Humain extends Joueur {
	private Scanner sc;
	
	public Humain(String nom, Color couleur) {
		super(nom, couleur);
		this.sc = new Scanner(System.in);
	}

	@Override
	public void poserRoute(Plateau p) {
		int x, y;
		System.out.println("Joueur : "+super.nom+" Où voulez-vous posez votre route ? (Saisissez la première coordonnée de 0 à 8)");
		x = sc.nextInt();
		System.out.println("Joueur : "+super.nom+" Où voulez-vous posez votre route ? (Saisissez la seconde coordonnée de 0 à 10)");
		y = sc .nextInt();
		while(!p.poserRoute(x, y, this)) {
			System.out.println("Joueur : "+super.nom+" Où voulez-vous posez votre route ? (Saisissez la première coordonnée de 0 à 8)");
			x = sc.nextInt();
			System.out.println("Joueur : "+super.nom+" Où voulez-vous posez votre route ? (Saisissez la seconde coordonnée de 0 à 10)");
			y = sc .nextInt();
		}
		//sc.close();
		this.utiliserRoute();
	}

	@Override
	public void poserColonie(Plateau p) {
		int x, y;
		System.out.println("Joueur : "+super.nom+" Où voulez-vous posez votre colonie ? (Saisissez la première coordonnée de 0 à 8)");
		x = sc.nextInt();
		System.out.println("Joueur : "+super.nom+" Où voulez-vous posez votre colonie ? (Saisissez la seconde coordonnée de 0 à 10)");
		y = sc.nextInt();
		while(!p.poserColonie(x, y, this)) {
			System.out.println("Joueur : "+super.nom+" Où voulez-vous posez votre colonie ? (Saisissez la première coordonnée de 0 à 8)");
			x = sc.nextInt();
			System.out.println("Joueur : "+super.nom+" Où voulez-vous posez votre colonie ? (Saisissez la seconde coordonnée de 0 à 10)");
			y = sc .nextInt();
		}
		//sc.close();
		this.utiliserColonie();
	}

	@Override
	public void poserVille(Plateau p) {
		int x, y;
		System.out.println("Joueur : "+super.nom+" Où voulez-vous posez votre ville ? (Saisissez la première coordonnée de 0 à 8)");
		x = sc.nextInt();
		System.out.println("Joueur : "+super.nom+" Où voulez-vous posez votre ville ? (Saisissez la seconde coordonnée de 0 à 10)");
		y = sc .nextInt();
		while(!p.poserVille(x, y, this)) {
			System.out.println("Joueur : "+super.nom+" Où voulez-vous posez votre ville ? (Saisissez la première coordonnée de 0 à 8)");
			x = sc.nextInt();
			System.out.println("Joueur : "+super.nom+" Où voulez-vous posez votre ville ? (Saisissez la seconde coordonnée de 0 à 10)");
			y = sc .nextInt();
		}
		//sc.close();
		this.utiliserVille();
	}
}
