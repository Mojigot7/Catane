package tuiles;

import plateau.Tuile;

public class Desert extends Tuile {
	private boolean voleur;
	
	public Desert(int x, int y) {
		super(x, y, 0);
		this.voleur = true;
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
