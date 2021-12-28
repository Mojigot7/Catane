package tuiles;

import plateau.Tuile;

public class Colline extends Tuile {
	private boolean voleur;
	
	public Colline(int num) {
		super(num, "ARGILE");
		this.voleur = false;
	}
	
	@Override
	public boolean estCroisement() {
		return false;
	}
	@Override
	public boolean estSommet() {
		return false;
	}
	@Override
	public boolean estPort() {
		return false;
	}
	@Override
	public boolean estTuile() {
		return true;
	}
	@Override
	public boolean peutEtreVoleur() {
		return true;
	}
	public boolean isVoleur() {
		return voleur;
	}
	public void setVoleur(boolean voleur) {
		this.voleur = voleur;
	}

}
