package plateau;

import java.util.ArrayList;

import joueur.Joueur;
import tuiles.*;

public class Plateau implements PlateauFunction{
	private Tuile[][] plateau;
	private int[] voleur;
	
	public Plateau() {
		this.plateau = new Tuile[9][9];
		this.remplirPlateau();
		this.voleur = new int[2];
		voleur[0] = 5;
		voleur[1] = 3;
	}
	
	public boolean horsPlateau(int x, int y) {
		return x < 0 || x > 8 || y < 0 || y > 8;
	}
	
	public boolean estVide(int x, int y) {
		return this.getPlateau()[x][y] == null;
	}

	public void remplirPlateau() {
		this.getPlateau()[0][2] = new Sommet(0,2);
		this.getPlateau()[0][3] = new Port(0,3);
		this.getPlateau()[0][4] = new Sommet(0,4);
		this.getPlateau()[0][6] = new Sommet(0,6);
		this.getPlateau()[0][7] = new Port(0,7);
		
		this.getPlateau()[1][0] = new Port(1,0);
		this.getPlateau()[1][1] = new Foret(1,1,6);
		this.getPlateau()[1][2] = new Croisement(1,2);
		this.getPlateau()[1][3] = new Pre(1,3,10);
		this.getPlateau()[1][4] = new Croisement(1,4);
		this.getPlateau()[1][5] = new Champs(1,5,11);
		this.getPlateau()[1][6] = new Croisement(1,6);
		this.getPlateau()[1][7] = new Pre(1,3,8);
		
		this.getPlateau()[2][0] = new Sommet(2,0);
		this.getPlateau()[2][1] = new Croisement(2,1);
		this.getPlateau()[2][2] = new Sommet(2,2);
		this.getPlateau()[2][3] = new Croisement(2,3);
		this.getPlateau()[2][4] = new Sommet(2,4);
		this.getPlateau()[2][5] = new Croisement(2,5);
		this.getPlateau()[2][6] = new Sommet(2,6);
		this.getPlateau()[2][7] = new Croisement(2,7);
		this.getPlateau()[2][8] = new Sommet(2,8);
		
		this.getPlateau()[3][1] = new Champs(3,1,4);
		this.getPlateau()[3][2] = new Croisement(3,2);
		this.getPlateau()[3][3] = new Colline(3,3,9);
		this.getPlateau()[3][4] = new Croisement(3,4);
		this.getPlateau()[3][5] = new Foret(3,5,5);
		this.getPlateau()[3][6] = new Croisement(3,6);
		this.getPlateau()[3][7] = new Montagne(3,7,12);
		this.getPlateau()[3][8] = new Port(3,8);
		
		this.getPlateau()[4][0] = new Sommet(4,0);
		this.getPlateau()[4][1] = new Croisement(4,1);
		this.getPlateau()[4][2] = new Sommet(4,2);
		this.getPlateau()[4][3] = new Croisement(4,3);
		this.getPlateau()[4][4] = new Sommet(4,4);
		this.getPlateau()[4][5] = new Croisement(4,5);
		this.getPlateau()[4][6] = new Sommet(4,6);
		this.getPlateau()[4][7] = new Croisement(4,7);
		this.getPlateau()[4][8] = new Sommet(4,8);
		
		this.getPlateau()[5][0] = new Port(5,0);
		this.getPlateau()[5][1] = new Montagne(5,1,3);
		this.getPlateau()[5][2] = new Croisement(5,2);
		this.getPlateau()[5][3] = new Desert(5,3);
		this.getPlateau()[5][4] = new Croisement(5,4);
		this.getPlateau()[5][5] = new Champs(5,5,10);
		this.getPlateau()[5][6] = new Croisement(5,6);
		this.getPlateau()[5][7] = new Colline(5,7,6);
		
		this.getPlateau()[6][0] = new Sommet(6,0);
		this.getPlateau()[6][1] = new Croisement(6,1);
		this.getPlateau()[6][2] = new Sommet(6,2);
		this.getPlateau()[6][3] = new Croisement(6,3);
		this.getPlateau()[6][4] = new Sommet(6,4);
		this.getPlateau()[6][5] = new Croisement(6,5);
		this.getPlateau()[6][6] = new Sommet(6,6);
		this.getPlateau()[6][7] = new Croisement(6,7);
		this.getPlateau()[6][8] = new Sommet(6,8);
		
		this.getPlateau()[7][1] = new Colline(7,1,9);
		this.getPlateau()[7][2] = new Croisement(7,2);
		this.getPlateau()[7][3] = new Montagne(7,3,8);
		this.getPlateau()[7][4] = new Croisement(7,4);
		this.getPlateau()[7][5] = new Pre(7,5,5);
		this.getPlateau()[7][6] = new Croisement(7,6);
		this.getPlateau()[7][7] = new Foret(7,7,2);
		this.getPlateau()[7][8] = new Port(7,8);
		
		this.getPlateau()[8][1] = new Port(8,1);
		this.getPlateau()[8][2] = new Sommet(8,2);
		this.getPlateau()[8][4] = new Sommet(8,4);
		this.getPlateau()[8][5] = new Port(8,5);
		this.getPlateau()[8][6] = new Sommet(8,6);
	}

