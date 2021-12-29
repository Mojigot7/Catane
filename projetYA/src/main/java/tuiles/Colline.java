package tuiles;

import plateau.Tuile;

public class Colline extends Tuile {
	
	public Colline(int num) {
		super(num, "ARGILE",false);
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