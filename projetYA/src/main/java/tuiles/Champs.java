package tuiles;

import plateau.Tuile;

public class Champs extends Tuile {
	private boolean voleur;
	
	public Champs(int num) {
		super(num, "BLE");
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
