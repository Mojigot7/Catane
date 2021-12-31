package plateau;

import java.util.ArrayList;
import java.util.Random;

import joueur.Humain;
import joueur.IA;
import joueur.Joueur;
import tuiles.*;

public class Plateau implements PlateauFunction{
	private Tuile[][] plateau;
	private int[] voleur;
	
	public Plateau() {
		this.plateau = new Tuile[9][11];
		this.remplirPlateau();
		this.voleur = new int[2];
		voleur[0] = 5;
		voleur[1] = 5;
	}
	
	public boolean horsPlateau(int x, int y) { // Vérifie que la case n'est pas hors du plateau
		return x < 0 || x > 8 || y < 0 || y > 10;
	}
	
	public boolean estVide(int x, int y) { // Vérifie que la case n'est pas null
		return this.getPlateau()[x][y] == null;
	}

	public void remplirPlateau() { // Initialise le plateau
		this.getPlateau()[0][1] = new Port();
		this.getPlateau()[0][2] = new Sommet();
		this.getPlateau()[0][3] = new Croisement();
		this.getPlateau()[0][4] = new Sommet();
		this.getPlateau()[0][5] = new Croisement();
		this.getPlateau()[0][6] = new Sommet();
		this.getPlateau()[0][7] = new Croisement();
		this.getPlateau()[0][8] = new Sommet();
		this.getPlateau()[0][9] = new Port();
		
		this.getPlateau()[1][0] = new Port();
		this.getPlateau()[1][1] = new Foret(2);
		this.getPlateau()[1][2] = new Croisement();
		this.getPlateau()[1][3] = new Pre(6);
		this.getPlateau()[1][4] = new Croisement();
		this.getPlateau()[1][5] = new Champs(8);
		this.getPlateau()[1][6] = new Croisement();
		this.getPlateau()[1][7] = new Pre(9);
		this.getPlateau()[1][8] = new Croisement();
		this.getPlateau()[1][9] = new Champs(12);
		this.getPlateau()[1][10] = new Port();
		
		this.getPlateau()[2][0] = new Sommet();
		this.getPlateau()[2][1] = new Croisement();
		this.getPlateau()[2][2] = new Sommet();
		this.getPlateau()[2][3] = new Croisement();
		this.getPlateau()[2][4] = new Sommet();
		this.getPlateau()[2][5] = new Croisement();
		this.getPlateau()[2][6] = new Sommet();
		this.getPlateau()[2][7] = new Croisement();
		this.getPlateau()[2][8] = new Sommet();
		this.getPlateau()[2][9] = new Croisement();
		this.getPlateau()[2][10] = new Sommet();
		
		this.getPlateau()[3][0] = new Croisement();
		this.getPlateau()[3][1] = new Champs(8);
		this.getPlateau()[3][2] = new Croisement();
		this.getPlateau()[3][3] = new Colline(10);
		this.getPlateau()[3][4] = new Croisement();
		this.getPlateau()[3][5] = new Foret(5);
		this.getPlateau()[3][6] = new Croisement();
		this.getPlateau()[3][7] = new Montagne(3);
		this.getPlateau()[3][8] = new Croisement();
		this.getPlateau()[3][9] = new Foret(4);
		this.getPlateau()[3][10] = new Croisement();
		
		this.getPlateau()[4][0] = new Sommet();
		this.getPlateau()[4][1] = new Croisement();
		this.getPlateau()[4][2] = new Sommet();
		this.getPlateau()[4][3] = new Croisement();
		this.getPlateau()[4][4] = new Sommet();
		this.getPlateau()[4][5] = new Croisement();
		this.getPlateau()[4][6] = new Sommet();
		this.getPlateau()[4][7] = new Croisement();
		this.getPlateau()[4][8] = new Sommet();
		this.getPlateau()[4][9] = new Croisement();
		this.getPlateau()[4][10] = new Sommet();
		
		this.getPlateau()[5][0] = new Croisement();
		this.getPlateau()[5][1] = new Montagne(12);
		this.getPlateau()[5][2] = new Croisement();
		this.getPlateau()[5][3] = new Champs(11);
		this.getPlateau()[5][4] = new Croisement();
		this.getPlateau()[5][5] = new Desert();
		this.getPlateau()[5][6] = new Croisement();
		this.getPlateau()[5][7] = new Colline(6);
		this.getPlateau()[5][8] = new Croisement();
		this.getPlateau()[5][9] = new Pre(5);
		this.getPlateau()[5][10] = new Croisement();
		
		this.getPlateau()[6][0] = new Sommet();
		this.getPlateau()[6][1] = new Croisement();
		this.getPlateau()[6][2] = new Sommet();
		this.getPlateau()[6][3] = new Croisement();
		this.getPlateau()[6][4] = new Sommet();
		this.getPlateau()[6][5] = new Croisement();
		this.getPlateau()[6][6] = new Sommet();
		this.getPlateau()[6][7] = new Croisement();
		this.getPlateau()[6][8] = new Sommet();
		this.getPlateau()[6][9] = new Croisement();
		this.getPlateau()[6][10] = new Sommet();
		
		this.getPlateau()[7][0] = new Port();
		this.getPlateau()[7][1] = new Colline(2);
		this.getPlateau()[7][2] = new Croisement();
		this.getPlateau()[7][3] = new Montagne(3);
		this.getPlateau()[7][4] = new Croisement();
		this.getPlateau()[7][5] = new Pre(4);
		this.getPlateau()[7][6] = new Croisement();
		this.getPlateau()[7][7] = new Foret(10);
		this.getPlateau()[7][8] = new Croisement();
		this.getPlateau()[7][9] = new Montagne(2);
		this.getPlateau()[7][10] = new Port();
		
		this.getPlateau()[8][1] = new Port();
		this.getPlateau()[8][2] = new Sommet();
		this.getPlateau()[8][3] = new Croisement();
		this.getPlateau()[8][4] = new Sommet();
		this.getPlateau()[8][5] = new Croisement();
		this.getPlateau()[8][6] = new Sommet();
		this.getPlateau()[8][7] = new Croisement();
		this.getPlateau()[8][8] = new Sommet();
		this.getPlateau()[8][9] = new Port();
	}

