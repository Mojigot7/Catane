package tuiles;

import plateau.Tuile;

public class Foret extends Tuile {
	
	public Foret(int num) {
		super(num,"BOIS",false);
	}
	
	@Override
	public boolean estCroisement() {
		// TODO Auto-generated method stub
		return false;
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
		return true;
	}
	@Override
	public boolean peutEtreVoleur() {
		// TODO Auto-generated method stub
		return true;
	}

}