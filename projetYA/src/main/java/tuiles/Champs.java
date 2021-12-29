package tuiles;

import plateau.Tuile;

public class Champs extends Tuile {
	
	public Champs(int num) {
		super(num, "BLE",false);
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

}