	public void affiche() {
		for(int i = 0 ; i < this.getPlateau().length; i++) {
			for(int j = 0 ; j < this.getPlateau()[i].length; j++) {
				if(this.getPlateau()[i][j] != null) {
					System.out.print("["+this.getPlateau()[i][j]+"] ");
				} else {
					System.out.print("    ");
				}	
			}
			System.out.println();
		}
		
	}
	
	public boolean poserRoute(int x, int y, Joueur j) { // TO FIX: si la personne ne peut pas poser de route mais qu'il y a de la place
		if(!this.horsPlateau(x, y) && !this.estVide(x, y) && this.getPlateau()[x][y].estCroisement()) {
			if(!((Croisement)this.getPlateau()[x][y]).isRoute() && this.routeEstProcheDeColonie(x, y, j) || this.routeEstProcheDeRoute(x, y, j)) {
				((Croisement)this.getPlateau()[x][y]).setRoute(true);
				((Croisement)this.getPlateau()[x][y]).setCouleur(j.getCouleur());
				return true;
			} else {
				if(j instanceof Humain) {
					System.out.println("Il y a déjà une route ici ou il n'y a pas de colonie proche !");
				}
			}
		} else {
			if(j instanceof Humain) {
				System.out.println("Vous ne pouvez pas poser de route ici !");
			}
		}
		return false;
	}
	
	public boolean routePleine(Joueur joueur) { // Vérifie si toutes les routes sont occupées
		for(int i = 0; i < this.plateau.length; i++) {
			for(int j = 0; j < this.plateau[i].length; j++) {
				if(!this.horsPlateau(i, j) && !this.estVide(i, j) && this.getPlateau()[i][j].estCroisement()) {
					if(!((Croisement)this.getPlateau()[i][j]).isRoute() && this.routeEstProcheDeColonie(i, j, joueur) || this.routeEstProcheDeRoute(i, j, joueur)) {
						return false;
					}	
				}
			}
		}
		return true;
	}
	
