package tuiles;

import plateau.Tuile;

import colors.ConsoleColors;
import joueur.Joueur;

import java.awt.Color;

public class Sommet extends Tuile {
	private boolean colonie;
	private boolean ville;
	private Color couleur;
	private Joueur occupation;
	
	public Sommet() {
		super(-1,"",false);
		this.colonie = false;
		this.ville = false;
		this.occupation = null;
	}

	@Override
	public boolean estCroisement() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estSommet() {
		// TODO Auto-generated method stub
		return true;
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

	public boolean isColonie() {
		return colonie;
	}

	public void setColonie(boolean colonie) {
		this.colonie = colonie;
	}

	public boolean isVille() {
		return ville;
	}

	public void setVille(boolean ville) {
		this.ville = ville;
	}
	
	public String toString() {
		if(this.isColonie()) {
			if(this.couleur.getRGB() == Color.BLUE.getRGB()) {
				return ConsoleColors.BLUE+"C"+ConsoleColors.RESET;
			}
			if(this.couleur.getRGB() == Color.RED.getRGB()) {
				return ConsoleColors.RED+"C"+ConsoleColors.RESET;
			}
			if(this.couleur.getRGB() == Color.GREEN.getRGB()) {
				return ConsoleColors.GREEN+"C"+ConsoleColors.RESET;
			}
			if(this.couleur.getRGB() == Color.YELLOW.getRGB()) {
				return ConsoleColors.YELLOW+"C"+ConsoleColors.RESET;
			}
		} else {
			if(this.isVille()) {
				if(this.couleur.getRGB() == Color.BLUE.getRGB()) {
					return ConsoleColors.BLUE+"V"+ConsoleColors.RESET;
				}
				if(this.couleur.getRGB() == Color.RED.getRGB()) {
					return ConsoleColors.RED+"V"+ConsoleColors.RESET;
				}
				if(this.couleur.getRGB() == Color.GREEN.getRGB()) {
					return ConsoleColors.GREEN+"V"+ConsoleColors.RESET;
				}
				if(this.couleur.getRGB() == Color.YELLOW.getRGB()) {
					return ConsoleColors.YELLOW+"V"+ConsoleColors.RESET;
				}
			}
		}
		return " ";
	}
	
	public Color getCouleur() {
		return this.couleur;
	}
	
	public void setCouleur(Color c) {
		this.couleur = c;
	}

	public Joueur getOccupation() {
		return occupation;
	}

	public void setOccupation(Joueur occupation) {
		this.occupation = occupation;
	}

}