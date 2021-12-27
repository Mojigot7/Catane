package tuiles;

import plateau.Tuile;

import java.awt.Color;

public class Sommet extends Tuile {
	private boolean colonie;
	private boolean ville;
	
	public Sommet(int x, int y) {
		super(x, y,-1);
		this.colonie = false;
		this.ville = false;
		this.setCouleur(null);
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
			return "C";
		} else {
			if(this.isVille()) {
				return "V";
			}
		}
		return " ";
	}

}
