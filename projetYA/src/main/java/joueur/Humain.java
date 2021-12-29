package joueur;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Scanner;

import plateau.Plateau;

public class Humain extends Joueur {
	private Scanner sc;
	
	public Humain(String nom, Color couleur) {
		super(nom, couleur);
		this.sc = new Scanner(System.in);
	}

	@Override
	public void poserRoute(Plateau p) { //TODO: route la plus longue
		int x, y;
		System.out.println("Joueur ["+super.toString()+"] : Où voulez-vous posez votre route ? (Saisissez la première coordonnée de 0 à 8)");
		x = sc.nextInt();
		System.out.println("Joueur ["+super.toString()+"] : Où voulez-vous posez votre route ? (Saisissez la seconde coordonnée de 0 à 10)");
		y = sc .nextInt();
		while(!p.poserRoute(x, y, this)) {
			System.out.println("Joueur ["+super.toString()+"] : Où voulez-vous posez votre route ? (Saisissez la première coordonnée de 0 à 8)");
			x = sc.nextInt();
			System.out.println("Joueur ["+super.toString()+"] : Où voulez-vous posez votre route ? (Saisissez la seconde coordonnée de 0 à 10)");
			y = sc .nextInt();
		}
		//sc.close();
		this.utiliserRoute();
		System.out.println();
	}

	@Override
	public void poserColonie(Plateau p) { //TODO: ajouter les points de victoire
		int x, y;
		System.out.println("Joueur ["+super.toString()+"] : Où voulez-vous posez votre colonie ? (Saisissez la première coordonnée de 0 à 8)");
		x = sc.nextInt();
		System.out.println("Joueur ["+super.toString()+"] : Où voulez-vous posez votre colonie ? (Saisissez la seconde coordonnée de 0 à 10)");
		y = sc.nextInt();
		while(!p.poserColonie(x, y, this)) {
			System.out.println("Joueur ["+super.toString()+"] : Où voulez-vous posez votre colonie ? (Saisissez la première coordonnée de 0 à 8)");
			x = sc.nextInt();
			System.out.println("Joueur ["+super.toString()+"] : Où voulez-vous posez votre colonie ? (Saisissez la seconde coordonnée de 0 à 10)");
			y = sc .nextInt();
		}
		//sc.close();
		this.utiliserColonie();
		this.score += 1;
		System.out.println("Joueur ["+super.toString()+"] a gagné 1 points de victoire !");
		System.out.println();
	}

	@Override
	public void poserVille(Plateau p) { //TODO: ajouter les points de victoire
		int x, y;
		System.out.println("Joueur ["+super.toString()+"] : Où voulez-vous posez votre ville ? (Saisissez la première coordonnée de 0 à 8)");
		x = sc.nextInt();
		System.out.println("Joueur ["+super.toString()+"] : Où voulez-vous posez votre ville ? (Saisissez la seconde coordonnée de 0 à 10)");
		y = sc .nextInt();
		while(!p.poserVille(x, y, this)) {
			System.out.println("Joueur ["+super.toString()+"] : Où voulez-vous posez votre ville ? (Saisissez la première coordonnée de 0 à 8)");
			x = sc.nextInt();
			System.out.println("Joueur ["+super.toString()+"] : Où voulez-vous posez votre ville ? (Saisissez la seconde coordonnée de 0 à 10)");
			y = sc .nextInt();
		}
		//sc.close();
		this.utiliserVille();
		this.score += 2;
		System.out.println("Joueur ["+super.toString()+"] a gagné 2 points de victoire !");
		System.out.println();
	}
	
