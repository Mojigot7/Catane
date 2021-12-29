package tuiles;

import java.awt.Color;

import colors.ConsoleColors;
import plateau.Tuile;

public class Croisement extends Tuile {
	private boolean route;
	private Color couleur;
	
	public Croisement() {
		super(-1,"",false);
		this.route = false;
	}

	@Override
	public boolean estCroisement() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean estSommet() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estPort() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estTuile() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean peutEtreVoleur() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isRoute() {
		return route;
	}

	public void setRoute(boolean route) {
		this.route = route;
	}
	
	public String toString() {
		if(this.isRoute()) {
			if(this.couleur.getRGB() == Color.BLUE.getRGB()) {
				return ConsoleColors.BLUE+"R"+ConsoleColors.RESET;
			}
			if(this.couleur.getRGB() == Color.RED.getRGB()) {
				return ConsoleColors.RED+"R"+ConsoleColors.RESET;
			}
			if(this.couleur.getRGB() == Color.GREEN.getRGB()) {
				return ConsoleColors.GREEN+"R"+ConsoleColors.RESET;
			}
			if(this.couleur.getRGB() == Color.YELLOW.getRGB()) {
				return ConsoleColors.YELLOW+"R"+ConsoleColors.RESET;
			}
		}
		return " ";
	}

	public Color getCouleur() {
		return couleur;
	}

	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

}