	public boolean poserColonie(int x, int y, Joueur j) {
		if(!this.horsPlateau(x, y) && !this.estVide(x, y) && this.getPlateau()[x][y].estSommet()) {
			if(!((Sommet)this.getPlateau()[x][y]).isColonie() && !((Sommet)this.getPlateau()[x][y]).isVille() && this.pasDeColonieAdjacente(x, y)) {
				((Sommet)this.getPlateau()[x][y]).setColonie(true);
				((Sommet)this.getPlateau()[x][y]).setCouleur(j.getCouleur());
				((Sommet)this.getPlateau()[x][y]).setOccupation(j);
				return true;
			} else {
				if(j instanceof Humain) {
					System.out.println("Il y a déjà une colonie ou une ville proche d'ici !");
				}
			}
		} else {
			if(j instanceof Humain) {
				System.out.println("Vous ne pouvez pas poser de colonie ici !");
			}
		}
		return false;
	}
	
	public boolean coloniePleine() { // Vérifie si toutes les colonies sont occupées
		for(int i = 0; i < this.plateau.length; i = i+2) {
			for(int j = 0; j < this.plateau[i].length; j = j+2) {
				if(!this.horsPlateau(i, j) && !this.estVide(i, j) && this.getPlateau()[i][j].estSommet()) {
					if(!((Sommet)this.getPlateau()[i][j]).isColonie() && !((Sommet)this.getPlateau()[i][j]).isVille() && this.pasDeColonieAdjacente(i, j)) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public boolean poserVille(int x, int y, Joueur j) {
		if(!this.horsPlateau(x, y) && !this.estVide(x, y) && this.getPlateau()[x][y].estSommet()) {
			if(((Sommet)this.getPlateau()[x][y]).isColonie() && ((Sommet)this.getPlateau()[x][y]).getCouleur() != null && j.getCouleur().getRGB() == ((Sommet)this.getPlateau()[x][y]).getCouleur().getRGB()) {
				((Sommet)this.getPlateau()[x][y]).setVille(true);
				((Sommet)this.getPlateau()[x][y]).setColonie(false);
				return true;
			} else {
				if(j instanceof Humain) System.out.println("Vous ne pouvez pas poser de ville ici ! (Il n'y a pas de colonie ou ce n'est pas votre colonie !)");
			}
		} else {
			if(j instanceof Humain) System.out.println("Vous ne pouvez pas poser de ville ici !");
		}
		return false;
	}
	
	public boolean villePleine(Joueur joueur) { // Vérifie si toutes les villes sont occupées
		for(int i = 0; i < this.plateau.length; i = i+2) {
			for(int j = 0; j < this.plateau[i].length; j = j+2) {
				if(!this.horsPlateau(i, j) && !this.estVide(i, j) && this.getPlateau()[i][j].estSommet()) {
					if(((Sommet)this.getPlateau()[i][j]).isColonie() && ((Sommet)this.getPlateau()[i][j]).getCouleur() != null && joueur.getCouleur().getRGB() == ((Sommet)this.getPlateau()[i][j]).getCouleur().getRGB()) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public void changerVoleur(int x, int y) {
		this.voleur[0] = x;
		this.voleur[1] = y;
	}

	public Tuile[][] getPlateau() {
		return plateau;
	}
	
	public boolean pasDeColonieAdjacente(int x, int y) { // Vérifie qu'il n y a pas de colonie proche pour poserColonie
		if(!this.horsPlateau(x, y-2) && !this.estVide(x, y-2) && ((Sommet)this.plateau[x][y-2]).isColonie()) {
			return false;
		}
		if(!this.horsPlateau(x-2, y) && !this.estVide(x-2, y) && ((Sommet)this.plateau[x-2][y]).isColonie()) {
			return false;
		}
		if(!this.horsPlateau(x, y+2) && !this.estVide(x, y+2) && ((Sommet)this.plateau[x][y+2]).isColonie()) {
			return false;
		}
		if(!this.horsPlateau(x+2, y) && !this.estVide(x+2, y) && ((Sommet)this.plateau[x+2][y]).isColonie()) {
			return false;
		}
		return true;
	}
	
	public boolean routeEstProcheDeRoute(int x, int y, Joueur j) { // Vérifie qu'il y a une route proche pour poser la route
		boolean change = false;
		if(!this.horsPlateau(x-1, y-1) && !this.getPlateau()[x-1][y-1].estPort() && ((Croisement)this.plateau[x-1][y-1]).getCouleur() != null && ((Croisement)this.plateau[x-1][y-1]).getCouleur().getRGB() == j.getCouleur().getRGB()) {
			change = true;
		}
		if(!this.horsPlateau(x-1, y+1) && !this.getPlateau()[x-1][y+1].estPort() && ((Croisement)this.plateau[x-1][y+1]).getCouleur() != null && ((Croisement)this.plateau[x-1][y+1]).getCouleur().getRGB() == j.getCouleur().getRGB()) {
			change = true;
		}
		if(!this.horsPlateau(x+1, y-1) && !this.getPlateau()[x+1][y-1].estPort() && ((Croisement)this.plateau[x+1][y-1]).getCouleur() != null && ((Croisement)this.plateau[x+1][y-1]).getCouleur().getRGB() == j.getCouleur().getRGB()) {
			change = true;
		}
		if(!this.horsPlateau(x+1, y+1) && !this.getPlateau()[x+1][y+1].estPort() && ((Croisement)this.plateau[x+1][y+1]).getCouleur() != null && ((Croisement)this.plateau[x+1][y+1]).getCouleur().getRGB() == j.getCouleur().getRGB()) {
			change = true;
		}
		return change;
	}
	
	public boolean routeEstProcheDeColonie(int x, int y, Joueur j) { // Vérifie qu'il y une colonie proche pour poser la route
		boolean change = false;
		if(!this.horsPlateau(x-1, y) && !this.plateau[x-1][y].estTuile() && ((Sommet)this.plateau[x-1][y]).getCouleur() != null && ((Sommet)this.plateau[x-1][y]).getCouleur().getRGB() == j.getCouleur().getRGB()) {
			change = true;
		}
		if(!this.horsPlateau(x+1, y) && !this.plateau[x+1][y].estTuile() && ((Sommet)this.plateau[x+1][y]).getCouleur() != null && ((Sommet)this.plateau[x+1][y]).getCouleur().getRGB() == j.getCouleur().getRGB()) {
			change = true;
		}
		if(!this.horsPlateau(x, y-1) && !this.plateau[x][y-1].estTuile() && ((Sommet)this.plateau[x][y-1]).getCouleur() != null && ((Sommet)this.plateau[x][y-1]).getCouleur().getRGB() == j.getCouleur().getRGB()) {
			change = true;
		}
		if(!this.horsPlateau(x, y+1) && !this.plateau[x][y+1].estTuile() && ((Sommet)this.plateau[x][y+1]).getCouleur() != null && ((Sommet)this.plateau[x][y+1]).getCouleur().getRGB() == j.getCouleur().getRGB()) {
			change = true;
		}
		return change;
	}
	
	public void recolte(int alea, Joueur joueur) { //Vérifie qu'un joueur a une colonie ou ville proche des tuiles, donnant des ressources et égal aux nombre du dée + gère le cas du voleur
		for(int i = 0; i < this.plateau.length; i = i+2) {
			for(int j = 0 ; j < this.plateau[i].length; j = j+2) {
				if(!this.estVide(i, j) && ((Sommet)this.plateau[i][j]).getCouleur() != null && ((Sommet)this.plateau[i][j]).getCouleur().getRGB() == joueur.getCouleur().getRGB()) {
					if(!this.horsPlateau(i-1, j-1) && !this.plateau[i-1][j-1].isVoleur() && this.plateau[i-1][j-1].getNumero() == alea) {
						joueur.ressourceAleatoire(this.plateau[i-1][j-1].getType(),((Sommet)this.plateau[i][j]).isVille());
					}
					if(!this.horsPlateau(i-1, j+1) && !this.plateau[i-1][j+1].isVoleur() && this.plateau[i-1][j+1].getNumero() == alea) {
						joueur.ressourceAleatoire(this.plateau[i-1][j+1].getType(),((Sommet)this.plateau[i][j]).isVille());
					}
					if(!this.horsPlateau(i+1, j-1) && !this.plateau[i+1][j-1].isVoleur() && this.plateau[i+1][j-1].getNumero() == alea) {
						joueur.ressourceAleatoire(this.plateau[i+1][j-1].getType(),((Sommet)this.plateau[i][j]).isVille());
					}
					if(!this.horsPlateau(i+1, j+1) && !this.plateau[i+1][j+1].isVoleur() && this.plateau[i+1][j+1].getNumero() == alea) {
						joueur.ressourceAleatoire(this.plateau[i+1][j+1].getType(),((Sommet)this.plateau[i][j]).isVille());
					}
				}
			}
		}
	}
	
	public void recolte(int alea, ArrayList<Joueur> j) { //Donne la ressource associé au numéro de la tuile pour chaque joueur
		for(Joueur joueur : j) {
			this.recolte(alea, joueur);
		}
	}
	
	public boolean deplacerVoleur(int x, int y, Joueur j) {
		if(!this.horsPlateau(x, y) && !this.estVide(x, y) && this.getPlateau()[x][y].peutEtreVoleur()) {
			this.plateau[voleur[0]][voleur[1]].setVoleur(false);
			this.plateau[voleur[0]][voleur[1]].setEstVoleur(null);
			this.plateau[x][y].setVoleur(true);;
			this.plateau[x][y].setEstVoleur(j);
			this.changerVoleur(x, y);
			return true;
		} else {
			if(j instanceof Humain) System.out.println("Vous ne pouvez pas mettre le voleur ici !");
		}
		return false;
	}
	
	public void estSurTuileDuVoleur(Joueur estVoleur){ // Recupère les joueurs qui ont une colonie proche de la tuile du voleur et leur volent leurs ressources
		ArrayList<Joueur> j = new ArrayList<>();
		ArrayList<String> s = new ArrayList<>();
		if(!this.estVide(voleur[0]-1, voleur[1]-1) && ((Sommet)this.plateau[voleur[0]-1][voleur[1]-1]).getCouleur() != null && ((Sommet)this.plateau[voleur[0]-1][voleur[1]-1]).getCouleur().getRGB() != this.plateau[voleur[0]][voleur[1]].getEstVoleur().getCouleur().getRGB()) {
			j.add(((Sommet)this.plateau[voleur[0]-1][voleur[1]-1]).getOccupation());
		}
		if(!this.estVide(voleur[0]-1, voleur[1]+1) && ((Sommet)this.plateau[voleur[0]-1][voleur[1]+1]).getCouleur() != null && ((Sommet)this.plateau[voleur[0]-1][voleur[1]+1]).getCouleur().getRGB() != this.plateau[voleur[0]][voleur[1]].getEstVoleur().getCouleur().getRGB() && !j.contains(((Sommet)this.plateau[voleur[0]-1][voleur[1]+1]).getOccupation())) {
			j.add(((Sommet)this.plateau[voleur[0]-1][voleur[1]+1]).getOccupation());
		}
		if(!this.estVide(voleur[0]+1, voleur[1]-1) && ((Sommet)this.plateau[voleur[0]+1][voleur[1]-1]).getCouleur() != null && ((Sommet)this.plateau[voleur[0]+1][voleur[1]-1]).getCouleur().getRGB() != this.plateau[voleur[0]][voleur[1]].getEstVoleur().getCouleur().getRGB() && !j.contains(((Sommet)this.plateau[voleur[0]+1][voleur[1]-1]).getOccupation())) {
			j.add(((Sommet)this.plateau[voleur[0]+1][voleur[1]-1]).getOccupation());
		}
		if(!this.estVide(voleur[0]+1, voleur[1]+1) && ((Sommet)this.plateau[voleur[0]+1][voleur[1]+1]).getCouleur() != null && ((Sommet)this.plateau[voleur[0]+1][voleur[1]+1]).getCouleur().getRGB() != this.plateau[voleur[0]][voleur[1]].getEstVoleur().getCouleur().getRGB() && !j.contains(((Sommet)this.plateau[voleur[0]+1][voleur[1]+1]).getOccupation())) {
			j.add(((Sommet)this.plateau[voleur[0]+1][voleur[1]+1]).getOccupation());
		}
		if(j.size() > 0) {
			for(Joueur joueur : j) {
				s.add(joueur.donnerRessource());
			}
		}
		if(s.size() > 0) {
			estVoleur.recupRessourceDonnee(s);
		}
	}
	
}