	@Override
	public void jetterSesRessources() { //A tester
		int x=-1, moitie;
		String ressource = "";
		if(this.sommeDesRessources() > 7) {
			if(this.sommeDesRessources() % 2 == 0) {
				moitie = this.sommeDesRessources()/2;
			} else {
				moitie = this.sommeDesRessources()/2+1;
			}
			while(this.sommeDesRessources() > moitie) {
				System.out.println("Il vous reste encore "+(this.sommeDesRessources()-moitie)+" à jeter.");
				System.out.println("Joueur ["+super.toString()+"] : Quelle(s) ressource(s) voulez-vous jetter ? \n"
						+ "- Blé (Entrez BLE) \n"
						+ "- Bois (Entrez BOIS) \n"
						+ "- Minerai (Entrez MINERAI) \n"
						+ "- Argile (Entrez ARGILE) \n"
						+ "- Laine (Entrez LAINE)");
				ressource = sc.next().toUpperCase();
				while( this.inventaire.getRessource().get(ressource) == null || this.inventaire.getRessource().get(ressource) <= 0) {
					System.out.println("Vous n'avez pas de ressources de ce type !");
					System.out.println("Joueur ["+super.toString()+"] : Quelle(s) ressource(s) voulez-vous jetter ? \n"
							+ "- Blé (Entrez BLE) \n"
							+ "- Bois (Entrez BOIS) \n"
							+ "- Minerai (Entrez MINERAI) \n"
							+ "- Argile (Entrez ARGILE) \n"
							+ "- Laine (Entrez LAINE)");
					ressource = sc.next().toUpperCase();
				}
				System.out.println("Joueur ["+super.toString()+"] : Combien voulez-vous en jetter ? (Entrée un entier)");
				x = sc.nextInt(); //TO FIX: si la personne met autre chose qu'un entier le programme s'arrête
				while( this.inventaire.getRessource().get(ressource) < x || x < 0) {
					System.out.println("Vous n'avez pas assez de ressources de ce type pour en jetter autant !");
					System.out.println("Joueur ["+super.toString()+"] : Combien voulez-vous en jetter ? (Entrée un entier) /n"
							+ "Ou revenez en arrière (Entrée 0)");
					x = sc.nextInt();
				}
				if(x == 0) {
					this.jetterSesRessources();
					return;
				}
				this.inventaire.getRessource().replace(ressource, this.inventaire.getRessource().get(ressource)-x);
				System.out.println("Joueur ["+super.toString()+"] a jeté "+x+" "+ressource);
			}
		}
		System.out.println();
	}
	
	@Override
	public void deplacerVoleur(Plateau p) { // A tester
		int x, y;
		System.out.println("Joueur ["+super.toString()+"] : Où voulez-vous déplacer le voleur ? (Saisissez la première coordonnée de 0 à 8)");
		x = sc.nextInt();
		System.out.println("Joueur ["+super.toString()+"] : Où voulez-vous déplacer le voleur ? (Saisissez la seconde coordonnée de 0 à 10)");
		y = sc .nextInt();
		while(!p.deplacerVoleur(x, y, this)) {
			System.out.println("Joueur ["+super.toString()+"] : Où voulez-vous déplacer le voleur ? (Saisissez la première coordonnée de 0 à 8)");
			x = sc.nextInt();
			System.out.println("Joueur ["+super.toString()+"] : Où voulez-vous déplacer le voleur ? (Saisissez la seconde coordonnée de 0 à 10)");
			y = sc .nextInt();
		}
		System.out.println();
	}
	
	@Override
	public String donnerRessource() {
		String ressource = "";
		System.out.println("Joueur ["+super.toString()+"] : Quelle(s) ressource(s) voulez-vous donner ? \n"
				+ "- Blé (Entrez BLE) \n"
				+ "- Bois (Entrez BOIS) \n"
				+ "- Minerai (Entrez MINERAI) \n"
				+ "- Argile (Entrez ARGILE) \n"
				+ "- Laine (Entrez LAINE)");
		ressource = sc.next().toUpperCase();
		while( this.inventaire.getRessource().get(ressource) == null || this.inventaire.getRessource().get(ressource) <= 0) {
			System.out.println("Joueur ["+super.toString()+"] : Quelle(s) ressource(s) voulez-vous donner ? \n"
					+ "- Blé (Entrez BLE) \n"
					+ "- Bois (Entrez BOIS) \n"
					+ "- Minerai (Entrez MINERAI) \n"
					+ "- Argile (Entrez ARGILE) \n"
					+ "- Laine (Entrez LAINE)");
			ressource = sc.next().toUpperCase();
		}
		this.inventaire.getRessource().replace(ressource, this.inventaire.getRessource().get(ressource)-1);
		System.out.println("Joueur ["+super.toString()+"] a donné 1 "+ressource);
		System.out.println();
		return ressource;
	}
}