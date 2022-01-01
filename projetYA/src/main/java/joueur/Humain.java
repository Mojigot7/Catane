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
	public void poserColonie(Plateau p) { // Permet de poser une colonie sur les intersections des tuiles
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
		System.out.println();
	}

	@Override
	public void poserVille(Plateau p) { // Permet de poser une ville par dessus une colonie
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
		System.out.println();
	}
	
	@Override
	public void jeterSesRessources() { // Quand un joueur fait 7 : permet de jetter la moitié de ses ressources si on en a plus de 7
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
				System.out.println("Joueur ["+super.toString()+"] : Quelle(s) ressource(s) voulez-vous jeter ? \n"
						+ "- Blé (Entrez BLE) \n"
						+ "- Bois (Entrez BOIS) \n"
						+ "- Minerai (Entrez MINERAI) \n"
						+ "- Argile (Entrez ARGILE) \n"
						+ "- Laine (Entrez LAINE)");
				ressource = sc.next().toUpperCase();
				while( this.inventaire.getRessource().get(ressource) == null || this.inventaire.getRessource().get(ressource) <= 0) {
					System.out.println("Vous n'avez pas de ressources de ce type !");
					System.out.println("Joueur ["+super.toString()+"] : Quelle(s) ressource(s) voulez-vous jeter ? \n"
							+ "- Blé (Entrez BLE) \n"
							+ "- Bois (Entrez BOIS) \n"
							+ "- Minerai (Entrez MINERAI) \n"
							+ "- Argile (Entrez ARGILE) \n"
							+ "- Laine (Entrez LAINE)");
					ressource = sc.next().toUpperCase();
				}
				System.out.println("Joueur ["+super.toString()+"] : Combien voulez-vous en jeter ? (Entrée un entier)");
				x = sc.nextInt(); //TO FIX: si la personne met autre chose qu'un entier le programme s'arrête
				while( this.inventaire.getRessource().get(ressource) < x || x < 0) {
					System.out.println("Vous n'avez pas assez de ressources de ce type pour en jeter autant !");
					System.out.println("Joueur ["+super.toString()+"] : Combien voulez-vous en jeter ? (Entrée un entier) /n"
							+ "Ou revenez en arrière (Entrée 0)");
					x = sc.nextInt();
				}
				if(x == 0) {
					this.jeterSesRessources();
					return;
				}
				this.inventaire.getRessource().replace(ressource, this.inventaire.getRessource().get(ressource)-x);
				System.out.println("Joueur ["+super.toString()+"] a jeté "+x+" "+ressource);
			}
		}
		System.out.println();
	}
	
	@Override
	public void deplacerVoleur(Plateau p) { // deplace le voleur
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
	public String donnerRessource() { // Quand un joueur se fait voler une ressource il donne une ressource de son choix
		String ressource = "";
		System.out.println("Joueur ["+super.toString()+"] : Quelle(s) ressource(s) voulez-vous donner ? \n"
				+ "- Blé (Entrez BLE) \n"
				+ "- Bois (Entrez BOIS) \n"
				+ "- Minerai (Entrez MINERAI) \n"
				+ "- Argile (Entrez ARGILE) \n"
				+ "- Laine (Entrez LAINE)");
		ressource = sc.next().toUpperCase();
		while( this.inventaire.getRessource().get(ressource) == null || this.inventaire.getRessource().get(ressource) <= 0) {
			System.out.println("Ce n'est pas une ressource valable !");
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
	
	public void echangerRessource() { // commerce sans le port
		String ressource = "", echange = "";
		System.out.println("Joueur ["+super.toString()+"] : Quelle(s) ressource(s) voulez-vous avoir ? \n"
				+ "- Blé (Entrez BLE) \n"
				+ "- Bois (Entrez BOIS) \n"
				+ "- Minerai (Entrez MINERAI) \n"
				+ "- Argile (Entrez ARGILE) \n"
				+ "- Laine (Entrez LAINE)");
		ressource = sc.next().toUpperCase();
		while(this.inventaire.getRessource().get(ressource) == null) {
			System.out.println("Ce n'est pas une ressource valable !");
			System.out.println("Joueur ["+super.toString()+"] : Quelle(s) ressource(s) voulez-vous avoir ? \n"
					+ "- Blé (Entrez BLE) \n"
					+ "- Bois (Entrez BOIS) \n"
					+ "- Minerai (Entrez MINERAI) \n"
					+ "- Argile (Entrez ARGILE) \n"
					+ "- Laine (Entrez LAINE)");
			ressource = sc.next().toUpperCase();
		}
		System.out.println("Joueur ["+super.toString()+"] : Quelle(s) ressource(s) voulez-vous échanger ? \n"
				+ "- Blé (Entrez BLE) \n"
				+ "- Bois (Entrez BOIS) \n"
				+ "- Minerai (Entrez MINERAI) \n"
				+ "- Argile (Entrez ARGILE) \n"
				+ "- Laine (Entrez LAINE)");
		echange = sc.next().toUpperCase();
		// condition si la colonie est proche d'un port
		while(this.inventaire.getRessource().get(echange) == null || this.inventaire.getRessource().get(echange) < 4 || echange.equals(ressource)) {
			System.out.println("Ce n'est pas une ressource valable ! (vous n'en avez pas assez)");
			System.out.println("Joueur ["+super.toString()+"] : Quelle(s) ressource(s) voulez-vous échanger ? \n"
					+ "- Blé (Entrez BLE) \n"
					+ "- Bois (Entrez BOIS) \n"
					+ "- Minerai (Entrez MINERAI) \n"
					+ "- Argile (Entrez ARGILE) \n"
					+ "- Laine (Entrez LAINE)");
			echange = sc.next().toUpperCase();
		}
		this.inventaire.getRessource().replace(ressource, this.inventaire.getRessource().get(ressource)+1);
		this.inventaire.getRessource().replace(echange, this.inventaire.getRessource().get(echange)-4);
		System.out.println("Joueur ["+super.toString()+"] a échangé 4 "+echange+" pour 1 "+ressource);
		System.out.println();
	}

	@Override
	public String faireChoix(Plateau p) {
		System.out.println("Joueur ["+this.toString()+"] que voulez vous faire :");
		if(!p.coloniePleine()) { // peut poser Colonie
			System.out.println("- poser une Colonie (Entrée pc)");
			return sc.next();
		}
		if(!p.coloniePleine()) { // peut poser Colonie
			System.out.println("- poser une Route (Entrée pc)");
			return sc.next();
		}
		if(!p.coloniePleine()) { // peut poser Colonie
			System.out.println("- poser une Ville (Entrée pc)");
			return sc.next();
		}
		return null;
	}
}