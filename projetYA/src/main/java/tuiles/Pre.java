package tuiles;

import plateau.Tuile;

public class Pre extends Tuile {
	private boolean voleur;
	
	public Pre(int x, int y, int num) {
		super(x, y, num);
		this.voleur = false;
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
	public boolean isVoleur() {
		return voleur;
	}
	public void setVoleur(boolean voleur) {
		this.voleur = voleur;
	}

}