	public void affiche() {
		for(int i = 0 ; i < this.getPlateau().length; i++) {
			for(int j = 0 ; j < this.getPlateau()[i].length; j++) {
				if(this.getPlateau()[i][j] != null) {
					System.out.print("["+this.getPlateau()[i][j]+"] ");
				} else {
					
					System.out.print("[ ] ");
				}	
			}
			System.out.println();
		}
		
	}
	
	public boolean poserRoute(int x, int y) {
		if(!this.horsPlateau(x, y) && !this.estVide(x, y) && this.getPlateau()[x][y].estCroisement()) {
			if(!((Croisement)this.getPlateau()[x][y]).isRoute()) {
				((Croisement)this.getPlateau()[x][y]).setRoute(true);
				return true;
			} else {
				System.out.println("Il y a déjà une route ici !");
			}
		} else {
			System.out.println("Vous ne pouvez pas poser de route ici !");
		}
		return false;
	}
	
	public boolean poserColonie(int x, int y) {
		if(!this.horsPlateau(x, y) && !this.estVide(x, y) && this.getPlateau()[x][y].estSommet()) {
			if(!((Sommet)this.getPlateau()[x][y]).isColonie() && !((Sommet)this.getPlateau()[x][y]).isVille()) {
				((Sommet)this.getPlateau()[x][y]).setColonie(true);
				return true;
			} else {
				System.out.println("Il y a déjà une colonie ou une ville ici !");
			}
		} else {
			System.out.println("Vous ne pouvez pas poser de colonie ici !");
		}
		return false;
	}
	
	public boolean poserVille(int x, int y) {
		if(!this.horsPlateau(x, y) && !this.estVide(x, y) && this.getPlateau()[x][y].estSommet()) {
			if(((Sommet)this.getPlateau()[x][y]).isColonie()) {
				((Sommet)this.getPlateau()[x][y]).setVille(true);
				((Sommet)this.getPlateau()[x][y]).setColonie(false);
				return true;
			} else {
				System.out.println("Vous ne pouvez pas poser de ville ici ! (Il n'y a pas de colonie)");
			}
		} else {
			System.out.println("Vous ne pouvez pas poser de ville ici !");
		}
		return false;
	}
	
	public void changerVoleur(int x, int y) {
		this.voleur[0] = x;
		this.voleur[1] = y;
	}

	public Tuile[][] getPlateau() {
		return plateau;
	}
	
	public void donnerRessource(int alea) {
		//TODO: Donne la ressource associé au numéro de la tuile
	}
}
